package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.ServletActionContext;

import pojo.Article;
import pojo.Type;
import pojo.User;
import service.ITypeService;
import service.IUserService;

import com.framework.core.page.Pagination;
import com.framework.core.utils.MD5;
import com.framework.core.utils.StringUtils;
import com.framework.core.utils.toJson;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction  extends ActionSupport{
	private int id;
	private String userName;
	private String password;
	private String headImg;
	private String realName;
	private String qq;
	private User user;
	private String description;
	private List<User> userList;
	private String result;
	private int type;
	private IUserService userService;
	private Pagination<User> pagination;
	private int pageno = 1;
	private int pageSize = 10;

	//获取分类
		private ITypeService typeService;
		private List<Type> typeList;
	//分页
	public String page(){
		pagination = userService.page(pageno, 100);
		return "list";
	}
	
	
	
	public String toList(){
		userList = userService.allList();
		return "list";
	}
	
	/**
	 * 跳转专家界面
	 * 方法名：toExpert<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月3日-下午6:32:37 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String toExpert(){
		userList = userService.findByType(1);
		return "expert";
	}
	public String toAdd(){
		typeList = typeService.findByTypename("user");
		return "add";
	}
	public String toEdit(){
		typeList = typeService.findByTypename("user");
		user = userService.art(id);
		return "edit";
	}
	public String edit(){
		user = userService.art(id);
		user.setUserName(userName);
		user.setRealName(realName);
		user.setDescription(description);
		userService.modify(user);
		return "toList";
	}
	public String delete(){
		userService.delete(id);
		return "toList";
	}
	public String deleteExport(){
		userService.delete(id);
		return "toExport";
	}
	public String add(){
		List<User> list = userService.findByUserName(userName);
			if (list.size() == 0 || list == null) {
			user = new User();
			user.setHeadImg(StringUtils.isEmpty(headImg)?"":headImg);
			user.setUserName(userName);
			user.setRealName(realName);
			user.setPassword(MD5.saltPassword("tea",password));
			user.setDescription(description);
			user.setType(type);
			user.setQq(qq);
			userService.add(user);
		}
		return "toList";
	}
//	/**
//	 * 修改ajax
//	 *
//	 * @return   
//	 * @author zwc 
//	 * @time Oct 31, 2015 8:56:29 PM
//	 */
//	public String ajaxEdit(){
//		try{
//			List<User> list = userService.findByUserName(userName);
//			if (list.size() == 0 || list == null) {
//				User user = new User();
//				user.setHeadImg(StringUtils.isEmpty(headImg)?"":headImg);
//				user.setUserName(userName);
//				user.setRealName(realName);
//				user.setPassword(password);
//				user.setDescription(description);
//				user.setType(type);
//				user.setQq(qq);
//				userService.add(user);
//				result ="success";
//			} else{
//				result="exsit";
//			}
//			
//		}catch(Exception ex){
//			ex.printStackTrace();
//			result = "fail";
//		}
//		return "ajaxSuccess";
//	} 
	/**
	 * 判断用户名是否存在
	 *
	 * @return   
	 * @author zwc 
	 * @throws IOException 
	 * @time Oct 31, 2015 9:18:38 PM
	 */
	public void judjeUserName() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<User> list = userService.findByUserName(userName);
			if (list.size() == 0 || list == null) {
				map.put("result", "success");
			} else{
				map.put("result", "exsit");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			result = "fail";
		}finally{
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
		
	}
	
	/**
	 * 添加ajax
	 *
	 * @return   
	 * @author zwc 
	 * @time Nov 2, 2015 1:43:26 PM
	 */
	public String ajaxAdd(){
		try{
			List<User> list = userService.findByUserName(userName);
			if (list.size() == 0 || list == null) {
				User user = new User();
				user.setHeadImg(StringUtils.isEmpty(headImg)?"images/touxiang1.jpg":headImg);
				user.setUserName(userName);
				user.setRealName(realName);
				user.setPassword(MD5.saltPassword("tea",password));
				user.setDescription(description);
				user.setType(type);
				user.setQq(qq);
				userService.add(user);
				result ="success";
			} else{
				result="exsit";
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			result = "fail";
		}
		return "ajaxSuccess";
	} 
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	/*
	 * 增加一个用户
	 */
	public void AddUser(){
		User user=new User();
		String path="";//获取文件上传后的路径
		user.setId(id);
		user.setType(type);
		user.setUserName(userName);
		user.setPassword(MD5.saltPassword("tea",password));
		user.setRealName(realName);
		user.setDescription(description);
		user.setQq(qq);
		user.setHeadImg(path);
		userService.add(user);
		return ;
	}
	
	/*
	 * 删除一个用户
	 */
	public void DeleteUser(){
		userService.delete(id);
	}
	
	/*
	 * 修改用户信息
	 */
	public void update(){
		User user=userService.art(id);
		String path="";//获取文件上传后的路径
		user.setId(id);
		user.setType(type);
		user.setUserName(userName);
		user.setRealName(realName);
		user.setDescription(description);
		userService.modify(user);
	}
	
	/*
	 * get set 方法
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Pagination<User> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<User> pagination) {
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



	public String getQq() {
		return qq;
	}



	public void setQq(String qq) {
		this.qq = qq;
	}

	
}
