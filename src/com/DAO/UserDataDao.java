package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Bean.UserData;
import com.Connection.ConnectionProvider;

public class UserDataDao {
	public String searchKey(UserData user)
	{
		 String value="";
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select usr_value from userdatas where usr_key='"+user.getKey()+"' and user_id='"+user.getUserId()+"'");
			ResultSet rs=ps.executeQuery();
			if(rs.isBeforeFirst()){
				while(rs.next())
				{
					value=rs.getString(1);
				}
			}
			else
			{
				value="";
			}
		}
		catch(Exception e)
		{
			//System.out.println("Here2"+e);
			e.printStackTrace();
		}
		return value;
	}
	
	public String manageKey(UserData user)
	{    int status=0;
		 String value="";
			System.out.println("aaaaa2222");
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select usr_value from userdatas where usr_key='"+user.getKey()+"' and user_id='"+user.getUserId()+"'" );
			ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					PreparedStatement ps1=con.prepareStatement("update userdatas set usr_value='"+user.getValue()+"' where usr_key='"+user.getKey()+"' ");
					status=ps1.executeUpdate();
					if(status!=0)
					{
						value="Data Updated Successfully";
					}
				}
				else {
					PreparedStatement ps2=con.prepareStatement("insert into userdatas(usr_key,usr_value,user_id) Values(?,?,?)");
					ps2.setString(1, user.getKey());
					ps2.setString(2, user.getValue());
					ps2.setString(3, user.getUserId());
					status=ps2.executeUpdate();
					if(status!=0)
					{
						value="Data Inserted Successfully";
					}
				}
		}
		catch(Exception e)
		{
			System.out.println("Here2"+e);
			e.printStackTrace();
		}
		return value;
	}

}
