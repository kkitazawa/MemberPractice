package jp.co.aforce.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.SelectDAO;
import jp.co.aforce.beans.Member;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/jp.co.aforce.registration/change"})
public class Change extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		
		try {
			
			String memberNo = request.getParameter("memberNo");
			
			Member m = new Member();
			
			SelectDAO slcDao = new SelectDAO();
			
			m = slcDao.selectByMemberNo(memberNo);
			
		
			request.setAttribute("member", m);
			
			
		} catch(Exception e) {
			request.getRequestDispatcher("../jsp/failed.jsp").forward(request, response);
			
		}finally {
			request.getRequestDispatcher("../jsp/enteredChange.jsp").forward(request, response);
		}
		
		Page.footer(out);
	}
}
