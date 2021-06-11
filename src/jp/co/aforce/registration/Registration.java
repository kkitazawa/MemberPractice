package jp.co.aforce.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

import jp.co.aforce.beans.Member;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/jp.co.aforce.registration/registration"})
public class Registration extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Page.header(out);
	
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
				"java:/comp/env/jdbc/database");
			Connection con = ds.getConnection();
			
			
			
			
			
			Member m = new Member();
			
			m.setMemberNo(request.getParameter("memberNo"));
			m.setName(request.getParameter("name"));
			m.setAge(request.getParameter("age"));
			m.setBirthYear(request.getParameter("birthYear"));
			m.setBirthMonth(request.getParameter("birthMonth"));
			m.setBirthDay(request.getParameter("birthDay"));
			
			
			
			
			
			
			
		
			
			PreparedStatement st = con.prepareStatement(
				"insert into members values(?, ?, ?, ?, ?, ?)");
			st.setString(1, m.getMemberNo());
			st.setString(2, m.getName());
			st.setString(3, m.getAge());
			st.setString(4, m.getBirthYear());
			st.setString(5, m.getBirthMonth());
			st.setString(6, m.getBirthDay());
			
			int line = st.executeUpdate();
			
			if (line > 0) {
				JOptionPane.showMessageDialog(null, "登録に成功しました");
			}
			
			st.close();
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
