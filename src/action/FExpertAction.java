package action;

import java.util.List;

import com.framework.core.page.Pagination;

import pojo.Headimg;
import pojo.Question;
import service.IHeadimgService;
import service.IQuestionService;

public class FExpertAction {
	private IHeadimgService headimgService;
	private List<Headimg>listheadImg;
	private Pagination<Question> pagination;
	private IQuestionService questionService;
	private Question firstQuestion;
	private Integer pageSize = 10;
	private Integer pageno = 1;
	private Integer id = 0;
	/**
	 * 专家诊断 
	 * 方法名：expert<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月15日-下午5:24:57 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String expert(){
		listheadImg = headimgService.findAllImg();
		pagination = questionService.page(pageno, pageSize);
		if(id == 0){
			firstQuestion = pagination.getList().get(0);
		}else{
			firstQuestion = questionService.art(id);
		}
		return "expert";
	}
	public List<Headimg> getListheadImg() {
		return listheadImg;
	}
	public void setListheadImg(List<Headimg> listheadImg) {
		this.listheadImg = listheadImg;
	}
	public void setHeadimgService(IHeadimgService headimgService) {
		this.headimgService = headimgService;
	}
	public Pagination<Question> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Question> pagination) {
		this.pagination = pagination;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageno() {
		return pageno;
	}
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public Question getFirstQuestion() {
		return firstQuestion;
	}
	public void setFirstQuestion(Question firstQuestion) {
		this.firstQuestion = firstQuestion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
