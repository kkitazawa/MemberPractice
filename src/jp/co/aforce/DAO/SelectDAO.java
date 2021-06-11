package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.aforce.beans.Member;

public class SelectDAO extends DAO{
	public Member selectByMemberNo(String memberNo) {
		
		//	これは要らない   List<Member> list = new ArrayList<>();
			
		//Connection con = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		Member m = new Member();
		
		
		try {
		String sql = ("select * from members where member_no = ?");
		
		ps = con.createStatement();
		ps.setString(1, memberNo);
		
		//ps = con.createStatement();
		
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			m.setName(rs.getString("name"));
			m.setAge(rs.getString("age"));
			m.setBirthYear(rs.getString("birthYear"));
			m.setBirthMonth(rs.getString("birthMonth"));
			m.setBirthDay(rs.getString("borthDay"));
		}
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			if (ps != null) {
				try {ps.close();} catch(SQLException ignore) {}
			}
			if(con != null) {
				try{con.close();} catch(SQLException ignore) {}
			}
		}
	
		return m;
	}

	
	public int update(Member member) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
			"update members set name = ?, age = ?, birthYear = ?, birthMonth  ?, birthDay = ? where member_no = ?");
		
		st.setString(1, member.getName());
		st.setString(2, member.getAge());
		st.setString(3, member.getBirthYear());
		st.setString(4, member.getBirthMonth());
		st.setString(5, member.getBirthDay());
		st.setString(6, member.getMemberNo());
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
}
