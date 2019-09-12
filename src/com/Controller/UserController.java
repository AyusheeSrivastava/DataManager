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
import com.Service.UserService;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
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
		if ("register".equalsIgnoreCase(request.getParameter("action").toString()))
		{
			String first_name=request.getParameter("first_name");
			String last_name=request.getParameter("last_name");
			String password=request.getParameter("password");
			String user_id=request.getParameter("user_id");
			String email_id=request.getParameter("email_id");
			String phone_no=request.getParameter("phoneNo");
			String address=request.getParameter("address");
			User user=new User("0",first_name,last_name,user_id,password,email_id,phone_no,address);
			int status=0;
			Map<String,String> data= new HashMap<>();
			//PrintWriter out=response.getWriter();
			UserService ob=new UserService();
			status=ob.register(user);
			if(status==0)
			{
				//out.println("Error Encountered in User Registeration");
				data.put("status", "Failure");
			}
			else
			{
				//out.println("User Successfully Registered");
				data.put("status","Success");
			}
			String json= new Gson().toJson(data);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		}
		if("login".equalsIgnoreCase(request.getParameter("action")))
		{
			String user_id=request.getParameter("user_id");
			String password=request.getParameter("password");
			User user=new User();
			user.setUser_id(user_id);
			user.setPassword(password);
			Map<String,String> data= new HashMap<>();
			//PrintWriter out=response.getWriter();
			UserService obj=new UserService();
			javax.servlet.http.HttpSession session = request.getSession(false);
			
			if (((String)session.getAttribute("current_user_id"))==null)
			{
				session = request.getSession(true);
				data=obj.loginuser(user);
			}
			else if(((String)session.getAttribute("current_user_id")).equals(user_id))
			{
				data=obj.loginuser(user);
			}
			else
			{
				String name=(String) session.getAttribute("current_user_name");
				String alert_text=name+" Already Logged In.";
				data.put("status", alert_text);
			}
			
			String status=data.get("status");
			//Gson gson=new GsonBuilder().disableHtmlEscaping().create();
			String json=new Gson().toJson(data);
			System.out.println(json);
			System.out.println(status);
			if (status.equalsIgnoreCase("success"))
			{
				
				session.setAttribute("current_user_id", user_id);
				session.setAttribute("current_user_name", data.get("user_name"));
				//String nme=(String) session.getAttribute("user_id");
			}
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    response.getWriter().write(json); 
		}
		if("logout".equalsIgnoreCase(request.getParameter("action")))
		{
			javax.servlet.http.HttpSession session = request.getSession(false);
			session.setAttribute("current_user_id", null);
			session.setAttribute("current_user_name", null);
			response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    response.getWriter().write("success"); 
		}
		if("unique_userID".equals(request.getParameter("action")))
		{
			String user_id=request.getParameter("user_id");
			User user=new User();
			user.setUser_id(user_id);
			UserService obj=new UserService();
			int status=0;
			status=obj.unique_user(user);
			String data="";
			System.out.println(status);
			if(status==1)
			{
				data="Failure";
			}
			else
			{
				data="Success";
			}
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(data);
		}
	}

}
