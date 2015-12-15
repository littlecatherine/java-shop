package com.joecui.web.dao;

import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Cart findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM cart WHERE id=:id";


		Cart result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new CartMapper());
		} catch (EmptyResultDataAccessException e) {
			// do nothing, return null
		}

		/*
		 * Food result = namedParameterJdbcTemplate.queryForObject( sql, params,
		 * new BeanPropertyRowMapper<Food>());
		 */
		return result;

	}

	@Override
	public void save(Cart cart) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "INSERT INTO cart(id, user_id, food_id, food_name, food_price, quantity) "
				+ "VALUES ( :id, 1, :id, :name, :price, 1)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(cart), keyHolder);
		cart.setId(keyHolder.getKey().intValue());


	}

	@Override
	public List<Cart> findAll() {

		String sql = "SELECT * FROM cart";
		List<Cart> result = namedParameterJdbcTemplate.query(sql, new CartMapper());
		return result;

	}

	private static final class CartMapper implements RowMapper<Cart> {

		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setId(rs.getInt("id"));
			cart.setUser_id(rs.getInt("user_id"));
			cart.setFood_id(rs.getInt("food_id"));
			cart.setFood_name(rs.getString("food_name"));
			cart.setFood_price(rs.getInt("food_price"));
			cart.setQuantity(rs.getInt("quantity"));
			return cart;
		}
	}

	private SqlParameterSource getSqlParameterByModel(Cart cart) {

		// Unable to handle List<String> or Array
		// BeanPropertySqlParameterSource

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
//		paramSource.addValue("id", cart.getId());
//		paramSource.addValue("user_id", cart.getUser_id());
//		paramSource.addValue("food_id", cart.getFood_id());
//		paramSource.addValue("food_name", cart.getFood_name());
//		paramSource.addValue("food_price", cart.getFood_price());
//		paramSource.addValue("quantity", cart.getQuantity());

		paramSource.addValue("id", 1);
		paramSource.addValue("user_id", 1);
		paramSource.addValue("food_id", 1);
		paramSource.addValue("food_name", "aaaa");
		paramSource.addValue("food_price", 2);
		paramSource.addValue("quantity", 2);


		return paramSource;
	}

}