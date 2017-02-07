package dao.impl;

import java.util.List;

import pojo.Question;
import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;
import dao.IQuestionDao;
public class QuestionDaoImpl extends GenericHibernateDao<Question,Integer> implements IQuestionDao{
	private QuestionDaoImpl(){
		super(Question.class);
	}
	/**
	 * 添加
	 */
	public void add(Question art) {
		this.save(art);
	}
	/**
	 * 修改
	 */
	public void modify(Question art){
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
	public Question art(int id){
		return this.findById(id);
	}
	/**
	 * 查找所有列表
	 */
	public List<Question> allList(){
		String hql = "from Question as q order by id desc";
		return this.findByHql(hql);
	}
	
	public List<Question> fingByUser_id(int user_id){
		String hql = "from Question as q where q.user_id = ?";
		Object [] params={user_id};
		return this.findByHql(hql, params);
	}
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Question> page(int pageno, int pageSize) {
		String hql="from Question as a order by id desc";
		
		return this.findByPage(pageno, pageSize,hql);
	}
	
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<Question> pageType(int pageno, int pageSize,int type) {
		String hql="from Question as a where type = ? order by id desc";
		Object [] params={type};
		return this.findByPage(pageno, pageSize,hql,params);
	}
}
