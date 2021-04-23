package pseudocode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.mail.*;
import javax.mail.internet.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Forget")
public class ForgetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ForgetPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email =  request.getParameter("email");
		String first =  request.getParameter("first");
		
		Random rand = new Random();
		int num = rand.nextInt(50 - 10 + 1) + 10;
		System.out.println("A"+email+" "+num);
		System.out.println("B"+email+" "+num);
		
		String [] recepients =new String[]{email};
		String [] bccRecepients =new String[]{"c0785472@mylambton.ca"};
		String subject ="Hey "+first +"! Password has been reset";
		String message ="Your new password: "+ num;
		
		//User check
		Boolean flag =  StudentDao.updatePassword(email, first, String.valueOf(num));
		if (flag) {
			new SendEmail().sendMail(recepients, bccRecepients, subject, message);
			request.setAttribute("msg","Password shared on email, please login here .");
			RequestDispatcher notes = request.getRequestDispatcher("login.jsp");
			notes.forward(request, response);
			
		}
		
		else {
			request.setAttribute("error","Please check your details once again.");
			RequestDispatcher rd=request.getRequestDispatcher("Forget.jsp");            
			rd.include(request, response);
		}
		
	}

}
