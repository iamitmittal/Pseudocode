package pseudocode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteFile")
public class DeleteFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Delete notes from table 
		String deleteFile =  request.getParameter("deleteFileName");
		System.out.println(deleteFile);
		String messageAfterDel = StudentDao.deleteDocument(deleteFile);
		
		request.setAttribute("messageDeleteFile", messageAfterDel);

		
		RequestDispatcher updatedNotes = request.getRequestDispatcher("/Drive.jsp");
		updatedNotes.forward(request, response);
	}

}
