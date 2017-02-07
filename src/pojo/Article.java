package pojo;

import java.util.Date;

public class Article {
	private int id;
	private String title;
	private String content;
	private String author;
	private int type;
	private String time;
	public static final int ARTICLETYPE_PESTQUES = 22;
	public static final int ARTICLETYPE_DISEASESQUES= 21;
	public static final int ARTICLETYPE_GAISHUQUES = 20;
	public Article() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
