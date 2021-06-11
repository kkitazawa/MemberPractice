package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.Member;


public class MemberDAO extends DAO{
	public int insert(Member member) throws Exception{
		Connection con = getConnection();
		
		
		PreparedStatement st = con.prepareStatement(
			"insert into members values(?, ?, ?, ?, ?, ?)");
		st.setString(1, member.getMemberNo());
		st.setString(2, member.getName());
		st.setString(3, member.getAge());
		st.setString(4, member.getBirthYear());
		st.setString(5, member.getBirthMonth());
		st.setString(6, member.getBirthDay());
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
