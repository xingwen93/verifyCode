package action.action;
/**
 * @author ZhangJing
 * @version 创建时间：2016年6月12日 上午10:51:23
 * action 的三种写法之方式一：不实现任何借口，不继承任何类
 */
public class UserAction_1 {
	public String login(){
		System.out.println("login 方法");
		return "success";
	}
}
