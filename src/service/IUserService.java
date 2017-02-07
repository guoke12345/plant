package service;
import java.util.List;

import pojo.User;

import com.framework.core.page.Pagination;

public interface IUserService {
	/**
	 * 
	 * 方法名：findByUserName<BR>
	 * 创建人：yanjun<BR>
	 * 时间：2015年10月3日-下午7:26:14 <BR>
	 * @param userName
	 * @return List<User><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<User> findByUserName(String userName);
	
	/**
	 * 添加
	 */
	public void add(User user);
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<User> page(int pageno, int pageSize);
	/**
	 * 修改
	 */
	public void modify(User user);
	/**
	 * 删除
	 */
	public void delete(int id);
	public List<User> findByType(int i);
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
}
