package service.impl;
import java.util.List;
import pojo.Article;
import pojo.Type;
import service.IArticleService;
import service.ITypeService;

import com.framework.core.page.Pagination;
import dao.IArticleDao;
import dao.ITypeDao;
public class TypeServiceImpl implements ITypeService{
	private ITypeDao typeDao;

	public ITypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(ITypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public List<Type> findByTypename(String typename) {
		// TODO Auto-generated method stub
		return typeDao.findByTypename(typename);
	}

	public Type findTypeById(int id) {
		// TODO Auto-generated method stub
		return typeDao.findTypeById(id);
	}

	public Type findByType(int type) {
		// TODO Auto-generated method stub
		return typeDao.findByType(type);
	}
	
	
}
