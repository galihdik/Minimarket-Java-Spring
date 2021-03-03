package com.lawencon.minimarket.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Galih Dika
 *
 */

public abstract class BaseDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected Connection conn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected StringBuilder bBuilder(String... datas) {
		StringBuilder b = new StringBuilder();
		for (String string : datas) {
			b.append(string);
		}
		return b;
	}

	protected Object objBuilder(Object... objects) {
		Object obj = new Object();
		for (Object object : objects) {

		}
		return obj;
	}

}
