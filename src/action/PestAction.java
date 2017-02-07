package action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pojo.Pest;
import service.IPestService;

import com.framework.core.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class PestAction extends ActionSupport {
	private int id;
	private String name;//名称
	private String othername;//别名
	private String host;//寄主
	private String location;//寄主范围
	private String chara;//为害特征
	private String aspect;//形态特征
	private String habit;//习性
	private String img;//图像
	private String measure;//防治措施
	private String time;//更新时间
	private IPestService pestService;
	private List<Pest> pestList;//返回的所有虫害列表
	private Pest pest;
	private Pagination<Pest> pagination;
	private int pageno = 1;
	private int pageSize = 10;
	public String getTimeNow(){
		Date d = new Date(); 
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String dateNow = date.format(d);
		return dateNow;
	}
	//分页
		public String page() throws UnsupportedEncodingException{
			if (name == null){
				name = "";
			}
			name = URLDecoder.decode(name,"utf8");
			pagination = pestService.page(pageno, pageSize,name);
			return "list";
		}
	/*
	 * 跳转到列表页面
	 */
	public String toList(){
		pestList = pestService.allList();
		return "list";
	}
	public String toAdd(){
		return "add";
	}
	public String toEdit(){
		pest=pestService.findPestById(id);		
		return "edit";
	}
	/*
	 * 添加虫害
	 */
	
	public String add(){
		Pest pest=new Pest();
		pest.setName(name);
		pest.setOthername(othername);
		pest.setHost(host);
		pest.setLocation(location);
		pest.setChara(chara);
		pest.setAspect(aspect);
		pest.setHabit(habit);
		pest.setMeasure(measure);
		pest.setTime(getTimeNow());
		pest.setImg(img);
		pestService.add(pest);
		return "toList" ;
	}
	
	/*
	 * 删除虫害
	 */
	public String deletPest(){
		pestService.delete(id);
		return "toList" ;
	}
	
	/*
	 * 修改虫害
	 */
	
	public String updatePest(){
		Pest pest=new Pest();		
		pest.setId(id);
		pest.setName(name);
		pest.setOthername(othername);
		pest.setHost(host);
		pest.setLocation(location);
		pest.setChara(chara);
		pest.setAspect(aspect);
		pest.setHabit(habit);
		pest.setMeasure(measure);
		pest.setTime(getTimeNow());
		pest.setImg(img);
		pestService.modify(pest);
		return "toList" ;
	}
	
	
	/*
	 * get set 方法
	 */
	public IPestService getPestService() {
		return pestService;
	}

	public void setPestService(IPestService pestService) {
		this.pestService = pestService;
	}
	
	public Pest getPest() {
		return pest;
	}

	public void setPest(Pest pest) {
		this.pest = pest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getChara() {
		return chara;
	}

	public void setChara(String chara) {
		this.chara = chara;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Pest> getPestList() {
		return pestList;
	}

	public void setPestList(List<Pest> pestList) {
		this.pestList = pestList;
	}
	public Pagination<Pest> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Pest> pagination) {
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

	

}
