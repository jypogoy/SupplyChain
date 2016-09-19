package com.supplychain.inventory.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supplychain.inventory.model.User;

@Repository
@Transactional(readOnly=false)
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public void serDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(User user) {
		
		String sql = "INSERT INTO user(username, first_name, last_name, password, date_created) "
				+ "VALUES(?, ?, ?, SHA1(?), NOW())";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public User findById(long id) {
		String sql = "SELECT * FROM user where id = ?";
		return (User) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findByUserName(String userName) {
		String sql = "SELECT * FROM user where username = ?";
		return (User) getJdbcTemplate().queryForObject(sql, new Object[]{userName}, new BeanPropertyRowMapper<User>(User.class));
	}
	
	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		List<User> users = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}
	
	@Override
	public List<User> findAll(String keyword) {
		
		String sql = "SELECT * "
				+ "FROM user WHERE first_name LIKE %" + keyword + "% OR "
						+ "last_name LIKE %" + keyword + "% OR "
								+ "middle_initial  LIKE %" + keyword + "%";
		
		List<User> users = new ArrayList<User>();
		
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new UserMapper());
		for (Map<String, Object> row : rows) {
			User user = new User();
			user.setId((Long) row.get("id"));
			user.setUserName((String) row.get("username"));
			user.setFirstName((String) row.get("first_name"));
			user.setLastName((String) row.get("last_name"));
			user.setPassword((String) row.get("password"));
			user.setDateCreated((Timestamp) row.get("date_created"));
			users.add(user);
		}
		
		return users;
	}
}
