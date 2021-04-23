package pseudocode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Drive")
@MultipartConfig
public class FileUploadDB extends HttpServlet {
private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//Retrieve value from session
			    String username = (String)request.getSession(false).getAttribute("username");
			    
				//Get filename
				String filename1 = null;
	                for(Part part : request.getParts()){
	                    Collection<String> headers = part.getHeaders("content-disposition");
	                    if (headers == null)
	                        continue;
	                    for(String header1 : headers){
	                        System.out.println("CDH: " + header1);  
	                        File f = new File(header1);
	                        filename1 = f.getName().replace("\"", "");
	                        System.out.println(filename1);
	                    } 
	                    
                    Part filePart = request.getPart("file");
            		
            		InputStream inputStream = null;
            		
            		if (filePart != null) {
            			long fileSize = filePart.getSize();
            			String fileContent = filePart.getContentType();
            			inputStream = filePart.getInputStream();
            			String uploadNotification= StudentDao.insertDocument(username, filename1, inputStream);
            			System.out.println(uploadNotification);
            			request.setAttribute("File uploaded", uploadNotification);
            			getServletContext().getRequestDispatcher("/Drive.jsp").forward(request,response);
            		}
            		System.out.println("hello"+" "+filename1+" "+inputStream);
            		
            		ArrayList<String> display = StudentDao.displayDocumentName(username);
            		System.out.println(display);
            		
            		}
                }
			}
        