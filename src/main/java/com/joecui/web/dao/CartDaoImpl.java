package com.joecui.web.dao;

import com.joecui.web.entity.Cart;
import com.joecui.web.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
//		System.out.println("LLL Dao");
//		System.out.println("GGGG:" + result);
		return result;

	}

//	@Override
//z	public Integer testtype() {
//		return 3344;
//	}

	@Override
	public List<Cart> findAll() {

		String sql = "SELECT * FROM cart";
		List<Cart> result = namedParameterJdbcTemplate.query(sql, new CartMapper());

//		System.out.println("RESULT:  " + result);
		return result;

	}

	private static final class CartMapper implements RowMapper<Cart> {

		public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cart cart = new Cart();
			cart.setId(rs.getInt("id"));
			cart.setUser_id(rs.getInt("user_id"));
			cart.setFood_id(rs.getInt("food_id"));
			cart.setQuantity(rs.getInt("quantity"));
//			System.out.println("cart.setUser_id: "+cart);
//			System.out.println("CartDaoImplMapper: "+cart);

//			System.out.println("GGGG:" + cart);
			return cart;
		}
	}


}