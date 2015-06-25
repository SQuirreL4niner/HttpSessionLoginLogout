package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		
		rq.getRequestDispatcher("link.html").include(rq, rs);
		rq.getRequestDispatcher("login.html").include(rq, rs);
		
		HttpSession session = rq.getSession();
		session.invalidate();
		
		pw.print("You are successfully logged out!!! Rejoice!!");
		
		pw.close();
		
	}

}
