package dao;

import java.util.List;

import pojo.Question;

import com.framework.core.page.Pagination;

public interface IQuestionDao {
	/**
	 * 添加
	 */
	public void add(Question art);
	/**
	 * 修改
	 */
	public void modify(Question art);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Question art(int id);
	public List<Question> fingByUser_id(int user_id);
	/**
	 * 查找所有列表
	 */
	public List<Question> allList();
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Question> page(int pageno, int pageSize) ;
	
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<Question> pageType(int pageno, int pageSize,int type);
	
}
