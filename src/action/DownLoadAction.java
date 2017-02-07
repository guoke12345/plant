package action;

import java.util.List;

import pojo.Headimg;
import service.IHeadimgService;

public class DownLoadAction {
	private IHeadimgService headimgService;
	private List<Headimg>listheadImg;
	public String download(){
		listheadImg = headimgService.findAllImg();
		return "download";
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
	
}
