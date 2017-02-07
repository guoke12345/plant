package action;

import java.util.List;

import pojo.Headimg;
import pojo.Msg;
import pojo.User;
import service.IHeadimgService;
import service.IMsgService;

import com.framework.core.page.Pagination;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.JsoupUtils;
import com.opensymphony.xwork2.ActionContext;
public class FMessageAction {
	private IHeadimgService headimgService;
	private List<Headimg> listheadImg;
	private List<Msg> listMessage;
	private Pagination<Msg> pagination;
	private IMsgService msgService;
	private int pageno=1;
	private int pageSize=10;
	private int pagnumber;
	private int totle;
	private Msg message; 
	private String result;
	private User userSession; 
	private String title;
	private String content;
	public String message(){
		listheadImg = headimgService.findAllImg();
		pagination=msgService.page(pageno, pageSize);
		pagnumber=pagination.getMaxPages();//返回总页数
		totle= pagination.getMaxElements();//返回总共有多少留言
		return "message";
	}
	public String add(){
		if(ActionContext.getContext().getSession().get("usersession")!=null){
			userSession = (User) ActionContext.getContext().getSession().get("usersession");
		}else if(ActionContext.getContext().getSession().get("expertsession")!=null){
			userSession = (User) ActionContext.getContext().getSession().get("expertsession");
		}else{
			userSession = null;
		}
		if(userSession == null){
			result="sessionEmpty";
			return "ajaxSuccess";
		}else{
			try{
				message = new Msg();
				title = JsoupUtils.filter(title);
				message.setTitle(title);
				message.setUserId(userSession.getId());
				message.setUserName(userSession.getUserName());
				message.setContent(content);
				message.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
				//msg.setPhone(phone);//暂时没有电话号码
				msgService.add(message);
				return "messageTemplate";
			}catch(Exception ex){
				result = "erro";
				ex.printStackTrace();
				return "ajaxSuccess";
			}
		}
	
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
	public List<Msg> getListMessage() {
		return listMessage;
	}
	public void setListMessage(List<Msg> listMessage) {
		this.listMessage = listMessage;
	}
	public Pagination<Msg> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Msg> pagination) {
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
	public int getPagnumber() {
		return pagnumber;
	}
	public void setPagnumber(int pagnumber) {
		this.pagnumber = pagnumber;
	}
	public int getTotle() {
		return totle;
	}
	public void setTotle(int totle) {
		this.totle = totle;
	}
	public void setMsgService(IMsgService msgService) {
		this.msgService = msgService;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public User getUserSession() {
		return userSession;
	}
	public void setUserSession(User userSession) {
		this.userSession = userSession;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Msg getMessage() {
		return message;
	}
	public void setMessage(Msg message) {
		this.message = message;
	}
	
}
