package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.bean.Comment;

@Repository
public class CommentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String FIND_ALL_BY_ID = "SELECT * FROM comment WHERE id_land = ? LIMIT 5";
	private static final String INSERT_ONE = "INSERT INTO comment(comment,id_land) VALUES(?, ?)";
	
	public BeanPropertyRowMapper<Comment> getRowMapper(){
		return new BeanPropertyRowMapper<>(Comment.class);
	}
	

	@SuppressWarnings("deprecation")
	public List<Comment> getItems(int id) {
		return jdbcTemplate.query(FIND_ALL_BY_ID, new Object[] {id}, getRowMapper());
	}


	public int addCMT(Comment objCmt) {
		return jdbcTemplate.update(INSERT_ONE, new Object[] {objCmt.getComment(), objCmt.getId_land()});
	}
	
}
