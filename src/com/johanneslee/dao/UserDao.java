package com.johanneslee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.johanneslee.bean.User;

public class UserDao {
	public static Connection getConnection(){  
	    Connection con = null;  
	    try {  
	        Class.forName("com.mysql.jdbc.Driver");  
	        con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_305463a5a1be265","b3703c9a385d04","63106cae");  
	    }
	    catch(Exception e) {System.out.println(e);}  
	    return con;  
	}  
	public static int save(User u) {  
	    int status = 0;  
	    try {  
	        Connection con = getConnection();  
	        String sql = "INSERT INTO users (id, firstName, lastName, password, phone, email) values(?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);  
	        ps.setString(1,u.getId());  
	        ps.setString(4,u.getPassword());  
	        ps.setString(2,u.getFirstName());  
	        ps.setString(3,u.getLastName());  
	        ps.setString(5,u.getPhone());  
	        ps.setString(6,u.getEmail());  
	        status=ps.executeUpdate();  
	    }
	    catch(Exception e) {System.out.println(e);}
	    return status;
	}
	
	public static int update(User u){  
	    int status = 0;  
	    try {  
	        Connection con = getConnection();
	        String sql = "UPDATE users SET firstName=?,lastName=?,password=?,phone=?,email=? WHERE idx=?";
	        PreparedStatement ps = con.prepareStatement(sql); 
	        ps.setString(3,u.getPassword());  
	        ps.setString(1,u.getFirstName());    
	        ps.setString(2,u.getLastName());   
	        ps.setString(4,u.getPhone());  
	        ps.setString(5,u.getEmail());  
	        ps.setInt(6,u.getIdx());  
	        status=ps.executeUpdate();  
	    }
	    catch(Exception e) {System.out.println(e);}  
	    return status;  
	}  
	public static int delete(User u){  
	    int status = 0;  
	    try {  
	        Connection con = getConnection();  
	        PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE idx=?");  
	        ps.setInt(1,u.getIdx());  
	        status=ps.executeUpdate();  
	    }
	    catch(Exception e) {System.out.println(e);}  
	  
	    return status;  
	}  
	
	public static List<User> getAllRecords(){  
	    List<User> list = new ArrayList<User>();  
	    try {  
	        Connection con = getConnection();  
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM users");  
	        ResultSet rs = ps.executeQuery();  
	        while(rs.next()) {  
	            User u=new User();  
	            u.setIdx(rs.getInt("idx"));  
	            u.setId(rs.getString("id"));  
	            u.setPassword(rs.getString("password"));  
	            u.setFirstName(rs.getString("firstName"));  
	            u.setLastName(rs.getString("lastName"));  
	            u.setPhone(rs.getString("phone"));  
	            u.setEmail(rs.getString("email"));  
	            list.add(u);  
	        }  
	    }
	    catch(Exception e) {System.out.println(e);}  
	    return list;  
	}  
	public static User getRecordByIdx(int idx){  
	    User u = null;  
	    try {  
	        Connection con = getConnection();  
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE idx=?");  
	        ps.setInt(1,idx);  
	        ResultSet rs = ps.executeQuery();  
	        while(rs.next()){  
	            u = new User();  
	            u.setIdx(rs.getInt("idx"));  
	            u.setId(rs.getString("id"));  
	            u.setPassword(rs.getString("password"));  
	            u.setFirstName(rs.getString("firstName")); 
	            u.setLastName(rs.getString("lastName"));  
	            u.setPhone(rs.getString("phone"));  
	            u.setEmail(rs.getString("email"));  
	        }  
	    }
	    catch(Exception e) {System.out.println(e);}  
	    return u;  
	}  
}
