package action;

import java.util.List;

import pojo.Article;
import pojo.Headimg;
import service.IArticleService;
import service.IHeadimgService;

import com.framework.core.page.Pagination;
import com.opensymphony.xwork2.Result;

public class FNewsAction {
	private List<Headimg> listheadImg;
	private IHeadimgService headimgService;
	private Pagination<Article> pagination;
	private IArticleService articleService;
	private Article firstNews;
	private String result;
	private int id = 0;
	private int pageno = 1;
	private int pageSize = 20;
	private Article newsone;
	/**
	 * 预警信息
	 * 方法名：news<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月13日-下午7:13:39 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String news(){
		pagination = articleService.pageType(pageno, pageSize, 11);
		listheadImg = headimgService.findAllImg();
		if(id==0){
			firstNews = pagination.getList().get(0);
		}else{
			firstNews = articleService.art(id);
		}
		return "news";
	}
	
	public String ajaxSelectOne(){
		try{
			newsone = articleService.art(id);
			result = "success";
		}catch(Exception ex){
			result = "erro";
			ex.printStackTrace();
		}
		return "ajaxSuccess";
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
	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}
	public Pagination<Article> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Article> pagination) {
		this.pagination = pagination;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Article getFirstNews() {
		return firstNews;
	}
	public void setFirstNews(Article firstNews) {
		this.firstNews = firstNews;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Article getNewsone() {
		return newsone;
	}

	public void setNewsone(Article newsone) {
		this.newsone = newsone;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
