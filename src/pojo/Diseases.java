package pojo;

import java.io.Serializable;
import java.util.Date;

public class Diseases implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String othername;
	private String host;//寄主
	private String type;
	private String chara;//特征
	private String rule;//发病规律
	private String img;
	private String measure;//防治措施
	private String time;

	public Diseases() {
	}
	public Diseases(Integer id) {
		this.id = id;
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
	
	
	
}
