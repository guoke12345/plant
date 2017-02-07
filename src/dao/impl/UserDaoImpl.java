package dao.impl;

import java.util.List;

import pojo.Article;
import pojo.User;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IUserDao;

public class UserDaoImpl extends GenericHibernateDao<User,Integer> implements IUserDao{
	private UserDaoImpl(){
		super(User.class);//实现User类的重载
	}
	/**
	 * 添加
	 */
	public void add(User user) {
		this.save(user);
	}
	/**
	 * 修改
	 */
	public void modify(User user){
		this.update(user);
	}
	/**
	 * 删除
	 */
	public void delete(int id){
		this.remove(id);
	}
	/**
	 * 根据ID查找   对象
	 */
	public User art(int id){
		return this.findById(id);
	}
	/**
	 * 查找所有列表
	 */
	public List<User> allList(){
		return this.findAll();
	}
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<User> page(int pageno, int pageSize) {
		String hql="from User as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
	}
	
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<User> pageType(int pageno, int pageSize,int type) {
		String hql="from User as a where type = ? order by id desc";
		Object [] params={type};
		return this.findByPage(pageno, pageSize,hql,params);
	}


	public List<User> findByUserName(String userName) {
		String hql ="from User where userName=? order by id desc";
		 Object[] params={userName};
		 List<User> list =this.findByHql(hql, params);
		return list;
	}

	public List<User> findByType(int type) {
		String hql ="from User where type=? order by id desc";
		 Object[] params={type};
		 List<User> list =this.findByHql(hql, params);
		return list;
	}
	
	
}
