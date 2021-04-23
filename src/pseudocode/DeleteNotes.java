package pseudocode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteNotes")
public class DeleteNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteNotes() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Delete notes from table 
		String deleteNotesTitle =  request.getParameter("deletetitle");
		System.out.println(deleteNotesTitle);
		String messageAfterDel = StudentDao.deleteNotes(deleteNotesTitle);
		
		request.setAttribute("messageNote", messageAfterDel);

		
		RequestDispatcher updatedNotes = request.getRequestDispatcher("Notes.jsp");
		updatedNotes.forward(request, response);
	}

}
