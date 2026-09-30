

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class admin_logout
 */
public class admin_logout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		 
	    
	     response.setContentType("text/html");
			
		if(session.getAttribute("type")!=null) {
			if("admin".equals(session.getAttribute("type"))){
				session.invalidate();
				out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('logged out successfully');");
                out.println("window.location = 'index.jsp';");
                out.println("</script>");
                out.println("</body></html>");
				//response.sendRedirect("index.jsp");
			}
			else {
				
				out.println("<html><body>");
                out.println("<script type='text/javascript'>");
                out.println("alert('access denied');");
                out.println("window.location = 'index.jsp';");
                out.println("</script>");
                out.println("</body></html>");
				
			}
		}else {
			
        	
			out.println("<html><body>");
            out.println("<script type='text/javascript'>");
            out.println("alert('access denied');");
            out.println("window.location = 'index.jsp';");
            out.println("</script>");
            out.println("</body></html>");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
