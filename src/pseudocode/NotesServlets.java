package pseudocode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;


@WebServlet("/Notes")
public class NotesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NotesServlets() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title =  request.getParameter("title");
		String text =  request.getParameter("alltext");
		
		System.out.println(title);
		System.out.println(text);
		
		//Real time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println(dtf.format(now));  
	    
	    //Retrieve value from session
	    String username = (String)request.getSession(false).getAttribute("username");
	    
	    //Inserting Data to insertNotes table with time
		String date = dtf.format(now);
		StudentDao.insertNotes(username, title, text, date);
		
		RequestDispatcher notes = request.getRequestDispatcher("Notes.jsp");
		notes.forward(request, response);
	}

}
