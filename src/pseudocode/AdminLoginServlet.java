package pseudocode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user =  request.getParameter("adminid");
		String pass = request.getParameter("password");
		
		if(user.equals("admin") && pass.equals("admin")){
			RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");            
			rd.include(request, response);
		}
		else {
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("AdminLogin.jsp");            
			rd.include(request, response);
		}
	}

}
