package action.action;

import com.opensymphony.xwork2.Action;

/**
 * @author ZhangJing
 * @version 创建时间：2016年6月12日 上午11:15:44
 * action 的三种写法二：实现Action的接口
 */
public class UserAction_2 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("默认方法");
		return SUCCESS;
	}
	
}
