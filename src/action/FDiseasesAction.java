package action;

import java.util.List;

import pojo.Diseases;
import pojo.Headimg;
import service.IDiseasesService;
import service.IHeadimgService;

import com.framework.core.page.Pagination;

public class FDiseasesAction {
	private int id=0;
	private String searchText;
	private IDiseasesService diseasesService;
	private IHeadimgService headimgService;
	private List<Headimg> listheadImg;
	private Diseases firstDiseases;
	private List<Diseases> diseasesList;//返回的所有虫害列表
	private List<Diseases> searchList;
	private int pageno = 1;
	private int pageSize = 30;
	private Diseases diseases;
	private Pagination<Diseases> pagination;
	private String result;
	
	public String toFDiseases(){
		listheadImg = headimgService.findAllImg();
		pagination = diseasesService.page(pageno, pageSize);
		if(id == 0 ){
			firstDiseases = pagination.getList().get(0); 
		}else{
			firstDiseases = diseasesService.findOne(id);
		}
		return "diseases";
	}
	/**
	 * ajax Diseases返回模板 
	 * 方法名：searchOne<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月9日-下午7:22:49 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String searchOne(){
		diseases=diseasesService.findOne(id);
		return "diseasesTemplate";
	}
	public String ajaxSearch(){
		searchList = diseasesService.searchByOtherName(searchText);
		if(searchList != null && searchList.size()==0){
			result = "empty";
		}else{
			result = "success";
		}
		return "ajaxSuccess";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public List<Headimg> getListheadImg() {
		return listheadImg;
	}
	public void setListheadImg(List<Headimg> listheadImg) {
		this.listheadImg = listheadImg;
	}
	public Diseases getFirstDiseases() {
		return firstDiseases;
	}
	public void setFirstDiseases(Diseases firstDiseases) {
		this.firstDiseases = firstDiseases;
	}
	public List<Diseases> getDiseasesList() {
		return diseasesList;
	}
	public void setDiseasesList(List<Diseases> diseasesList) {
		this.diseasesList = diseasesList;
	}
	public List<Diseases> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<Diseases> searchList) {
		this.searchList = searchList;
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
	public Diseases getDiseases() {
		return diseases;
	}
	public void setDiseases(Diseases diseases) {
		this.diseases = diseases;
	}
	public Pagination<Diseases> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Diseases> pagination) {
		this.pagination = pagination;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setDiseasesService(IDiseasesService diseasesService) {
		this.diseasesService = diseasesService;
	}
	public void setHeadimgService(IHeadimgService headimgService) {
		this.headimgService = headimgService;
	}
}
