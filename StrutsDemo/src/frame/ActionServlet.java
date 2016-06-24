package frame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.action.UserAction;

/**
 * @author ZhangJing
 * @version 创建时间：2016年6月12日 上午10:07:18 类说明
 */
public class ActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		String reqName = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		System.out.println("reqName:"+reqName);
		
		String url = "";//跳转路径
		
		//调用操作类方法，
		if(reqName.equals("userLogin")){
			UserAction userAction = new UserAction();
			url = userAction.login(request, response);
		}else if(reqName.equals("userReg")){
			UserAction userAction = new UserAction();
			url = userAction.register(request,response);
		}
		
		//统一跳转
		if(url.startsWith("r")){
			url = url.substring(2);
			response.sendRedirect(request.getContextPath()+url);
		}else{
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
