package jp.co.aforce.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.beans.Member;
import jp.co.aforce.tool.Back;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/jp.co.aforce.registration/insert"})
public class Insert extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		

		Back.back(out);
		
		try {
			Member m = new Member();
			
			
			m.setMemberNo(m.getMemberNo());
			m.setName(request.getParameter("name"));
			m.setAge(request.getParameter("age"));
			m.setBirthYear(request.getParameter("birthYear"));
			m.setBirthMonth(request.getParameter("birthMonth"));
			m.setBirthDay(request.getParameter("birthDay"));
			
			
			

			//型を変換するparseIntとかに変える？
			
			String name = request.getParameter("name");
			String age = (request.getParameter("age"));
			String birthYear = (request.getParameter("birthYear"));
			String birthMonth = (request.getParameter("birthMonth"));
			String birthDay = (request.getParameter("birthDay"));
			String str = "";
			
			
			if(name.isEmpty() && age == str && birthYear == str && birthMonth == str && birthDay == str) {
				request.getRequestDispatcher("../jsp/menu.jsp").forward(request, response);
				return;
			}
			
			if(name.isEmpty()) {
				request.getRequestDispatcher("../jsp/notFilled.jsp").forward(request, response);
				return;
			}
			
			if(age == str|| birthYear == str || birthMonth == str || birthDay == str) {
				
				request.getRequestDispatcher("../jsp/notFilled.jsp").forward(request, response);
				return;
			}
						
			MemberDAO dao = new MemberDAO();
			int line = dao.insert(m);
							
				if (line > 0) {
					request.getRequestDispatcher("../jsp/success.jsp").forward(request, response);
					return;
				}
		
		}catch (Exception e) {
			request.getRequestDispatcher("../jsp/failed.jsp").forward(request, response);
			
			
			return;
		}
		Page.footer(out);
	}
}
