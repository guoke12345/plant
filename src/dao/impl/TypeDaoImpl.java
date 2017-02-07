package dao.impl;

import java.util.List;

import pojo.Article;
import pojo.Type;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IArticleDao;
import dao.ITypeDao;
public class TypeDaoImpl extends GenericHibernateDao<Type,Integer> implements ITypeDao{
	private TypeDaoImpl(){
		super(Type.class);//实现User类的重载
	}

	public List<Type> findByTypename(String typename) {
		// TODO Auto-generated method stub
		String hql="from Type as a where typename = ? order by id desc";
		Object [] params={typename};
		return this.findByHql(hql, params);
	}

	public Type findTypeById(int id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	public Type findByType(int type) {
		// TODO Auto-generated method stub
		String hql="from Type as a where type = ? order by id desc";
		Object [] params={type};
		return this.findByHql(hql, params).get(0);
	}

	
	
}
