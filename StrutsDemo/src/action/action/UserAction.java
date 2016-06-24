package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import entity.User;
import exception.LoginFailureException;

/**
 * @author ZhangJing
 * @version 创建时间：2016年6月12日 上午10:15:34
 * 类说明
 */
public class UserAction {
	
	private UserService userService = new UserService();
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new User(username,password);
		try {
			User loginUser = userService.login(u);
			HttpSession session = request.getSession();
			session.setAttribute("user", loginUser);
		} catch (LoginFailureException e) {
			request.setAttribute("msg", "用户名或者密码错误!");
			//转发到登录页面
			return "/login.jsp";
		}
		return "r:/index.jsp";
	}
	//注册
	public String register(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "r:/register.jsp";
	}
	
	
	
}
