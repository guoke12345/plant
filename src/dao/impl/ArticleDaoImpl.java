package dao.impl;

import java.util.List;

import pojo.Article;
import pojo.User;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IArticleDao;
public class ArticleDaoImpl extends GenericHibernateDao<Article,Integer> implements IArticleDao{
	private ArticleDaoImpl(){
		super(Article.class);//实现User类的重载
	}
	/**
	 * 
	 * 方法名：findArticleByType<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月14日-下午2:03:24 <BR>
	 * @param type
	 * @return List<User><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<Article> findArticleByType(int type) {
		String hql ="from Article where type=? order by id desc";
		 Object[] params={type};
		 List<Article> list =this.findByHql(hql, params);
		return list;
	}
	/**
	 * 添加
	 */
	public void add(Article art) {
		this.save(art);
	}
	/**
	 * 修改
	 */
	public void modify(Article art){
		this.update(art);
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
	public Article art(int id){
		return this.findById(id);
	}
	/**
	 * 查找所有列表
	 */
	public List<Article> allList(){
		return this.findAll();
	}
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Article> page(int pageno, int pageSize) {
		String hql="from Article as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
	}
	
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<Article> pageType(int pageno, int pageSize,int type) {
		String hql="from Article as a where type = ? order by id desc";
		Object [] params={type};
		return this.findByPage(pageno, pageSize,hql,params);
	}
}
