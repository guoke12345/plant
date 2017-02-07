package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONException;
import org.hibernate.mapping.Array;

import pojo.Article;
import pojo.Diseases;
import pojo.Pest;
import pojo.Question;
import pojo.User;
import service.IArticleService;
import service.IDiagnosisService;
import service.IDiseasesService;
import service.IPestService;
import service.IQuestionService;
import service.IUserService;
import sun.misc.BASE64Decoder;

import com.framework.core.page.Pagination;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.MD5;
import com.framework.core.utils.toJson;

public class AndroidAction {
	private IUserService userService;
	private IArticleService articleService;
	private IPestService pestService;
	private IDiseasesService diseasesService;
	private IQuestionService questionService;
	private String result;
	private String userName;
	private String msg;
	private String password;
	private String description;
	private String realName;
	private String qq;
	private int type;
	private Article article;
	private List<Article> articleList;
	private User user;
	private Map<String, Object> map;
	private Pest pest;
	private int pageno = 1;
	private int pageSize = 10;
	private String content;
	private String img;
	private String location;
	private String title;
	private String xpoint;
	private String ypoint;
	private int id;
	private String photo;
	private String name;
	private String answer;

	public void test() throws JSONException, IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "value");
		toJson.toJson(ServletActionContext.getResponse(), map);
	}

	/**
	 * 
	 * 安卓端登录
	 * 
	 * @throws IOException
	 * @throws JSONException
	 */

	public void androidCheckLogin() throws IOException, JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<User> list = userService.findByUserName(userName);
			if (list.size() == 0 || list == null) {
				map.put("status", 0);
				map.put("message", "登录失败！");
			} else {
				user = list.get(0);
				String thepassword = user.getPassword();
				if (thepassword.equals(MD5.saltPassword("tea", password))) {
					if (type == user.getType()) {
						user.setPassword(null);
						map.put("status", 1);
						map.put("message", "登录成功！");
						map.put("user", user);
					}else{
						map.put("status", 0);
						map.put("message", "登录失败！");
					}
				} else {
					map.put("status", 0);
					map.put("message", "登录失败！");
				}
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "登录失败！");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	/**
	 * 
	 * <p>
	 * Title: 安卓端注册
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return void
	 * @author zwc
	 * @throws IOException
	 * @date Oct 15, 2015
	 * @time 6:08:57 PM
	 */
	public void androidRegister() throws IOException {
		map = new HashMap<String, Object>();
		try {
			List<User> list = userService.findByUserName(userName);
			if (list == null || list.size() == 0) {
				user = new User();
				user.setUserName(userName);
				user.setPassword(MD5.saltPassword("tea", password));
				user.setQq(qq);
				user.setRealName(realName);
				user.setType(type);
				user.setDescription(description);
				userService.add(user);
				user.setPassword(null);
				map.put("user", user);
				map.put("status", 1);
				map.put("message", "注册成功！");
			} else if (list.size() > 0) {
				map.put("status", 0);
				map.put("message", "用户名已被注册！");
			} else {
				map.put("status", 0);
				map.put("message", "注册失败！");
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "注册失败！");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	/**
	 * 获取虫害列表
	 * 
	 * @throws IOException
	 * @author zwc
	 * @time Oct 16, 2015 7:50:49 PM
	 */
	public void getPest() throws IOException {
		map = new HashMap<String, Object>();
		try {
			List<Pest> pestList = pestService.allList();
			map.put("list", pestList);
			map.put("status", 1);
			map.put("message", "成功");
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "失败");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	/**
	 * 获取病害列表
	 * 
	 * @throws IOException
	 * @author zwc
	 * @time Oct 16, 2015 7:56:32 PM
	 */

	public void getdiseases() throws IOException {
		map = new HashMap<String, Object>();
		try {
			List<Diseases> diseasList = diseasesService.allList();
			map.put("list", diseasList);
			map.put("status", 1);
			map.put("message", "成功");
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "失败");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	/**
	 * 问题解答
	 * 
	 * @throws IOException
	 * @author zwc
	 * @time Oct 18, 2015 9:34:33 PM
	 */
	public void question() throws IOException {
		map = new HashMap<String, Object>();
		try {
			Question question = new Question();
			//图片 上传
			//判断是否有图片
			if ( !img.equals("") || !img.equals(null) || !photo.equals(null) || !photo.equals("")){
				doGet();
			}
			question.setContent(content);
			question.setImg(img);
			question.setLocation(location);
			question.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm"));
			question.setTitle(title);
			question.setXpoint(xpoint);
			question.setYpoint(ypoint);
			question.setUser_id(id);
			questionService.add(question);
			map.put("question", question);
			map.put("status", 1);
			map.put("message", "成功");
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", e.getMessage());
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	/**
	 * 安卓手机图片上传
	 *
	 * @throws IOException   
	 * @author zwc 
	 * @time Nov 1, 2015 11:00:41 AM
	 */
	public  void doGet() throws IOException{
		// 对base64数据进行解码 生成 字节数组，不能直接用Base64.decode（）；进行解密
		byte[] photoimg = new BASE64Decoder().decodeBuffer(photo);
		for (int i = 0; i < photoimg.length; ++i) {
			if (photoimg[i] < 0) {
				// 调整异常数据
				photoimg[i] += 256;
			}
		}
		// byte[] photoimg = Base64.decode(photo);//此处不能用Base64.decode（）方法解密，我调试时用此方法每次解密出的数据都比原数据大  所以用上面的函数进行解密，在网上直接拷贝的，花了好几个小时才找到这个错误（菜鸟不容易啊）
		System.out.println("图片的大小：" + photoimg.length);
		// 当前时间作为文件名
		String now = getTimeNow();
        //此处也可以在应用根目录手动建立目标上传目录  
 
        //取得文件扩展名
        int point= img.lastIndexOf(".");
        String ext=img.substring(point);
        //命名规则
        String newname =now+ext;
        
        String uploade = "upload/question/";
        String dir = ServletActionContext.getRequest().getRealPath(uploade);  
		
        File fileLocation = new File(dir);
        //文件不存在，建立文件
        if (!fileLocation.exists()) {  
     	   fileLocation.createNewFile();  
        } 
        File file = new File(dir+"/"+newname);
        FileOutputStream out = new FileOutputStream(file);
        out.write(photoimg);
        out.flush();
		out.close();
		//数据库保存路径
        img = ServletActionContext.getRequest().getContextPath()+"/"+uploade+newname;
        
        //打印
        System.out.println("wen jian jia :"+dir);
        System.out.println("wen jian :"+dir+"/"+newname);
		System.out.println("DB :"+img);
	}
	
	/*
     * 获取当前时间作为文件名
     */
	 public String getTimeNow(){
			Date d = new Date(); 
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
			String dateNow = date.format(d);
			return dateNow;
		}
	
	/**
	 * 查看我的解答
	 * 
	 * @throws IOException
	 * @author zwc
	 * @time Oct 18, 2015 10:31:08 PM
	 */
	public void myAnswer() throws IOException {
		map = new HashMap<String, Object>();
		try {
			if (id > 0) {
				List<Question> questionList = questionService.fingByUser_id(id);
				map.put("list", questionList);
				map.put("status", 1);
				map.put("message", "成功");
			} else {
				map.put("status", 0);
				map.put("message", "失败");
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("message", "失败");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	/**
	 * 专家评论
	 *
	 * @throws IOException   
	 * @author zwc 
	 * @time Nov 1, 2015 4:31:11 PM
	 */
	public void expertPingLun() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Question question = questionService.art(id);
			question.setAnswer(answer);
			questionService.modify(question);
			map.put("status", 1);
			map.put("message", "成功");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("status", 0);
			map.put("message", "失败");
		}finally{
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	/**
	 * 查看所有解答
	 * 
	 * @throws IOException
	 * @author zwc
	 * @time Oct 18, 2015 10:33:18 PM
	 */
	public void answer() throws IOException {
		map = new HashMap<String, Object>();
		try {
			List<Question> questionList ;
			questionList = questionService.allList();
			map.put("list", questionList);
			map.put("status", 1);
			map.put("message", "成功");
		} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
				map.put("status", 0);
				map.put("message", "失败");
		} finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}

	
	
	
	/**
	 * get set
	 * 
	 * @param userService
	 * @author zwc
	 * @time Oct 16, 2015 7:12:40 PM
	 */

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IDiseasesService getDiseasesService() {
		return diseasesService;
	}

	public void setDiseasesService(IDiseasesService diseasesService) {
		this.diseasesService = diseasesService;
	}

	public IArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(IArticleService articleService) {
		this.articleService = articleService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public IUserService getUserService() {
		return userService;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public IPestService getPestService() {
		return pestService;
	}

	public void setPestService(IPestService pestService) {
		this.pestService = pestService;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getXpoint() {
		return xpoint;
	}

	public void setXpoint(String xpoint) {
		this.xpoint = xpoint;
	}

	public String getYpoint() {
		return ypoint;
	}

	public void setYpoint(String ypoint) {
		this.ypoint = ypoint;
	}

	public IQuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
