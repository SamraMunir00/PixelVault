

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.*;

//@WebServlet("/index.html")
public class request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			String type=(String)session.getAttribute("type");
			
			 if(type==null) {
				 out.println("new bnda");
		    	  response.sendRedirect("index.html");
		      }
		      else if(type.equals("admin")) {
		    	  out.println("admin");
		    	  response.sendRedirect("admin_home.html");
		      }
		      else if(type.equals("user")) {
		    	  out.println("user");
		    	  response.sendRedirect("home_page_new.html");
		      }
		}
		else {
			response.sendRedirect("index.html");
		}
		out.close();
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
