package service.impl;
import java.util.List;

import pojo.Headimg;
import service.IHeadimgService;

import com.framework.core.page.Pagination;

import dao.IHeadimgDao;

public class HeadimgImpl implements IHeadimgService{
	private IHeadimgDao headimgDao;

	public void add(Headimg headimg) {
		headimgDao.add(headimg);
		
	}

	public void delete(int id) {
		headimgDao.delete(id);
	}

	public Headimg findone(int id) {
		
		return headimgDao.findone(id);
	}

	public List<Headimg> findAllImg() {
		return headimgDao.findAllImg();
	}

	public Pagination<Headimg> page(int pageno, int pageSize) {
		
		return headimgDao.page(pageno, pageSize);
	}

	public IHeadimgDao getHeadimgDao() {
		return headimgDao;
	}

	public void setHeadimgDao(IHeadimgDao headimgDao) {
		this.headimgDao = headimgDao;
	}

}
