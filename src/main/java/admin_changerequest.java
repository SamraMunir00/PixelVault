
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import classPackage.userData;
import classPackage.userExtended;
/**
 * Servlet implementation class admin_changerequest
 */

@WebServlet("admin_changerequest") 
public class admin_changerequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_changerequest() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	    String file_name = request.getParameter("file_name");
	    String name = request.getParameter("imagename");
	    String tags = request.getParameter("tags");
	    String desc = request.getParameter("desc");
	   
	    
	    PrintWriter out=response.getWriter();
	   
	    
	    
	    

		 ArrayList<userExtended>  userEData=new ArrayList<>();
	     
		userEData.add(new userExtended(username,password,file_name,name,tags,desc));
		request.setAttribute("userData", userEData);
	    request.getRequestDispatcher("admin_changeuser.jsp").forward(request, response);
		
	}

}
