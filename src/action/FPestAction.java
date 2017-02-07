package action;

import java.util.List;

import com.framework.core.page.Pagination;
import com.framework.core.utils.StringUtils;

import pojo.Headimg;
import pojo.Pest;
import service.IHeadimgService;
import service.IPestService;
public class FPestAction {
	private int id = 0;
	private String searchText;
	private IPestService pestService;
	private IHeadimgService headimgService;
	private List<Headimg> listheadImg;
	private Pest firstPest;
	private List<Pest> pestList;//返回的所有虫害列表
	private List<Pest> searchList;
	private int pageno = 1;
	private int pageSize = 30;
	private Pest pest;
	private Pagination<Pest> pagination;
	private String result;
	public String toFPest(){
		listheadImg = headimgService.findAllImg();
		pagination = pestService.page(pageno, pageSize);
		if(id == 0){
			firstPest = pagination.getList().get(0); 
		}else{
			firstPest =pestService.findPestById(id);
		}
		return "pest";
	}
	/**
	 * ajax Pest返回模板 
	 * 方法名：searchOne<BR>
	 * 创建人：youyu <BR>
	 * 时间：2015年10月9日-下午7:22:49 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public String searchOne(){
		pest=pestService.findPestById(id);	
		return "pestTemplate";
	}
	public String ajaxSearch(){
		searchList = pestService.searchByOtherName(searchText);
		if(searchList != null && searchList.size()==0){
			result = "empty";
		}else{
			result = "success";
		}
		return "ajaxSuccess";
	}
	
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setPestService(IPestService pestService) {
		this.pestService = pestService;
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

	public List<Pest> getPestList() {
		return pestList;
	}

	public void setPestList(List<Pest> pestList) {
		this.pestList = pestList;
	}

	public List<Pest> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Pest> searchList) {
		this.searchList = searchList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public Pagination<Pest> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Pest> pagination) {
		this.pagination = pagination;
	}

	public Pest getFirstPest() {
		return firstPest;
	}

	public void setFirstPest(Pest firstPest) {
		this.firstPest = firstPest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pest getPest() {
		return pest;
	}
	public void setPest(Pest pest) {
		this.pest = pest;
	}
	
}
