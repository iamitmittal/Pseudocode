package pseudocode;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String delete =  request.getParameter("delete");

		System.out.println("Check "+delete);
		
		//User check
		String flag =  StudentDao.removeUser(delete);
		request.setAttribute(flag,"Please try once again..");
		
		//Edit user details
		String oldUser =  request.getParameter("olduser");
		String newFirst =  request.getParameter("newFirst");
		String newLast =  request.getParameter("newLast");
		String newUser =  request.getParameter("newEmail");
		
		String flag2 = StudentDao.updateUserDetails(oldUser,newFirst,newLast,newUser);
		request.setAttribute(flag2,"Please try once again..");

		RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");  	          
		rd.forward(request, response);
	}

}
