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
import pojo.Headimg;

import service.IDiagnosisService;
import service.IDiseasesService;
import service.IHeadimgService;
import sun.security.x509.OtherName;

import com.framework.core.utils.toJson;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.imap.protocol.Status;

public class FDiagnosisAction  extends ActionSupport{
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
	private IHeadimgService headimgService;
	private List<Headimg> listheadImg;

	/**
	 * 自主诊断页面
	 *
	 * @return   
	 * @author zwc 
	 * @time Oct 16, 2015 12:33:16 PM
	 */
	public String list(){
		listheadImg = headimgService.findAllImg();
		return "list";
	}
	
	
	/**
	 * 病虫害分级浏览
	 *
	 * @return   
	 * @author zwc 
	 * @time Oct 24, 2015 9:53:18 AM
	 */
	public String diagnosisList(){
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
		return "diagnosisList";
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
	public IHeadimgService getHeadimgService() {
		return headimgService;
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
}
