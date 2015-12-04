package com.joecui.web.dao;

import com.joecui.web.entity.Food1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Food1DaoImpl implements Food1Dao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public List<Food1> findAll() {

		String sql = "SELECT * FROM foods1";
		List<Food1> result = namedParameterJdbcTemplate.query(sql, new Food1Mapper());

		return result;

	}

	private static final class Food1Mapper implements RowMapper<Food1> {

		public Food1 mapRow(ResultSet rs, int rowNum) throws SQLException {
			Food1 food = new Food1();
			food.setId(rs.getInt("id"));
			food.setImage(rs.getString("image"));
			food.setName(rs.getString("name"));
			food.setPrice(rs.getInt("price"));
			return food;
		}
	}


}