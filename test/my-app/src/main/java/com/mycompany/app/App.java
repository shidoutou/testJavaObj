package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     //   System.out.println( "Hello World!" );
        try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
			 Statement stmt = conn.createStatement();
//			 stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INT, name VARCHAR(20), age INT, PRIMARY KEY(id))");
			 stmt.executeUpdate("INSERT INTO students (name, age) VALUES ('Alice', 20), ('Bob', 21), ('Charlie', 22)");
			    ResultSet rs = stmt.executeQuery("SELECT * FROM students");
	            while (rs.next()) {
	            	System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", age: " + rs.getInt("age"));
	            	
	            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
