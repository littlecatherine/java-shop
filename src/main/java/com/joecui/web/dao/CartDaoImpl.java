package com.joecui.web.dao;

import com.joecui.web.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
			cart.setCid(rs.getInt("cid"));
			cart.setFood_id(rs.getInt("food_id"));
			cart.setQuantity(rs.getInt("quantity"));
			return cart;
		}
	}


}