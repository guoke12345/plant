package dao;

import java.util.List;

import com.framework.core.page.Pagination;

import pojo.Article;
import pojo.User;

public interface IArticleDao {
	public List<Article> findArticleByType(int type);
	/**
	 * 添加
	 */
	public void add(Article article);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Article> page(int pageno, int pageSize);
	/**
	 * 修改
	 */
	public void modify(Article art);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Article art(int id);
	/**
	 * 查找所有列表
	 */
	public List<Article> allList();
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<Article> pageType(int pageno, int pageSize,int type);

}
