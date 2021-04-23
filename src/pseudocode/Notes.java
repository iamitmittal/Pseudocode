package pseudocode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

//
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//

public class Notes extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {


//@WebServlet("/Notes")
//public class NotesServlets extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public NotesServlets() {
//        super();
//    }
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String title =  request.getParameter("title");
//		String text =  request.getParameter("alltext");
//		
//		System.out.println(title);
//		System.out.println(text);
//		
//		//Real time
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//	    LocalDateTime now = LocalDateTime.now();  
//	    System.out.println(dtf.format(now));  
//	    
//	    //Retrieve value from session
//	    String username = (String)request.getSession(false).getAttribute("username");
//	  
//		String date = dtf.format(now);
//		StudentDao.insertNotes(username, title, text, date);
		//
//		ArrayList<String> display = StudentDao.showNotes();
//		System.out.println(display);
//		
//		int i=0;
//		while(i<(display.size()-2)) {
//			try {
//				System.out.println("Title: "+display.get(i)+" Notes: "+display.get(i+1)+" Submit date: "+display.get(i+2));
//				i++;
//			}catch(ArrayIndexOutOfBoundsException e) {
//				break;
//			}
//		}
//		request.setAttribute("list", display);
	 
		
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Notes</title></head>");
	    out.println("<body>");
	    out.println("<center><h1>Digital Notes</h1>");
	    Connection conn = null;
	    Statement stmt = null;	    
	    try {
	      conn = DBConnection.createC(); 
	      stmt = conn.createStatement();
	      String orderBy = request.getParameter("sort");
	      if ((orderBy == null) || orderBy.equals("")) {
	        orderBy = "SSN";
	      }
	      String orderByDir = request.getParameter("sortdir");
	      if ((orderByDir == null) || orderByDir.equals("")) {
	        orderByDir = "asc";
	      }
	      String username = "jj";
	      String query = "select * from notes where username= '"+username+"'"+ ";";
	      ResultSet result = stmt.executeQuery(query);
	      while (result.next()) {
	    	  String sql_title = result.getString(2);
	    	  String sql_text = result.getString(3);
	    	  String sql_date = result.getString(4);
	    	  
	    	  out.print(sql_title + "::");
	    	  out.print(sql_text + "::");
	    	  out.print(sql_date + "::");
	      }
	    } catch (SQLException e) {
	      out.println("An error occured while retrieving " + "all employees: " 
	          + e.toString());
	    } finally {
	      try {
	        if (stmt != null) {
	          stmt.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
	      } catch (SQLException ex) {
	      }
	    }
	    out.println("</center>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	  }
		
		
	

}
