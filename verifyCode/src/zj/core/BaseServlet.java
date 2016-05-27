package zj.core;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BaseServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求方法类似入: http://服务器地址:端口号/项目名/通配符?action=请求方法名
		// 例如: http://localhost:8080/项目名/user?action=login
		// 从用户的请求路径中获取请求方法名参数
		String methodName = request.getParameter("action");
		try {
			Method reqName = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class,
					HttpServletResponse.class);
			reqName.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
