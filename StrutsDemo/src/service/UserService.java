package service;
import dao.UserDao;
import entity.User;
import exception.LoginFailureException;
public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public User login(User user) throws LoginFailureException{
		String username = user.getUsername();
		String password = user.getPassword();
		User loginUser = userDao.findUserByUserAndPwd(username, password);
		if(loginUser==null){//登录失败
			throw new LoginFailureException("用户名或者密码错误");
		}
		return loginUser;
		
	}
	
	/**
	 * 用户注册
	 * @param user
	 */
	public void register(User user){
		userDao.save(user);
	}
}
