package service.impl;

import java.util.List;

import pojo.Pest;

import com.framework.core.page.Pagination;

import service.IPestService;
import dao.IPestDao;

public class PestImpl implements IPestService {

	private IPestDao pestDao;

	
	public IPestDao getPestDao() {
		return pestDao;
	}

	public void setPestDao(IPestDao pestDao) {
		this.pestDao = pestDao;
	}

	public void add(Pest pest) {
		// TODO Auto-generated method stub
		pestDao.add(pest);
	}

	
	
	public Pagination<Pest> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		return pestDao.page(pageno, pageSize);
	}

	public void modify(Pest pest) {
		// TODO Auto-generated method stub
		pestDao.modify(pest);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		pestDao.delete(id);
	}

	public Pest findPestById(int id) {
		// TODO Auto-generated method stub
		return pestDao.findPestById(id);
	}

	public List<Pest> allList() {
		// TODO Auto-generated method stub
		return pestDao.allList();
	}
	public List<Pest> searchByOtherName(String othername){
		return pestDao.searchByOtherName(othername);
	}

	public Pagination<Pest> page(int pageno, int pageSize, String name) {
		return this.pestDao.page(pageno, pageSize, name);
	}
}
