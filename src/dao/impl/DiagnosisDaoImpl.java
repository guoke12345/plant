package dao.impl;

import java.util.List;

import org.apache.struts2.components.Param;

import pojo.Diagnosis;
import pojo.User;

import com.framework.core.daos.hibernate.GenericHibernateDao;
import com.framework.core.page.Pagination;

import dao.IDiagnosisDao;
public class DiagnosisDaoImpl extends GenericHibernateDao<Diagnosis,Integer> implements IDiagnosisDao{
	private DiagnosisDaoImpl(){
		super(Diagnosis.class);//实现User类的重载
	}

	/**
	 * 添加
	 */
	public void add(Diagnosis art) {
		this.save(art);
	}
	/**
	 * 修改
	 */
	public void modify(Diagnosis art){
		this.update(art);
	}
	/**
	 * 删除
	 */
	public void delete(int id){
		this.remove(id);
	}
	/**
	 * 根据ID查找   对象
	 */
	public Diagnosis art(int id){
		return this.findById(id);
	}
	/**
	 * 根据parent_id查找 列表
	 */
	public List<Diagnosis> artListByParentId(int parent_id,int type){
		if(parent_id == 0){
			String hql = "FROM Diagnosis as d where d.parent_id = (SELECT MIN(parent_id) from Diagnosis) and d.type =?";
			Object [] params={type};
			return this.findByHql(hql, params);
		}else{
			String hql = "from Diagnosis as d where d.parent_id=? and d.type =?";
			Object [] params = {parent_id,type};	
			return this.findByHql(hql, params);
		}
	}
	
	/**
	 * 查找所有列表
	 */
	public List<Diagnosis> allList(){
		return this.findAll();
	}
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Diagnosis> page(int pageno, int pageSize) {
		String hql="from Diagnosis as a order by id desc";
		return this.findByPage(pageno, pageSize,hql);
	}
	/**
	 * 查询分页
	 *
	 * @param pageno
	 * @param pageSize
	 * @param name
	 * @return   
	 * @author zwc 
	 * @time Oct 21, 2015 6:30:03 PM
	 */
	public Pagination<Diagnosis> page(int pageno, int pageSize,String name) {
		String hql="from Diagnosis as a where a.name like ? or a.othername like ? order by id desc";
		Object [] params = {"%"+name+"%","%"+name+"%"};
		return this.findByPage(pageno, pageSize,hql);
	}
	/**
	 * 通过 diseases_id 模糊查询匹配的ID
	 *
	 * @param diseases_id
	 * @return   
	 * @author zwc 
	 * @time Oct 26, 2015 5:09:57 PM
	 */
	public List<Diagnosis> findByDiseasesId(String diseases_id,int type){
		String hql = "from Diagnosis as d where d.diseases_id  = ? or d.diseases_id  like ? or d.diseases_id  like ? and d.type= ?";
		Object [] params = {diseases_id,","+diseases_id,diseases_id+",",type};
		return this.findByHql(hql, params);
	}
}
