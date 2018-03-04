package _01_register.model;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	Integer seqNo;
	String memberId;
	String name;
	String password;
	String address;
	String email;
	String tel;

	public MemberBean(Integer seqNo, String memberId, String name, String password, String address, String email,
			String tel) {
		this.seqNo = seqNo;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}

//	public MemberBean(String memberId, String name, String password, String address, String mail, String tel) {
//		this.memberId = memberId;
//		this.password = password;
//		this.name = name;
//		this.address = address;
//		this.email = mail;
//		this.tel = tel;
//	}

	public MemberBean() {
	}

	public Integer getSeqNo() {
		return seqNo;
	}
	
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String toString() {
		return "userid=" + memberId + "   password=" + password;
	}

}
