package com.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.User;
import com.Bean.UserData;
import com.Service.UserDataService;
import com.Service.UserService;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserDataController
 */
@WebServlet("/UserDataController")
public class UserDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("search_key".equalsIgnoreCase(request.getParameter("action").toString()))
		{
			String key=request.getParameter("key");
			String userId=request.getParameter("userId");
			UserData usr=new UserData(key,"",userId);
			String data="";
			UserDataService ob=new UserDataService();
			data=ob.searchKey(usr);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(data);
			
		}
		
		if("manage_key".equalsIgnoreCase(request.getParameter("action").toString()))
		{
			System.out.println("aaaaa");
			String key=request.getParameter("key");
			String value=request.getParameter("value");
			String userId=request.getParameter("userId");
			UserData usr=new UserData(key,value,userId);
			String data="";
			UserDataService ob=new UserDataService();
			data=ob.manageKey(usr);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(data);
			
		}
	}

}
