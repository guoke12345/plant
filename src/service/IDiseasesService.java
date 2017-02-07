package service;

import java.util.List;

import pojo.Diagnosis;
import pojo.Diseases;

import com.framework.core.page.Pagination;

public interface IDiseasesService {
	public Pagination<Diseases> page(int pageno, int pageSize,String name);
	/**
	 * 添加
	 */
	public void add(Diseases diseases);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Diseases> page(int pageno, int pageSize);
	/**
	 * 修改
	 */
	public void modify(Diseases diseases);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Diseases findOne(int id);
	/**
	 * 查找所有列表
	 */
	public List<Diseases> allList();
	public List<Diseases> searchByOtherName(String othername);
}
