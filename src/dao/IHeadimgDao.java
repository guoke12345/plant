package dao;

import java.util.List;

import com.framework.core.page.Pagination;

import pojo.Article;
import pojo.Headimg;

public interface IHeadimgDao {
	public void add(Headimg headimg);
	public void delete(int id);
	public Headimg findone(int id);
	public List<Headimg> findAllImg();
	public Pagination<Headimg> page(int pageno, int pageSize);
}
