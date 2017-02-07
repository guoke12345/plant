package service.impl;

import java.util.List;

import pojo.Question;

import com.framework.core.page.Pagination;

import service.IQuestionService;
import dao.IQuestionDao;

public class QuestionImpl implements IQuestionService {
	private IQuestionDao questionDao;

	public IQuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(IQuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	/**
	 * 添加
	 */
	public void add(Question art) {
		questionDao.add(art);
	}
	/**
	 * 修改
	 */
	public void modify(Question art){
		questionDao.modify(art);
	}
	/**
	 * 删除
	 */
	public void delete(int id){
		questionDao.delete(id);
	}
	/**
	 * 根据ID查找   对象
	 */
	public Question art(int id){
		return questionDao.art(id);
	}
	
	public List<Question> fingByUser_id(int user_id){
		return questionDao.fingByUser_id(user_id);
	}
	/**
	 * 查找所有列表
	 */
	public List<Question> allList(){
		return questionDao.allList();
	}
	/**
	 *  分页
	 *  pageno  默认为第几页
	 *  pageSize 一页显示的条数
	 */
	public Pagination<Question> page(int pageno, int pageSize) {
		return questionDao.page(pageno, pageSize);
	}
	
	/**
	 * 根据类型分页
	 * @param pageno
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Pagination<Question> pageType(int pageno, int pageSize,int type) {
		return questionDao.pageType(pageno, pageSize, type);
	}

}
