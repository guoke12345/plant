package service;

import java.util.List;

import pojo.Headimg;

import com.framework.core.page.Pagination;

public interface IHeadimgService {
	public void add(Headimg headimg);
	public void delete(int id);
	public Headimg findone(int id);
	public List<Headimg> findAllImg();
	public Pagination<Headimg> page(int pageno, int pageSize);
}
