package com.supplychain.inventory.dao.customer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supplychain.inventory.model.Customer;


@Repository
@Transactional(readOnly=false)
public class CustomerDAOImpl extends JdbcDaoSupport implements CustomerDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public void save(Customer customer) {
		
		String sql = null;
		
		if (customer.getId() == 0) {
			sql = "INSERT INTO customer(first_name, last_name, email, birth_date, status) "
					+ "VALUES(?, ?, ?, ?, ?)";
			getJdbcTemplate().update(sql, 
					new Object[]{
						customer.getFirstName(), 
						customer.getLastName(),
						customer.getEmail(),
						customer.getBirtDate(),
						customer.getStatus().value()					
					});
		} else {
			sql = "UPDATE customer "
					+ "SET first_name = ?, last_name = ? "
					+ "WHERE id = ?";
			getJdbcTemplate().update(sql, new Object[]{customer.getFirstName(), customer.getLastName(), customer.getId()});
		}	
	}

	@Override
	public void delete(long id) {
		
		String sql = "DELETE FROM customer "
				+ "WHERE id = ?";
		
		getJdbcTemplate().update(sql, id);
	}
	
	@Override
	public Customer findById(long id) {
		
		String sql = "SELECT * FROM customer where id = ?";
		
		return (Customer) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
	}

	@Override
	public List<Customer> findAll(String keyword) {
		
		String sql = "SELECT * "
				+ "FROM customer "
				+ (keyword != null && keyword.length() > 0 ? 
						"WHERE first_name LIKE '%" +  keyword + "%' OR "
						+ "last_name LIKE '%" +  keyword + "%' OR "
								+ "email LIKE '%" +  keyword + "%'"
								: "");
		
		List<Customer> customers = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
		
		return customers;
	}

}
