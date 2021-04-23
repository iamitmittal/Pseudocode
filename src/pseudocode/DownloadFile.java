package pseudocode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public DownloadFile() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Retrieve value from session
		String s = request.getParameter("downloadFileName");
		System.out.println(s);
		
		Connection conn = null;
	    java.sql.PreparedStatement smt = null;
	    InputStream input = null;
	    FileOutputStream output = null;
	    ResultSet rs = null;
	    
	    String DownloadNotification = null;
	    
		try {

	    	conn = DBConnection.createC();
			String SQL ="select doc from documents where filename = '"+s+"'";
	        smt = conn.prepareStatement(SQL);
	        rs = smt.executeQuery();

	        output = new FileOutputStream(new File("C:/Users/bunny/Pictures/"+s));
	        System.out.println("Getting file please be patient..");
	        
	        while (rs.next()) {
	            input = rs.getBinaryStream("doc"); //get it from col name
	            int r = 0;

	            while ((r = input.read()) != -1) {
	                output.write(r);
	            }
	        }
			        System.out.println("File writing complete !");
			        request.setAttribute("File saved in C drive!", DownloadNotification);
					getServletContext().getRequestDispatcher("/Drive.jsp").forward(request,response);
			
			    } catch (SQLException e) {
			        System.err.println("Connection failed!");  
			        
			        request.setAttribute("Connection failed!", DownloadNotification);
					getServletContext().getRequestDispatcher("/Drive.jsp").forward(request,response);
			        e.printStackTrace();
			        
			    } catch (FileNotFoundException e) {
			        System.err.println("File not found!");
			        
			        request.setAttribute("File not found!", DownloadNotification);
					getServletContext().getRequestDispatcher("/Drive.jsp").forward(request,response);
			        e.printStackTrace();
			        
			    } catch (IOException e) {
			        System.err.println("File writing error..!");
			        
			        request.setAttribute("File writing error..!!", DownloadNotification);
					getServletContext().getRequestDispatcher("/Drive.jsp").forward(request,response);
			        e.printStackTrace();
			        
			    }finally {
			        if(rs != null){
			            try {
			                input.close();
			                output.flush();
			                output.close();
			                smt.close();
			                conn.close();
			            } catch (SQLException e) {
			                System.err.println("Connot close connecton!");
			            } catch (IOException e) {
			                // TODO Auto-generated catch block
			                e.printStackTrace();
			            }

			        }
			  }
		
				
		}

	}
