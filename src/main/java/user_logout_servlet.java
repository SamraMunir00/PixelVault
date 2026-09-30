

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class user_logout_servlet
 */


@WebServlet("/user_home.jsp")
public class user_logout_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_logout_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session=request.getSession(false);
		
		String name=(String)session.getAttribute("name");
		PrintWriter out=response.getWriter();
		if(session!=null) {
			if("user".equals(session.getAttribute("type")) && name.equals(session.getAttribute("name"))){
				session.invalidate();
				out.println("<html><ody>");
	        	
	        	out.println("</body></html>");
		        out.println("<html><body>");
		        out.print("alert('Log out successfully');");
		        out.println("</body></html>");
				response.sendRedirect("index.jsp");
			}
			else {
				 out.println("<html><ody>");
		        	
		        	out.println("</body></html>");
			        out.println("<html><body>");
			        out.print("alert('Access Denied');");
			        out.println("</body></html>");
				response.sendRedirect("index.jsp");
			}
		}else {
			out.println("<html><ody>");
        	
        	out.println("</body></html>");
	        out.println("<html><body>");
	        out.print("alert('Access Denied');");
	        out.println("</body></html>");
			response.sendRedirect("index.jsp");
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
