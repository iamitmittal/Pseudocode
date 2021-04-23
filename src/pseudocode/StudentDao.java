package pseudocode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

//Database query

public class StudentDao {
	static String userName;
	
	//Add user to login table
	public static String insertStudentToDao(Student student) {
		String msg = null;
		
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "insert into login (username, password, firstname, lastname) values(?,?,?,?)";
			
			//Prepared Statement to insert the data
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//Set the values
			pstmt.setString(1, student.getEmail());
			pstmt.setString(2, student.getPass());
			pstmt.setString(3, student.getFirst());
			pstmt.setString(4, student.getLast());
			
			//Execute the query
			pstmt.executeUpdate();
			
			String query_pic = "INSERT INTO picture VALUES(?,?)";
			
			PreparedStatement pstmt2 = con.prepareStatement(query_pic);
			
			//Set the values
			pstmt2.setString(1, student.getEmail());
			pstmt2.setNull(2, java.sql.Types.BLOB);
			
			//Execute the query
			int result = pstmt2.executeUpdate();
			
			if(result==0) {
				msg = "Please try again";
			}else {
				msg = "Your picture updated successfully";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	//Check user in login table
	public static Boolean checkUser(String email, String pass) {
		boolean flag = false;
 
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "Select * from login where username= '"+email+"' and password= '"+pass+"'";
			
			//Statement to select the data
			Statement stmt = con.createStatement();
			ResultSet result=stmt.executeQuery(query); 
			
			if(result.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//Get user details from login table and add into ArrayList to display
	public static ArrayList<String> displayStudent(String email) {
		
		userName = email;
		
		ArrayList<String> detail = new ArrayList<>();
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "select * from login where username= '"+userName+"'";
			
			//Statement to select the data
			Statement stmt = con.createStatement();
		
			ResultSet result=stmt.executeQuery(query); 

			while(result.next()) {
				String username = result.getString(1);
				String first = result.getString(3);
				String last = result.getString(4);
				
				detail.add(0, username);
				detail.add(1, first);
				detail.add(2, last);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return detail;
	}

	//Put notes in DB
	public static void insertNotes(String username, String title, String text, String date) {
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "insert into notes (username, title, text, created_at) values(?,?,?,?)";
			
			//Prepared Statement to insert the data
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//Set the values
			pstmt.setString(1, username);
			pstmt.setString(2, title);
			pstmt.setString(3, text);
			pstmt.setDate(4, java.sql.Date.valueOf(date));
			
			//Execute the query
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Show Notes
	public static ArrayList<String> showNotes() {
		ArrayList<String> displayNotes = new ArrayList<>();
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "select * from notes where username= '"+userName+"'";
			
			//Statement to select the data
			Statement stmt = con.createStatement();
		
			ResultSet result=stmt.executeQuery(query); 

			while(result.next()) {
				String title = result.getString(2);
				String text = result.getString(3);

				Date date = result.getDate(4);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = dateFormat.format(date);
				
				displayNotes.add(0, title);
				displayNotes.add(1, text);
				displayNotes.add(2, dateStr);
				System.out.println(dateStr);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		return displayNotes;
	}
	
	//Update password
	public static boolean updatePassword(String email, String first, String pass) {
		boolean flag = false;
		 
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "update login SET password = "+pass+"where LOWER(username)=LOWER('"+email+"') and LOWER(firstname)=LOWER('"+first+"')";
			
			System.out.println(query);
			
			//Statement to select the data
			Statement stmt = con.createStatement();
			ResultSet result=stmt.executeQuery(query); 
			
			if(result.next()) {
				flag = true;
			}
			else {
				flag = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//Insert picture
	public static String insertPicture(String userName, InputStream inputStream) {
		String msg = "";
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "update picture set image = ? where username = '"+userName+"'";
				
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setBlob(1, inputStream);
			
			int returCode = pstmt.executeUpdate();
			
			System.out.println(query +" "+returCode);
			
			if(returCode==0) {
				msg = "Error inserting file";
			}else {
				msg = "Your picture updated successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return msg;
	}
	
	//Show details- Admin Panel
	public static ArrayList<String> showDetailsAdmin() {
		ArrayList<String> displayUsers = new ArrayList<>();
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "select * from login";
			
			//Statement to select the data
			Statement stmt = con.createStatement();
		
			ResultSet result=stmt.executeQuery(query); 

			while(result.next()) {
				String username = result.getString(1);
				String firstname = result.getString(3);
				String lastname = result.getString(4);
				
				displayUsers.add(0, username);
				displayUsers.add(1, firstname);
				displayUsers.add(2, lastname);
			}
			System.out.println(displayUsers);

		} catch(Exception e) {
			e.printStackTrace();
		}
		return displayUsers;
	}
	
	//Remove user- Admin Panel
	public static String removeUser(String user) {
		String msg = "";
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "delete from login where username = '"+user+"'";
			
			System.out.println(query);
				
			PreparedStatement pstmt = con.prepareStatement(query);

			int returCode = pstmt.executeUpdate();
			
			if(returCode==0) {
				msg = "Error deleting user";
			}else {
				msg = "Your record deleted successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return msg;
	}

	//Delete Notes
	public static String deleteNotes(String deleteNotesTitle) {
		String msg = null;
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "delete from notes where title = '"+deleteNotesTitle+"'";
			
			System.out.println(query);
				
			PreparedStatement pstmt = con.prepareStatement(query);

			int result = pstmt.executeUpdate();
			
			if(result==0) {
				msg = "Error in updating";
			}else {
				msg = "Your record deleted successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return msg;
	}
	
	//Update user details from Admin
	public static String updateUserDetails(String oldUser, String newFirst, String newLast, String newUser) {
		String msg = "";
		try {
			//Connection created 
			Connection con = DBConnection.createC(); 
			String query = "update login SET firstname = '"+newFirst+"', lastname = '"+newLast+"', username = '"+newUser+
							"' where LOWER(username)=LOWER('"+oldUser+"')";
			
			System.out.println(query);
			
			PreparedStatement pstmt = con.prepareStatement(query);

			int returCode = pstmt.executeUpdate();
			
			if(returCode==0) {
				msg = "Error in updating user";
			}else {
				msg = "Your record updated successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return msg;
	}
		
	//Display picture
	public static String displayPicture(String userName) {

		String pic = null;
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "select image from picture where username = '"+userName+"'";
	
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet resultset=pstmt.executeQuery(query); 
			
			
			if (resultset.next()) {
				Blob bl = resultset.getBlob("image");
			    byte[] pict = bl.getBytes(1,(int)bl.length());
			    String encodedImage = Base64.getEncoder().encodeToString(pict);
			    pic="data:image/jpg;base64,"+encodedImage;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pic;
	}
	
	//Insert document
	public static String insertDocument(String userName, String filename, InputStream inputStream) {
		String msg = "";
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "insert into documents (username, filename, doc) values(?,?,?)";
				
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, filename);
			pstmt.setBlob(3, inputStream);
			
			int returCode = pstmt.executeUpdate();
			
			System.out.println(query +" "+returCode);
			
			if(returCode==0) {
				msg = "Error inserting file";
			}else {
				msg = "Your document updated successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return msg;
	}
	
	//Delete document
	public static String deleteDocument(String filename) {
		String msg = "";
		try {
						
			Connection con = DBConnection.createC(); 
			
			String query = "delete from documents where filename = '"+filename+"'";
				
			PreparedStatement pstmt = con.prepareStatement(query);
			
			int returCode = pstmt.executeUpdate();
			
			if(returCode==0) {
				msg = "Error in updating";
			}else {
				msg = "Your record deleted successfully";
		}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		return msg;
	}
	
	//Display document name
	public static ArrayList<String> displayDocumentName(String userName) {
			ArrayList<String> displayNames = new ArrayList<>();
			try {
				//Connection created 
				Connection con = DBConnection.createC(); 
				String query = "select filename from documents where username= '"+userName+"'";
				
				//Statement to select the data
				Statement stmt = con.createStatement();
			
				ResultSet result=stmt.executeQuery(query); 

				while(result.next()) {
					String text = result.getString(1);
					displayNames.add(0, text);
				}
				System.out.println(displayNames);
			} catch(Exception e) {
				e.printStackTrace();
			}
			return displayNames;
		}
	
	//Download document
	public static void downloadDocument(String userName, String filename) {
			Connection conn = null;
			Statement stmt = null;
			InputStream input = null;
			ResultSet rs = null;	
			FileOutputStream output = null;
			
			try {
				conn = DBConnection.createC();
				String SQL = "select doc from documents where username = '"+userName+"'";
		
				stmt = conn.createStatement();
				
				rs=stmt.executeQuery(SQL); 
		
				output = new FileOutputStream(new File("C:/"+filename));
		        System.out.println("Getting file please be patient..");
		        
		        while (rs.next()) {
		            input = rs.getBinaryStream("doc"); //get it from col name
		            int r = 0;
		
		            while ((r = input.read()) != -1) {
		                output.write(r);
		            	}
		        	}
			     System.out.println("File writing complete !");
			
			    } catch (SQLException e) {
			        System.err.println("Connection failed!");   
			        e.printStackTrace();
			    } catch (FileNotFoundException e) {
			        System.err.println("File not found!");
			        e.printStackTrace();
			    } catch (IOException e) {
			        System.err.println("File writing error..!");
			        e.printStackTrace();
			    }finally {
			        if(rs != null){
			            try {
			                input.close();
			                output.flush();
			                output.close();
			                stmt.close();
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
			
