package service.impl;
import java.util.List;

import pojo.User;
import service.IUserService;

import com.framework.core.page.Pagination;

import dao.IUserDao;
public class UserServiceImpl implements IUserService{
	private IUserDao userDao;

	/*
	 * 添加一个用户
	 * (non-Javadoc)
	 * @see service.IUserService#Add(pojo.User)
	 */

	public List<User> findByUserName(String userName) {
		List<User> list =userDao.findByUserName(userName);
		return list;
	}
	
	public void add(User user) {
		userDao.add(user);
	}
	
	public Pagination<User> page(int pageno, int pageSize) {
		return userDao.page(pageno, pageSize);
	}

	public void modify(User user) {
		userDao.modify(user);
		
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}

	public User art(int id) {
		return userDao.art(id);
	}

	public List<User> allList() {
		return userDao.allList();
	}

	public Pagination<User> pageType(int pageno, int pageSize, int type) {
		return userDao.pageType(pageno, pageSize, type);
	}
	
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> findByType(int type) {
		return userDao.findByType(type);
	}

}
