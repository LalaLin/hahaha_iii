package _01_register.model;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;
import com.zaxxer.hikari.*;


// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberDaoImpl_Jdbc implements MemberDao {
//	private Connection con =null;
	private PreparedStatement pstmt;
	private DataSource ds = null;

	public MemberDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup( "java:/comp/env/jdbc/postgres");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
//	private Connection getConnection() throws SQLException {
//
//		
//		String connUrl = "jdbc:postgresql://localhost:5432/petdb";
//		String user = "postgres";
//		String password = "postgres";
//
//		// Connection conn = DriverManager.getConnection(connUrl, user,
//		// password);
//
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(connUrl);
//		config.setUsername(user);
//		config.setPassword(password);
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//		HikariDataSource ds = new HikariDataSource(config);
//
//		return ds.getConnection();
//	}

	// 儲存MemberBean物件
	public int saveMember(MemberBean mb) {
		String sql = "insert into Member " 
				+ " (memberID, name, password, address, email, tel) "
				+ " values (?, ?, ?, ?, ?, ?)";
		int n = 0;
		try ( 
			PreparedStatement ps = ds.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, mb.getMemberId());
			ps.setString(2, mb.getName());
//			String encrypedString = GlobalService.encryptString(mb.getPassword());
//			String tmp = GlobalService.getMD5Endocing(encrypedString);
			ps.setString(3, mb.getPassword());
			ps.setString(4, mb.getAddress());
			ps.setString(5, mb.getEmail());
			ps.setString(6, mb.getTel());
			n = ps.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				mb.setSeqNo(rs.getInt(1));
			}

			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return n;
	}
	// 判斷參數id是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * FROM Member WHERE memberID = ?";
		try (
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);			) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return exist;
	}
	// 由MemberId來取得某個會員的所有資料
	@Override
	public MemberBean queryMember(String id) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member WHERE memberID = ?";
		try (
			PreparedStatement ps = ds.getConnection().prepareStatement(sql);) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setSeqNo(rs.getInt("seqNo"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return mb;
	}
}
