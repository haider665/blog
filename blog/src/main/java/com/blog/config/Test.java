package com.blog.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/blog"+"?autoReconnect=true&useSSL=false";
		String user= "root";
		String pass= "haider665";
		// set up connection
		try {
			Connection con = DriverManager.getConnection(url,user, pass);
			System.out.println("done");
		} catch (SQLException e) {
			System.out.println("not done");
			e.printStackTrace();
		}
		

	}

}
