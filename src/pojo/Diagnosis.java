package pojo;

public class Diagnosis {
	private int id;
	private String name;
	private int isDelete;
	private int parent_id;
	private int type;
	private String diseasesId;
	private int isLast;
	public static int ISDELETE_DELETE = 1;
	public static int ISDELETE_NORMAL=0;
	public static int ISLAST_LAST = 1;
	public static int ISLAST_NORMAL=0;
	public Diagnosis() {
	}
	public Diagnosis(int id) {
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
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsLast() {
		return isLast;
	}
	public String getDiseasesId() {
		return diseasesId;
	}
	public void setDiseasesId(String diseasesId) {
		this.diseasesId = diseasesId;
	}
	public void setIsLast(int isLast) {
		this.isLast = isLast;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
}
