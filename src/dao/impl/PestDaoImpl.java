package dao.impl;

import java.util.List;

import pojo.Pest;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IPestDao;

public class PestDaoImpl extends GenericHibernateDao<Pest,Integer> implements IPestDao{
	private PestDaoImpl(){
		super(Pest.class);
	}

	/*
	 * 增加虫害
	 * (non-Javadoc)
	 * @see dao.IPestDao#add(pojo.Pest)
	 */
	public void add(Pest pest) {
		// TODO Auto-generated method stub
		this.save(pest);
		
		
	}
	
	
	public Pagination<Pest> page(int pageno, int pageSize,String name){
		String hql="from Pest as d where d.name like ? or d.othername like ? order by id desc";
		Object[] params={"%"+name+"%","%"+name+"%"};
		return this.findByPage(pageno, pageSize, hql, params);
	}

	/*
	 * 分页查找
	 * (non-Javadoc)
	 * @see dao.IPestDao#page(int, int)
	 */
	public Pagination<Pest> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Pest as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);

	}

	/*
	 * 修改虫害
	 * (non-Javadoc)
	 * @see dao.IPestDao#modify(pojo.Pest)
	 */
	public void modify(Pest pest) {
		// TODO Auto-generated method stub
		this.update(pest);
		
	}

	/*
	 * 根据ID删除虫害
	 * (non-Javadoc)
	 * @see dao.IPestDao#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.remove(id);
	}

	/*
	 * 根据ID查找虫害
	 * (non-Javadoc)
	 * @see dao.IPestDao#findPestById(int)
	 */
	public Pest findPestById(int id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	/*
	 * 返回所有的虫害列表
	 */
	public List<Pest> allList() {
		// TODO Auto-generated method stub
		return this.findAll();
	}
	
	public List<Pest> searchByOtherName(String othername){
		String hql ="from Pest where othername like ? or name = ? order by id desc";
		Object[] params={"%"+othername+"%","%"+othername+"%"};
		List<Pest> list =this.findByHql(hql, params);
		return list;
	}
}
