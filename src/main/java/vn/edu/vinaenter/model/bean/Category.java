package vn.edu.vinaenter.model.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Category {
	private int id;
	
	@NotBlank
	//Truyện cổ tích
	@Pattern(regexp = "[^A-Za-zÀ-ÿ '-]*\\s+")
	private String name;
	
	
	private int parent_id;
	

	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	private int total;
	
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
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Category() {
		super();
	}
	public Category(int id,String name, int parent_id, int total) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.total = total;
	}
	
	
}
