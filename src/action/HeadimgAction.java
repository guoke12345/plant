package action;
import java.util.List;
import pojo.Headimg;
import service.IHeadimgService;
import com.opensymphony.xwork2.ActionSupport;
public class HeadimgAction extends ActionSupport {
	private int id;
	private String path;
	private IHeadimgService headimgService;
	private Headimg headimg;
	private String description;
	private String result;
	private List<Headimg> listheadimg;
	private static final String IMGBASE_PATH = "upload/bannerimg/"; 
	
	public String add(){
		headimg = new Headimg();
		headimg.setDescription(description);
		headimg.setPath(path);
		try{
			headimgService.add(headimg);
			result ="success";
		}catch(Exception exception){
			exception.printStackTrace();
			result="fail";
		}
		return "ajaxSuccess";
	}
	public String delete(){
		headimgService.delete(id);
		return "toBanner";
	}
	public String banner(){
		listheadimg = headimgService.findAllImg();
		System.out.println(listheadimg);
		return "banner";
	}
	/*
	 * get set 方法
	 */
	public void setHeadimgService(IHeadimgService headimgService) {
		this.headimgService = headimgService;
	}

	public Headimg getHeadimg() {
		return headimg;
	}

	public void setHeadimg(Headimg headimg) {
		this.headimg = headimg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Headimg> getListheadimg() {
		return listheadimg;
	}
	public void setListheadimg(List<Headimg> listheadimg) {
		this.listheadimg = listheadimg;
	}
}
