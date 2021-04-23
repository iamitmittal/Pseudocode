package pseudocode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;


@WebServlet("/Image")
@MultipartConfig

public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static final String UPLOAD_DIR = "images";
    public String dbFileName = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uName = (String)request.getSession().getAttribute("username");
		Part filePart = request.getPart("file");
		
		System.out.println("hlo"+" "+uName);
		
		InputStream inputStream = null;
		
		if (filePart != null) {
			long fileSize = filePart.getSize();
			String fileContent = filePart.getContentType();
			inputStream = filePart.getInputStream();
			String msg= StudentDao.insertPicture(uName, inputStream);
			System.out.println(msg);
			request.setAttribute("profileupdated", msg);
			getServletContext().getRequestDispatcher("/Profile.jsp").forward(request,response);
		}
		System.out.println("hello"+" "+uName+" "+inputStream);
		
		}
		
	}