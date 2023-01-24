/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConToDb;

import java.sql.*;

/**
 *
 * @author Dipak Mali
 */

public class ConectDb {
    	static Connection con=null;
    	public static Connection connect() {
		
	try {
			if(con==null) {
				 Class.forName("com.mysql.cj.jdbc.Driver");
			     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebc","root","");
			}
		
	}catch(Exception e) {}
	
	return con;
	}
	
    
    
}
