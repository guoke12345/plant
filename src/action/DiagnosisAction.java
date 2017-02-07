package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.struts2.ServletActionContext;

import pojo.Diagnosis;
import pojo.Diseases;

import service.IDiagnosisService;
import service.IDiseasesService;
import sun.security.x509.OtherName;

import com.framework.core.utils.toJson;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.imap.protocol.Status;

public class DiagnosisAction  extends ActionSupport{
	private IDiagnosisService diagnosisService;
	private IDiseasesService diseasesService;
	private int parent_id;
	private int id;
	private int type = 2;
	private Diagnosis diagnosis;
	private List<Diagnosis> diaList;
	private List<Diseases> disList;
	private String name;
	private String diseasesId;
	private List<Diseases> diseaselist;
	private String othername;
	private String disId;

	/**
	 * 病虫害分级浏览
	 *
	 * @return   
	 * @author zwc 
	 * @time Oct 16, 2015 12:33:16 PM
	 */
	public String list(){
		diaList =  diagnosisService.artListByParentId(id,type);
		disList = new ArrayList<Diseases>();
		if (diaList.isEmpty()){
			diagnosis = diagnosisService.art(id);
			if(diagnosis.getIsLast() == 1){
				String str = diagnosis.getDiseasesId();
				String[] sty = str.split(",");
					for(int i=0;i<sty.length;i++){
						if(isInteger(sty[i])){
							Diseases dis = diseasesService.findOne(Integer.parseInt(sty[i]));
							disList.add(i, dis);
						}
					}
			}
		}
		return "list";
	}
	
	public String toAddZhengZhuang(){
		return "add";
	}
	/**
	 *  添加症状
	 *   
	 * @author zwc 
	 * @throws IOException 
	 * @time Oct 16, 2015 2:21:00 PM
	 */
	public void addZhengZhuang() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(id > 0){
				diagnosis = new Diagnosis();
				diagnosis.setIsDelete(0);
				diagnosis.setIsLast(0);
				diagnosis.setName(name);
				diagnosis.setParent_id(id);
				diagnosis.setType(type);
				diagnosis.setDiseasesId("");
				diagnosisService.add(diagnosis);
				map.put("status", 1);
				map.put("msg", "成功");
			}else{
				map.put("status", 0);
				map.put("msg", "失败");
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("msg", "失败");
		}finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	
	/**
	 * 选择隶属病害，并添加
	 *
	 * @throws IOException   
	 * @author zwc 
	 * @time Oct 23, 2015 9:05:50 AM
	 */
	public void addDiseases() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(id > 0){
				diagnosis = diagnosisService.art(id);
				diagnosis.setIsLast(1);
				diseasesId = diseasesId.substring(0, diseasesId.length()-1);
				if ( (diagnosis.getDiseasesId().equals(null)) ? false :(diagnosis.getDiseasesId().length() > 0)){
					diseasesId = diagnosis.getDiseasesId() +","+ diseasesId;
				}
				diagnosis.setDiseasesId(diseasesId);
				diagnosisService.modify(diagnosis);
				map.put("status", 1);
				map.put("msg", "成功");
			}else{
				map.put("status", 0);
				map.put("msg", "失败");
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("msg", "失败");
		}finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	
	/**
	 * 删除隶属下的病害
	 *   
	 * @author zwc 
	 * @throws IOException 
	 * @time Oct 23, 2015 8:20:39 PM
	 */
	public void delDiseases() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			diseasesId = "";
			diagnosis = diagnosisService.art(id);
			String str = diagnosis.getDiseasesId();
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
			diagnosis.setDiseasesId(diseasesId);
			diagnosisService.modify(diagnosis);
			map.put("status", 1);
			map.put("msg", "成功");
		} catch (Exception e) {
			map.put("status", 0);
			map.put("msg", "失败");
		}finally{
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	
	/**
	 * 跳转到修改症状界面
	 *
	 * @return   
	 * @author zwc 
	 * @time Oct 24, 2015 7:21:41 AM
	 */
	public String toModifyZhengZhuang(){
		diagnosis = diagnosisService.art(id);
		return "edit";
	}
	
	/**
	 * 修改症状
	 *
	 * @throws IOException   
	 * @author zwc 
	 * @time Oct 24, 2015 7:24:31 AM
	 */
	public void modifyZhengZhuang() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(id > 0){
				diagnosis = diagnosisService.art(id);
				diagnosis.setName(name);
				diagnosisService.modify(diagnosis);
				map.put("status", 1);
				map.put("msg", "成功");
			}else{
				map.put("status", 0);
				map.put("msg", "失败");
			}
		} catch (Exception e) {
			map.put("status", 0);
			map.put("msg", "失败");
		}finally {
			toJson.toJson(ServletActionContext.getResponse(), map);
		}
	}
	/**
	 * 判断是否为整数
	 *
	 * @param value
	 * @return   
	 * @author zwc 
	 * @time Oct 23, 2015 8:14:59 PM
	 */
	public static boolean  isInteger(String value){
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException  e) {
			return false;
		}
	}
	
	/**
	 *  添加隶属病害
	 *   
	 * @author zwc 
	 * @time Oct 16, 2015 2:21:00 PM
	 */
	public void addDisease(){
		if(parent_id > 0){
			diagnosis = new Diagnosis();
			diagnosis.setDiseasesId(diseasesId);
			diagnosis.setIsDelete(0);
			diagnosis.setIsLast(1);
			diagnosis.setParent_id(parent_id);
			diagnosis.setType(type);
			diagnosisService.add(diagnosis);
		}
		else{
//			添加失败
		}
	}
	
	/**
	 * 删除症状
	 *
	 * @return   
	 * @author zwc 
	 * @throws IOException 
	 * @time Oct 16, 2015 12:34:55 PM
	 */
	public void delete() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			diagnosisService.delete(id);
			map.put("result", 1);
			map.put("msg", "操作成功！");
		} catch (Exception e) {
			map.put("result", 0);
			map.put("result", "操作失败!");
		}
		toJson.toJson(ServletActionContext.getResponse(), map);
	}
	/**
	 * 添加病害列表
	 *
	 * @return   
	 * @author zwc 
	 * @throws UnsupportedEncodingException 
	 * @time Oct 21, 2015 11:27:16 PM
	 */
	public String diseaseList() throws UnsupportedEncodingException{
		if (othername==null){
			othername = "";
		}
		othername = URLDecoder.decode(othername, "utf-8");
		diseasesId = diagnosisService.art(id).getDiseasesId();
		diseaselist = diseasesService.searchByOtherName(othername);
		return "diseaseList";
	}
	
	
	
	
	
	/**
	 * 
	 *<p>Title:	get set方法	</p>
	 * <p>Description:		</p>
	 * @return   
	 * @return IDiagnosisService  
	 * @author zwc
	 * @date Oct 15, 2015
	 * @time 10:09:09 PM
	 */
	
	public IDiagnosisService getDiagnosisService() {
		return diagnosisService;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public List<Diagnosis> getDiaList() {
		return diaList;
	}


	public void setDiaList(List<Diagnosis> diaList) {
		this.diaList = diaList;
	}
	public void setDiagnosisService(IDiagnosisService diagnosisService) {
		this.diagnosisService = diagnosisService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiseasesId() {
		return diseasesId;
	}

	public void setDiseasesId(String diseasesId) {
		this.diseasesId = diseasesId;
	}

	public IDiseasesService getDiseasesService() {
		return diseasesService;
	}

	public void setDiseasesService(IDiseasesService diseasesService) {
		this.diseasesService = diseasesService;
	}

	public List<Diseases> getDiseaselist() {
		return diseaselist;
	}

	public void setDiseaselist(List<Diseases> diseaselist) {
		this.diseaselist = diseaselist;
	}

	public String getOthername() {
		return othername;
	}

	public List<Diseases> getDisList() {
		return disList;
	}

	public void setDisList(List<Diseases> disList) {
		this.disList = disList;
	}

	public String getDisId() {
		return disId;
	}

	public void setDisId(String disId) {
		this.disId = disId;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}
}
