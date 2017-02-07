package dao;

import java.util.List;

import com.framework.core.page.Pagination;

import pojo.Diagnosis;
import pojo.User;

public interface IDiagnosisDao {
//	public List<Diagnosis> findDiagnosisByType(int type);
	/**
	 * 添加
	 */
	public void add(Diagnosis Diagnosis);
	
	public List<Diagnosis> findByDiseasesId(String diseases_id,int type);

	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Diagnosis> page(int pageno, int pageSize);
	/**
	 * 修改
	 */
	public void modify(Diagnosis art);
	/**
	 * 删除
	 */
	public void delete(int id);
	/**
	 * 根据ID查找   对象
	 */
	public Diagnosis art(int id);
	
	public List<Diagnosis> artListByParentId(int parent_id,int type);
	/**
	 * 查找所有列表
	 */
	public List<Diagnosis> allList();
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
//	public Pagination<Diagnosis> pageType(int pageno, int pageSize,int type);

}
