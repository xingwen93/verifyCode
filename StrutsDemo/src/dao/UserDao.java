package dao;

import entity.User;

public class UserDao {
	
	
	/**
	 * 通过用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserByUserAndPwd(String username,String password){
		if(username.equals("zhangjing")&& password.equals("123456")){
			return new User("zhangjing","123456");
		}
		return null;
	}

	/**
	 * 注册用户
	 * @param user
	 */
	public void save(User user) {
		String username = user.getPassword();
		String password = user.getUsername();
		System.out.println("注册名是："+username+"，密码是："+password);
	}
	
}
