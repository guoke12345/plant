package action;

import java.io.IOException;
import java.util.List;

import pojo.Article;
import pojo.Diseases;
import pojo.Headimg;
import pojo.Pest;
import pojo.User;
import service.IArticleService;
import service.IDiseasesService;
import service.IHeadimgService;
import service.IPestService;
import service.IQuestionService;
import service.IUserService;

import com.framework.core.page.Pagination;
import com.framework.core.utils.MD5;
import com.opensymphony.xwork2.ActionContext;

public class IndexAction {
	private IUserService userService;
	private IArticleService articleService;
	private IHeadimgService headimgService;
	private List<Headimg> listheadImg;
	private List<Article> listNews;
	private List<User> listExpert;
	private String realName;
	private String userName;
	private String password;
	private String qq;
	private User user;
	private String typeString;
	private User userSession;
	private String msg;
	private String result;
	private List<Pest> listPest;
	private IPestService pestService;
	private List<Diseases> listDiseasses;
	private IDiseasesService diseasesService;
	private List<Article> listQuestion;
	public String index() {
		listExpert = userService.findByType(1);
		// 预警信息
		Pagination<Article> pageNews = articleService.pageType(1, 5, 11);
		// 病害列表
		Pagination<Diseases> listDiseasesPage = diseasesService.page(1, 5);
		listDiseasses = listDiseasesPage.getList();
		// 虫害列表
		Pagination<Pest> lisPestPage = pestService.page(1, 5);
		listPest = lisPestPage.getList();
		// 问题解答
		Pagination<Article> listQuestionPage = articleService.pageType(1, 5,
				Article.ARTICLETYPE_GAISHUQUES);
		if (listQuestionPage != null) {
			listQuestion = listQuestionPage.getList();
		}
		// banner图片
		listheadImg = headimgService.findAllImg();
		listNews = pageNews.getList();

		// 登陆的session判断
		if (ActionContext.getContext().getSession().get("usersession") != null) {
			userSession = (User) ActionContext.getContext().getSession()
					.get("usersession");
		} else if (ActionContext.getContext().getSession().get("expertsession") != null) {
			userSession = (User) ActionContext.getContext().getSession()
					.get("expertsession");
		} else {
			userSession = null;
		}
		return "index";
	}

	/**
	 * 登录方法 方法名：CheckLogin<BR>
	 * 创建人：严军 <BR>
	 * 时间：2015年10月4日-下午4:00:27 <BR>
	 * 
	 * @return
	 * @throws IOException
	 *             String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public String CheckLogin() throws IOException {
		List<User> list = userService.findByUserName(userName);
		if (list.size() == 0 || list == null) {
			// 没有该用户
			result = "0";// 状态为：1 表示登录成功！
			msg = "不存在该用户！";// msg表示提示信息！
		} else {
			User theUser = list.get(0);
			user = list.get(0);
			// 匹配密码和身份
			String thepassword = theUser.getPassword();
			if (thepassword.equals(MD5.saltPassword("tea", password))) {
				int theType = theUser.getType();
				if (theType == User.USERTYPE_NORMAL) {
					// 用户登录
					ActionContext.getContext().getSession()
							.put("usersession", theUser);
					typeString = "用户";
					result = "1";// 状态为：1 表示登录成功！
					msg = "登录成功！";// msg表示提示信息！
				} else if (theType == User.USERTYPE_EXPER) {
					ActionContext.getContext().getSession()
							.put("expertsession", theUser);
					typeString = "专家";
					result = "1";// 状态为：1 表示登录成功！
					msg = "登录成功！";// msg表示提示信息！
				} else {
					// 没有登录权限
					result = "0";// 状态为：0 表示登录失败！
					msg = "没有登录权限！";// msg表示提示信息！
				}
			} else {
				// 密码错误
				result = "0";// 状态为：0 表示登录失败！
				msg = "密码错误！";// msg表示提示信息！
			}
		}
		return "ajaxSuccess";
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("usersession");
		ActionContext.getContext().getSession().remove("expertsession");
		return "toIndex";
	}

	public String register() {
		List<User> list = userService.findByUserName(userName);
		if (list.size() == 0 || list == null) {
			user = new User();
			user.setUserName(userName);
			user.setPassword(MD5.saltPassword("tea", password));
			user.setRealName(realName);
			user.setType(User.USERTYPE_NORMAL);
			user.setQq(qq);
			try {
				userService.add(user);
				result = "success";
			} catch (Exception e) {
				result = "fail";
				e.printStackTrace();
			}
		} else {
			result = "exesit";
		}
		return "ajaxSuccess";
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getListExpert() {
		return listExpert;
	}

	public void setListExpert(List<User> listExpert) {
		this.listExpert = listExpert;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public List<Article> getListNews() {
		return listNews;
	}

	public void setListNews(List<Article> listNews) {
		this.listNews = listNews;
	}

	public void setHeadimgService(IHeadimgService headimgService) {
		this.headimgService = headimgService;
	}

	public List<Headimg> getListheadImg() {
		return listheadImg;
	}

	public void setListheadImg(List<Headimg> listheadImg) {
		this.listheadImg = listheadImg;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public User getUserSession() {
		return userSession;
	}

	public void setUserSession(User userSession) {
		this.userSession = userSession;
	}

	public List<Pest> getListPest() {
		return listPest;
	}

	public void setListPest(List<Pest> listPest) {
		this.listPest = listPest;
	}

	public void setPestService(IPestService pestService) {
		this.pestService = pestService;
	}

	public void setDiseasesService(IDiseasesService diseasesService) {
		this.diseasesService = diseasesService;
	}

	public List<Diseases> getListDiseasses() {
		return listDiseasses;
	}

	public void setListDiseasses(List<Diseases> listDiseasses) {
		this.listDiseasses = listDiseasses;
	}

	public List<Article> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<Article> listQuestion) {
		this.listQuestion = listQuestion;
	}
	
	
}
