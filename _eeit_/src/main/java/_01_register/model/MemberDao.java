package _01_register.model;

public interface MemberDao {
	
	public int saveMember(MemberBean mb) ;

	public boolean idExists(String id);
	
	public MemberBean queryMember(String id);
	
}