package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This is a real world example of a login/logout servlet using HttpSession
 * I will hard code the user password as admin123 since we are not using JDBC
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		
		rq.getRequestDispatcher("link.html").include(rq, rs);
		
		String name = rq.getParameter("name");
		String password = rq.getParameter("password");
		
		if(password.equals("admin123")) {
			pw.print("Welcome, " + name);
			HttpSession session = rq.getSession();
			session.setAttribute("name", name);
			
		}
		else {
			pw.print("Sorry, the username or password you entered is not valid");
			rq.getRequestDispatcher("login.html").include(rq, rs);
		}
		pw.close();
		
	}

}
