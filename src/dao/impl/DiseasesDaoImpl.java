package dao.impl;

import java.util.List;

import pojo.Diagnosis;
import pojo.Diseases;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IDiseasesDao;

public class DiseasesDaoImpl extends GenericHibernateDao<Diseases,Integer> implements IDiseasesDao{
	private DiseasesDaoImpl(){
		super(Diseases.class);
	}

	public void add(Diseases diseases) {
		// TODO Auto-generated method stub
		this.save(diseases);
	}

	

	public void modify(Diseases diseases) {
		// TODO Auto-generated method stub
		this.update(diseases);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		this.remove(id);
	}

	public Diseases findOne(int id) {
		// TODO Auto-generated method stub
		return findById(id);
	}

	public Pagination<Diseases> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Diseases as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
		
	}
	public Pagination<Diseases> page(int pageno, int pageSize,String name){
		String hql="from Diseases as d where d.name like ? or d.othername like ? order by id desc";
		Object[] params={"%"+name+"%","%"+name+"%"};
		return this.findByPage(pageno, pageSize, hql, params);
	}

	public List<Diseases> allList() {
		return this.findAll();
	}

	public List<Diseases> searchByOtherName(String othername){
		String hql ="from Diseases where othername like ? or name like ? order by id desc";
		Object[] params={"%"+othername+"%","%"+othername+"%"};
		List<Diseases> list =this.findByHql(hql, params);
		return list;
	}
}
