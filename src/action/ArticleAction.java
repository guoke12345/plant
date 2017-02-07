package action;

import java.util.List;

import pojo.Article;
import pojo.Type;
import service.IArticleService;
import service.ITypeService;

import com.framework.core.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;
import com.framework.core.utils.*;
public class ArticleAction  extends ActionSupport{
	//Article属性
	private int id;
	private String content;
	private String title;
	private int  type;
	private String author;
	private String time;
	private Type typeo;
	//type属性
	private String mean;
	private String typename;
	private int articleType;
	//zhang zidignyi
	private String result;
	private Article article;
	private List<Article> articleList;
	private IArticleService articleService;
	private Pagination<Article> pagination;
	private int pageno = 1;
	private int pageSize = 10;

	//获取分类
	private ITypeService typeService;
	private List<Type> typeList;
	//分页
	public String page(){
		typeList = typeService.findByTypename("article");
//		pagination = articleService.page(pageno, pageSize);
		if (id == 0){
			//默认22 虫害管理
			typeo = typeService.findTypeById(13);
			pagination = articleService.pageType(pageno, pageSize, typeo.getType());
		}else{
			typeo = typeService.findTypeById(id);
			pagination = articleService.pageType(pageno, pageSize, typeo.getType());
		}
		return "list";
	}
//	public String pageType(){
//		typeList = typeService.findByTypename("article");
//		pagination = articleService.page(pageno, pageSize);
//		return "list";
//	}
	/**
	 * 跳转到编辑页
	 * @return
	 */
	public String toEdit(){
		typeList = typeService.findByTypename("article");
		article = articleService.art(id);
		return "edit";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		article = articleService.art(id);
		article.setAuthor(author);
		article.setContent(content);
		article.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		article.setTitle(title);
		article.setType(type);
		articleService.modify(article);
		return "toList";
	}
	
	/**
	 * 跳转到添加页
	 * 
	 * @return
	 */
	public String toAdd(){
		
		typeList = typeService.findByTypename("article");	
		return "add";
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		articleService.delete(id);
		return  "toList";
	}
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		article = new Article();
		article.setAuthor(author);
		article.setContent(content);
		article.setTitle(title);
		article.setType(type);
		article.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		articleService.add(article);
		return "toList";
	}
	
	
	/**
	 * 
	 * get、set 
	 * 
	 * 
	 * @return
	 */



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public Article getArticle() {
		return article;
	}



	public void setArticle(Article article) {
		this.article = article;
	}



	public List<Article> getArticleList() {
		return articleList;
	}



	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public IArticleService getArticleService() {
		return articleService;
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
	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}
	public List<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public Type getTypeo() {
		return typeo;
	}
	public void setTypeo(Type typeo) {
		this.typeo = typeo;
	}

	
}
