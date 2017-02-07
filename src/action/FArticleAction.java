package action;
import java.util.List;

import com.framework.core.page.Pagination;

import pojo.Article;
import pojo.Headimg;
import service.IArticleService;
import service.IHeadimgService;
public class FArticleAction {
	private IHeadimgService headimgService;
	private List<Headimg>listheadImg;
	private IArticleService articleService;
	private List<Article> pestList;
	private List<Article> diseasesList;
	private List<Article> gaishuList;
	private Article firstQuesArticle;
	private int id=0;
	public String toArticle(){
		listheadImg = headimgService.findAllImg();
		pestList = articleService.findArticleByType(Article.ARTICLETYPE_PESTQUES);
		diseasesList = articleService.findArticleByType(Article.ARTICLETYPE_DISEASESQUES);
		gaishuList = articleService.findArticleByType(Article.ARTICLETYPE_GAISHUQUES);
		if(id == 0){
			firstQuesArticle = gaishuList.get(0);
			id = firstQuesArticle.getId(); 
		}else{
			firstQuesArticle = articleService.art(id);
		}
		return "article";
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Article getFirstQuesArticle() {
		return firstQuesArticle;
	}
	public void setFirstQuesArticle(Article firstQuesArticle) {
		this.firstQuesArticle = firstQuesArticle;
	}


	public List<Article> getPestList() {
		return pestList;
	}


	public void setPestList(List<Article> pestList) {
		this.pestList = pestList;
	}


	public List<Article> getDiseasesList() {
		return diseasesList;
	}


	public void setDiseasesList(List<Article> diseasesList) {
		this.diseasesList = diseasesList;
	}


	public List<Article> getGaishuList() {
		return gaishuList;
	}


	public void setGaishuList(List<Article> gaishuList) {
		this.gaishuList = gaishuList;
	}
	
}
