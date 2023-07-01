package com.mini.lookfor.model;

public class LookForVO {

	private int num;
	private String type;
	private String time;
	private String area;
	private String title;
	private String content;
	private String id;
	private String image;
	
	public LookForVO() {
		// TODO Auto-generated constructor stub
	}

	public LookForVO(int num, String type, String time, String area, String title, String content, String id, String image) {
		super();
		this.num = num;
		this.type = type;
		this.time = time;
		this.area = area;
		this.title = title;
		this.content = content;
		this.id = id;
		this.image = image;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
