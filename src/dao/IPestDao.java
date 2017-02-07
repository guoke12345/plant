package dao;

import java.util.List;

import pojo.Pest;

import com.framework.core.page.Pagination;

public interface IPestDao {
	/**
	 * 添加
	 */
	public void add(Pest pest);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Pest> page(int pageno, int pageSize);
	public Pagination<Pest> page(int pageno, int pageSize,String name);
	/**
	 * 修改
	 */
	public void modify(Pest pest);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Pest findPestById(int id);
	/**
	 * 查找所有列表
	 */
	public List<Pest> allList();
	/**
	 * 根据名字查询
	 * 方法名：searchByOtherName<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月9日-上午10:32:01 <BR>
	 * @param othername
	 * @return List<Pest><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<Pest> searchByOtherName(String othername);
	
}
