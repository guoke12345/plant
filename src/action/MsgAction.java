package action;

import java.util.List;

import pojo.Msg;
import pojo.Type;
import pojo.User;
import service.IMsgService;

import com.framework.core.page.Pagination;
import com.framework.core.utils.DateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MsgAction extends ActionSupport{
	private int id;
	private String title;
	private String time;
	private String content;
	private String phone;
	private String userName;
	private String reply;
	private int pageno = 1;
	private int pageSize = 3;
	private Msg msg;
	private List<Msg> msgList;
	private IMsgService msgService;
	private Pagination<Msg> msgPagination;
	private int pagnumber;//返回总页数
	private int totle;//返回总共有多少留言
	public String message(){
		msgPagination=msgService.page(pageno, pageSize);
		return "message";
	}
	public String delete(){
		msgService.delete(id);
		return "toMessage";
	}
	public String toEdit(){
		msg = msgService.msg(id);
		return "edit";
	}
	public String toAdd(){
		return "add";
	}
	public String add(){
		msg = new Msg();
		msg.setId(id);
		msg.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		msg.setContent(content);
		msg.setUserName(userName);
		msg.setTitle(title);
		msgService.add(msg);
		return "toMessage";
	}
	public String edit(){
		msg = new Msg();
		msg.setId(id);
		msg.setTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
		msg.setContent(content);
		msg.setUserName(userName);
		msg.setTitle(title);
		msgService.reply(msg);
		return "toMessage";
	}
	public IMsgService getMsgService() {
		return msgService;
	}

	public void setMsgService(IMsgService msgService) {
		this.msgService = msgService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
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

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public List<Msg> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<Msg> msgList) {
		this.msgList = msgList;
	}

	public Pagination<Msg> getMsgPagination() {
		return msgPagination;
	}

	public void setMsgPagination(Pagination<Msg> msgPagination) {
		this.msgPagination = msgPagination;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
