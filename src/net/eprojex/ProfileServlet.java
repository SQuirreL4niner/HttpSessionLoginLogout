package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		
		rq.getRequestDispatcher("link.html").include(rq, rs);
		
		HttpSession session = rq.getSession();
		if(session != null) {
			String name = (String)session.getAttribute("name");
			
			pw.print("Hello, " + name + "welcome to your PROFILE PAGE HA HA HAHAHAH!!!");
		}
		else {
			pw.print("Please Login First!!!!");
			rq.getRequestDispatcher("login.html").include(rq, rs);
		}
		pw.close();
		
	}

}
