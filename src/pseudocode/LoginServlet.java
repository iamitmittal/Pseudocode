package pseudocode;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email =  request.getParameter("email");
		String pass = request.getParameter("pass");
		
		System.out.println("Hey");
		System.out.println(email+" "+pass);
		
		//Session
		HttpSession session = request.getSession();
				
		//User check
		Boolean flag =  StudentDao.checkUser(email,pass);
		if (flag) {
			
			//Details saved into ArrayList to display
			ArrayList<String> st = StudentDao.displayStudent(email);
			
			session.setAttribute("username", st.get(0));
			session.setAttribute("first", st.get(1));
			session.setAttribute("last", st.get(2));
			
			RequestDispatcher notes = request.getRequestDispatcher("Notes.jsp");
			notes.forward(request, response);
			
			ArrayList<String> display = StudentDao.showNotes();
			request.setAttribute("list", display);
			System.err.println("Hey Yo");
			System.out.println(display);
		}
		
		else {
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");            
			rd.include(request, response);
		}
		
		
		
		
		
//		//request.setAttribute("username", st.get(0));
//		request.setAttribute("first", st.get(1));
//		request.setAttribute("last", st.get(2));
		
		
		
		
		
//		RequestDispatcher profile = request.getRequestDispatcher("Profile.jsp");
//		profile.forward(request, response);
//		
		
//		HttpSession session = request.getSession();
//		
//		response.getWriter().print("Hey! You logged in");
		
		
		
//		session.setAttribute("first", first);
//		session.setAttribute("last", last);
//		session.setAttribute("email", email);
//		session.setAttribute("pass", pass);
//		
//		Student student = new Student(first, last, email, pass);
		//StudentDao.insertStudentToDao(student);
		
		
		
//		RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
//		rd.forward(request, response);
		
		
		
	}

}
