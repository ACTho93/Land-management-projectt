package vn.edu.vinaenter.model.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;




public class Land {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	private static final String COUNT_VIEWS= "UPDATE lands SET count_views = count_views + 1 WHERE id = ?";
//	
	
	private int id;
	
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String detail;
	
	private Timestamp date_create;
	private String picture;
	
	
	private int area;
	
	@NotBlank
	private String address;
	
	private int count_views;
	
	private int like_views;
	
	private int id_userlogin;
	
	
	public int getId_userlogin() {
		return id_userlogin;
	}
	public void setId_userlogin(int id_userlogin) {
		this.id_userlogin = id_userlogin;
	}
	public int getLike_views() {
		return like_views;
	}
	public void setLike_views(int like_views) {
		this.like_views = like_views;
	}
	private Category category;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount_views() {
		return count_views;
	}
	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Land() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Land(int id, @NotBlank String name, @NotBlank String description, @NotBlank String detail,
			Timestamp date_create, String picture, int area, @NotBlank String address, int count_views, int like_views,
			int id_userlogin, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.detail = detail;
		this.date_create = date_create;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
		this.like_views = like_views;
		this.id_userlogin = id_userlogin;
		this.category = category;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}



}
