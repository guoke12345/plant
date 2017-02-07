package pojo;

public class Headimg {

	private int id;
	private String path;
	private String description;
	
	
	public Headimg() {
	}

	

	public Headimg(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
