package vn.edu.vinaenter.model.bean;



public class Comment {

	private int id;
	private String comment;
	private int id_land;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getId_land() {
		return id_land;
	}
	public void setId_land(int id_land) {
		this.id_land = id_land;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String comment, int id_land) {
		super();
		this.id = id;
		this.comment = comment;
		this.id_land = id_land;
	}
	
	
	
	
}
