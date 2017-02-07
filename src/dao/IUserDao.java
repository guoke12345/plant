package dao;

import java.util.List;

import com.framework.core.page.Pagination;

import pojo.User;

public interface IUserDao {

	public List<User> findByUserName(String userName);

	/**
	 * 添加
	 */
	public void add(User User);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<User> page(int pageno, int pageSize);
	/**
	 * 修改
	 */
	public void modify(User art);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public User art(int id);
	/**
	 * 查找所有列表
	 */
	public List<User> allList();
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<User> pageType(int pageno, int pageSize,int type);
	public List<User> findByType(int type);
}
