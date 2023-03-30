package vn.edu.vinaenter.model.bean;

public class Likeland {

	private int id;
	private int id_userlogin;
	private int id_land;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_userlogin() {
		return id_userlogin;
	}
	public void setId_userlogin(int id_userlogin) {
		this.id_userlogin = id_userlogin;
	}
	public int getId_land() {
		return id_land;
	}
	public void setId_land(int id_land) {
		this.id_land = id_land;
	}
	public Likeland() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Likeland(int id, int id_userlogin, int id_land) {
		super();
		this.id = id;
		this.id_userlogin = id_userlogin;
		this.id_land = id_land;
	}
	
	
	
	
}
