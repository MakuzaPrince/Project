package com.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
     
	Connection conn;
	PreparedStatement pst;
	public static int insertLogin(Bean bin) {
        int status = 0;

        if (bin == null || bin.email.trim().isEmpty() || bin.psswd.trim().isEmpty()){
            System.out.println("Invalid input: Null values exception!");
            return status;
        }
        try (Connection con = ConnectionProvider.getCon();
        	PreparedStatement pst = con.prepareStatement("insert into login values(?,?)")) {
                pst.setString(1, bin.email);
                pst.setString(2, bin.psswd);
                status = pst.executeUpdate();
                
       } catch (SQLException ex) {
           	System.out.println(ex);
        	//ex.printStackTrace();
       }
       return status;
    } 
	
	public static void selectLogin(Bean bin) {
        try (Connection con = ConnectionProvider.getCon();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM login")) {

            while (rs.next()) {
                String email = rs.getString("email");
                String psswd = rs.getString("psswd");
                System.out.println("Email: " + email + ", Password: " + psswd);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            //ex.printStackTrace();
        }
    }
//	public static List<Bean> selectLogin() {
//        List<Bean> loginList = new ArrayList<>();
//
//        try (Connection con = ConnectionProvider.getCon();
//             Statement st = con.createStatement();
//             ResultSet rs = st.executeQuery("SELECT * FROM login")) {
//
//            while (rs.next()) {
//                Bean bean = new Bean();
//                bean.setEmail(rs.getString("email"));
//                bean.setPsswd(rs.getString("psswd"));
//                loginList.add(bean);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            //ex.printStackTrace();
//        }
//
//        return loginList;
//    }
}


