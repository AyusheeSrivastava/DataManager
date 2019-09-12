package com.DAO;

import java.sql.*;
import java.util.*;

import com.Bean.User;
import com.Connection.ConnectionProvider;

public class UserDao {
	public int register(User user)
	{
		int status=0;
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("Insert into users(first_name,last_name,user_id,password,email_id,phoneNo,address) values(?,?,?,?,?,?,?)");
			ps.setString(1, user.getFirst_name());
			ps.setString(2, user.getLast_name());
			ps.setString(3, user.getUser_id());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail_id());
			ps.setString(6, user.getPhone_no());
			ps.setString(7, user.getAddress());
			status=ps.executeUpdate();
			//System.out.println("Here1"+status);
		}
		catch(Exception e)
		{
			//System.out.println("Here2"+e);
			e.printStackTrace();
		}
		return status;
	}
	public HashMap<String,String> loginuser(User user)
	{
		String user_id=user.getUser_id();
		String password=user.getPassword();
		HashMap<String,String> data=new HashMap<>();
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("Select password,first_name,last_name,usrid from users where user_id='"+user_id+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
			 while(rs.next())
			{
				String pwd=rs.getString(1);
				System.out.println(pwd+"  "+password);
				if(password.equals(pwd))
				{
					String first_name=rs.getString(2);
					String last_name=rs.getString(3);
					String name=first_name+" "+last_name;
					data.put("status","Success");
					data.put("user_name", name);
					data.put("usrid", rs.getString(4));
				}
				else
				{
					data.put("status","Incorrect Password");
				}
			}
			}
			else
			{
				data.put("status","User Not Found");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public int unique_user(User user)
	{
		int status=0;
		try{
			Connection con=ConnectionProvider.getCon();
			System.out.println(user.getUser_id());
			PreparedStatement ps=con.prepareStatement("Select * from users where user_id='"+user.getUser_id()+"'");
			//String query="Select * from users where user_id='"+user.getUser_id()+"'";
			//Statement stmt=con.createStatement();
			//ResultSet rs=stmt.executeQuery(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Its here");
				status=1;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
	
