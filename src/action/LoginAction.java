package action;
import java.io.IOException;
import java.util.List;
import pojo.User;
import service.IUserService;
import com.framework.core.utils.MD5;
import com.opensymphony.xwork2.ActionContext;
public class LoginAction {
	private String result; 
	private String msg;
	private String userName;
	private String password;
	private IUserService userService;
	private User adminUser;
	private User experUser;
	/**
	 * 跳转到login界面 方法名：login<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月4日-下午3:55:31 <BR>
	 * 
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public String login() {
		 if((User) ActionContext.getContext().getSession().get("adminUser")!=null){
			 adminUser = (User) ActionContext.getContext().getSession().get("adminUser");
		 }else if((User) ActionContext.getContext().getSession().get("experUser")!=null){
			 experUser = (User) ActionContext.getContext().getSession().get("experUser");
		 }
		if (adminUser!=null) {
			return "main";
		}else if(experUser != null){
			return "question";
		}else{
			return "login";
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("adminUser");
		ActionContext.getContext().getSession().remove("experUser");
		return "loginDirect";
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
			result = "empty";
			msg="用户名或密码错误";
		} else {
			User theUser = list.get(0);
			String thepassword = theUser.getPassword();
			if (thepassword.equals(MD5.saltPassword("tea",password))) {
				int theType = theUser.getType();
				if(theType == User.USERTYPE_ADMIN){
					ActionContext.getContext().getSession()
					.put("adminUser", theUser);
					result = "successadmin";
				}else if(theType == User.USERTYPE_EXPER){
					ActionContext.getContext().getSession()
					.put("experUser", theUser);
					result = "successexper";
				}
				msg="登陆成功";
			} else {
				result = "empty";
				msg="用户名或密码错误";
			}
		}
		return "ajaxSuccess";
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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

	public User getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(User adminUser) {
		this.adminUser = adminUser;
	}

	public User getExperUser() {
		return experUser;
	}

	public void setExperUser(User experUser) {
		this.experUser = experUser;
	}
}
