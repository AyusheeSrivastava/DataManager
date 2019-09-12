package com.Service;

import com.Bean.UserData;
import com.DAO.UserDataDao;

public class UserDataService {
	public String searchKey(UserData user){
		UserDataDao ob=new UserDataDao();
		return ob.searchKey(user);
		}
	
	public String manageKey(UserData user){
		UserDataDao ob=new UserDataDao();
		return ob.manageKey(user);
	}

}
