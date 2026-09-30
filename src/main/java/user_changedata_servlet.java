
import classPackage.userData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classPackage.userExtended;

/**
 * Servlet implementation class user_changedata_servlet
 */
public class user_changedata_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_changedata_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("name");
	    String file_name = request.getParameter("file_name");
	    String name = request.getParameter("imagename");
	    String tags = request.getParameter("tags");
	    String desc = request.getParameter("desc");
	   
	    
	    PrintWriter out=response.getWriter();
	   
	    
	    
	    

		 ArrayList<userData>  userEData=new ArrayList<>();
	     
		userEData.add(new userData(file_name,name,tags,desc));
		request.setAttribute("userData", userEData);
	    request.getRequestDispatcher("user_changeData.jsp").forward(request, response);
		
	}

}
