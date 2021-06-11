package jp.co.aforce.tool;

import java.io.PrintWriter;

public class Back {
	public static void back(PrintWriter out) {
		out.println("<button id = \"back\" onclick = \"location.href = 'menu.jsp'\">");
		out.println("戻る");
		out.println("</button>");
	}
}
