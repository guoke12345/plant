package action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.JSONUtil;

import pojo.Diagnosis;
import pojo.Diseases;
import pojo.Pest;
import service.IDiagnosisService;
import service.IDiseasesService;
import service.IPestService;
import service.IUserService;
import service.impl.DiagnosisServiceImpl;

import com.framework.core.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class DiseasesAction extends ActionSupport {
	private int id;
	private String name;//名称
	private String othername;//别名
	private String host;//寄主
	private String type;//寄主范围
	private String chara;//为害特征
	private String rule;//形态特征
	private String img;//图像
	private String measure;//防治措施
	private String time;//更新时间
	private List<Diseases> diseasesList;//返回的所有虫害列表
	private Diseases diseases;
	private IDiseasesService diseasesService;
	private IDiagnosisService diagnosisService;

	private Pagination<Diseases> pagination;
	private int pageno = 1;
	private int pageSize = 10;
	/*
	 * 获取当前时间
	 */
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
		pagination = diseasesService.page(pageno, pageSize,name);
		return "list";
	}
	public String toList(){
		diseasesList=diseasesService.allList();
		return "list";
	}
	
	public String toEdit(){
		diseases=diseasesService.findOne(id);
		return "edit";
	}
	
	public String toAdd(){
		return "add";
	}
	
	/*
	 * 添加病害
	 */
	
	public String add(){
		Diseases diseases=new Diseases();
		diseases.setImg(img);
		diseases.setName(name);
		diseases.setOthername(othername);
		diseases.setHost(host);
		diseases.setRule(rule);
		diseases.setChara(chara);
		diseases.setMeasure(measure);
		diseases.setType(type);
		diseases.setTime(getTimeNow());
		diseasesService.add(diseases);
		return "toList" ;
	}
	/*
	 * 删除病害
	 */
	public String deleteDiseases(){
		diseasesService.delete(id);
		String disId =  Integer.toString(id);
		int diseasesType = 2;   // 2 表示 病害   1 表示虫害
		List<Diagnosis> diaList = diagnosisService.findByDiseasesId(disId,diseasesType);
		if(diaList.size()>0){
			for(int j = 0;j< diaList.size();j++){
					String diseasesId = "";
					String str = diaList.get(j).getDiseasesId();
					String[] sty  = str.split(",");
					for(int i= sty.length-1;i>=0;i--){
						if(disId.equals(sty[i])){
							continue;
						}
						diseasesId = sty[i]+","+diseasesId;
					}
					if(!diseasesId.equals("")){
						diseasesId = diseasesId.substring(0,diseasesId.length() - 1);
					}
					diaList.get(j).setDiseasesId(diseasesId);
					diagnosisService.modify(diaList.get(j));
			}
		}
		return "toList" ;
	}
	
	/*
	 * 修改病害
	 */
	
	public String updateDiseases(){
		Diseases diseases=new Diseases();
		diseases.setImg(img);
		diseases.setId(id);
		diseases.setName(name);
		diseases.setOthername(othername);
		diseases.setHost(host);
		diseases.setRule(rule);
		diseases.setChara(chara);
		diseases.setMeasure(measure);
		diseases.setType(type);
		diseases.setTime(getTimeNow());
		diseasesService.modify(diseases);
		return "toList" ;
	}
	
	/*
	 * get set方法
	 */
	public IDiseasesService getDiseasesService() {
		return diseasesService;
	}

	public void setDiseasesService(IDiseasesService diseasesService) {
		this.diseasesService = diseasesService;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChara() {
		return chara;
	}

	public void setChara(String chara) {
		this.chara = chara;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
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

	public List<Diseases> getDiseasesList() {
		return diseasesList;
	}

	public void setDiseasesList(List<Diseases> diseasesList) {
		this.diseasesList = diseasesList;
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
	public IDiagnosisService getDiagnosisService() {
		return diagnosisService;
	}
	public void setDiagnosisService(IDiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}
	
	

}
