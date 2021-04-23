package pseudocode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String first =  request.getParameter("first");
		String last = request.getParameter("last");
		String email =  request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Student student = new Student(first, last, email, pass);
		StudentDao.insertStudentToDao(student);
		System.out.println(student.toString());
		
//		response.getWriter().print("Congratulations! Your account has been created.");
		request.setAttribute("accCreated","Congratulations! Your account has been created.");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
		
		System.out.println(first);
		//System.out.println(first);
		
	}

}
