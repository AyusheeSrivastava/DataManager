package com.Service;

import java.util.*;

import com.Bean.User;
import com.DAO.UserDao;

public class UserService {
	
	public int register(User user){
		UserDao ob=new UserDao();
		return ob.register(user);
		}
	public HashMap<String,String> loginuser(User user){
		UserDao ob=new UserDao();
		return ob.loginuser(user);
	}
	public int unique_user(User user)
	{
		UserDao ob=new UserDao();
		return ob.unique_user(user);
	}
	
}
