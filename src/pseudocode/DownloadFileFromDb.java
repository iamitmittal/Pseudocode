package pseudocode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class DownloadFileFromDb {
	static String s = null;
	 
	DownloadFileFromDb (String s){
		this.s = s;
	}

    public static void main(String[] args) throws ClassNotFoundException {

    Connection conn = null;
    java.sql.PreparedStatement smt = null;
    InputStream input = null;
    FileOutputStream output = null;
    ResultSet rs = null;

    try {

    	conn = DBConnection.createC();
		
		String SQL ="select doc from documents where username = 'dd'";

        smt = conn.prepareStatement(SQL);

        rs = smt.executeQuery();
        
//        String s = "Jsp Cheat Sheet.pdf";
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