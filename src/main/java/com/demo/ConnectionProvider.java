package com.demo;

import java.sql.*;

public class ConnectionProvider implements Provider {
	
	static Connection conn = null;
    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
	//private static final String jdbcURL = "jdbc:postgresql://host.docker.internal:5432/postgres";
    private static final String dbUsername = "postgres";
    private static final String dbPasswd = "";
	
	public static Connection getCon() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPasswd);
		} catch (Exception ex) {
			System.out.println(ex);
			//ex.printStackTrace();
		}
		return conn;
	}
}
