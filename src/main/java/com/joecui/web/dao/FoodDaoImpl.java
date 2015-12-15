package com.joecui.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.joecui.web.entity.Food;

@Repository
public class FoodDaoImpl implements FoodDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	@Override
	public Food findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM foods WHERE id=:id";


		Food result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new FoodMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * Food result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<Food>());
		 */
		System.out.println(result);
		return result;

	}

	@Override
	public List<Food> findAll() {

		String sql = "SELECT * FROM foods";
		List<Food> result = namedParameterJdbcTemplate.query(sql, new FoodMapper());

		return result;

	}


	private static final class FoodMapper implements RowMapper<Food> {

		public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
			Food food = new Food();
			food.setId(rs.getInt("id"));
			food.setImage(rs.getString("image"));
			food.setName(rs.getString("name"));
			food.setPrice(rs.getInt("price"));
			food.setQuantity(rs.getInt("quantity"));

			return food;
		}
	}


}