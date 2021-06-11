package jp.co.aforce.tool;

import java.io.PrintWriter;

public class NotEntered {
	public static void notEntered(PrintWriter out) {
		out.println("<script>");
		out.println("alert('入力されていない項目があります');");
		out.println("location = 'menu.jsp'");
		out.println("</script>");
	}
}
