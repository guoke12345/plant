package dao.impl;

import java.util.List;

import pojo.Headimg;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;


import dao.IHeadimgDao;

public class HeadimgDaoImpl extends GenericHibernateDao<Headimg,Integer> implements IHeadimgDao{
	private HeadimgDaoImpl(){
		super(Headimg.class);
	}
	
	public void add(Headimg headimg) {
		this.save(headimg);
	}

	public void delete(int id) {
		this.remove(id);
	}

	public Headimg findone(int id) {
		return this.findById(id);
	}

	public List<Headimg> findAllImg() {
		String hql="from Headimg as a order by a.id desc";
		return this.findByHql(hql);
	}
	
	public Pagination<Headimg> page(int pageno, int pageSize) {
		String hql="from Headimg as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
	}
}
