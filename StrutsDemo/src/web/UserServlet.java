package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import exception.LoginFailureException;
import service.UserService;

public class UserServlet extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();
	
	//登录
	protected void login(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);		
		try {
			User loginUser=userService.login(user);
			//登录成功
			//将用户信息写进session中
			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);
			//重定向到首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (LoginFailureException e) {
			//登录失败，跑出登录异常
			//e.printStackTrace();
			request.setAttribute("msg", "用户名或者密码错误!");
			//转发到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	//注册
	protected void register(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		userService.register(user);
		//重定向到登录界面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
}