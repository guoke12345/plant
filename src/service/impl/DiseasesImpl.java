package service.impl;

import java.util.List;

import pojo.Diagnosis;
import pojo.Diseases;

import com.framework.core.page.Pagination;

import service.IDiseasesService;
import dao.IDiseasesDao;

public class DiseasesImpl implements IDiseasesService{
	private IDiseasesDao diseasesDao;
	public Pagination<Diseases> page(int pageno, int pageSize,String name){
		return this.diseasesDao.page(pageno, pageSize, name);
	}
	
	public IDiseasesDao getDiseasesDao() {
		return diseasesDao;
	}

	public void setDiseasesDao(IDiseasesDao diseasesDao) {
		this.diseasesDao = diseasesDao;
	}

	public void add(Diseases diseases) {
		// TODO Auto-generated method stub
		diseasesDao.add(diseases);
	}

	public Pagination<Diseases> page(int pageno, int pageSize) {
		// TODO Auto-generated method stub
		return diseasesDao.page(pageno, pageSize);
	}

	public void modify(Diseases diseases) {
		// TODO Auto-generated method stub
		diseasesDao.modify(diseases);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		diseasesDao.delete(id);
	}

	public Diseases findOne(int id) {
		// TODO Auto-generated method stub
		return diseasesDao.findOne(id);
	}

	public List<Diseases> allList() {
		// TODO Auto-generated method stub
		return diseasesDao.allList();
	}
	public List<Diseases> searchByOtherName(String othername){
		return diseasesDao.searchByOtherName(othername);
	}

}
