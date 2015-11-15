package com.joecui.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DBConfig {

	@Autowired
	DataSource dataSource;

	/*@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}*/

	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dbSource = new DriverManagerDataSource();
		dbSource.setDriverClassName("com.mysql.jdbc.Driver");
		dbSource.setUrl("jdbc:mysql://localhost:3306/mkyongjava");
		dbSource.setUsername("root");
		dbSource.setPassword("1q2w3e4r");

		return dbSource;
	}

	@PostConstruct
	public void startDBManager() {

		// hsqldb
		// DatabaseManagerSwing.main(new String[] { "--url",
		// "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

	}

}