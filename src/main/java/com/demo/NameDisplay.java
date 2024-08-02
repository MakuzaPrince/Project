package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class NameDisplay
 */
public class NameDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(NameDisplay.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Hello, my name is Makuza "+" and my Id is 25540");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		logger.info("Entered Method");
		String email_check = request.getParameter("email");
		if (email_check == null || email_check.trim().isEmpty()) {
		    PrintWriter pw = response.getWriter();
		    pw.println("Please provide a valid email address");
		    logger.error("Invalid email");
		    pw.close();
		    return;
		}

		try {
		    String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
		    String dbUsername = "postgres";
		    String dbPasswd = "";
		    
		    Class.forName("org.postgresql.Driver");
		    Connection conn = DriverManager.getConnection(jdbcURL, dbUsername, dbPasswd);
		    
		    PreparedStatement pst = conn.prepareStatement("SELECT psswd FROM login WHERE email = ?");
		    pst.setString(1, email_check);
		    ResultSet rs = pst.executeQuery();
		    
		    if (rs.next()) {
		        String password = rs.getString("psswd");
		        logger.info("Email: " + email_check + " with password: " + password);
		        response.getWriter().print("Email: " + email_check + " with password: " + password);
		    } else {
		        response.getWriter().print("User doesn't exist");
		        logger.error("Invalid user");
		    }
		    
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		    response.getWriter().print("Database error: " + e.getMessage());
		    logger.error("Database error");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    response.getWriter().print("Driver not found: " + e.getMessage());
		    logger.error("Driver not found");
		} catch (Exception e) {
		    e.printStackTrace();
		    response.getWriter().print("Error: " + e.getMessage());
		    logger.warn("Error");
		}
	}

	/**
	 * @return the logger
	 */
//	public static Logger getLogger() {
//		return logger;
//	}

}
