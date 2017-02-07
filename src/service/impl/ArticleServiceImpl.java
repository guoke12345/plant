package service.impl;
import java.util.List;
import pojo.Article;
import service.IArticleService;
import com.framework.core.page.Pagination;
import dao.IArticleDao;
public class ArticleServiceImpl implements IArticleService{
	private IArticleDao articleDao;
	
	public void add(Article article) {
		articleDao.add(article);
	}
	
	public IArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	public Pagination<Article> page(int pageno, int pageSize) {
		return articleDao.page(pageno, pageSize);
	}

	public void modify(Article art) {
		articleDao.modify(art);
		
	}

	public void delete(int id) {
		articleDao.delete(id);
		
	}

	public Article art(int id) {
		return articleDao.art(id);
	}

	public List<Article> allList() {
		return articleDao.allList();
	}

	public Pagination<Article> pageType(int pageno, int pageSize, int type) {
		return articleDao.pageType(pageno, pageSize, type);
	}

	public List<Article> findArticleByType(int type) {
		return articleDao.findArticleByType(type);
	}
	
}
