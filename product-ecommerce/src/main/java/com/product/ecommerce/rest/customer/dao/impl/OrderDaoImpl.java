/**
 * 
 */
package com.product.ecommerce.rest.customer.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.product.ecommerce.rest.customer.dao.OrderDao;
import com.product.ecommerce.rest.customer.model.AdminDetail;
import com.product.ecommerce.rest.customer.model.ProdOrder;
import com.product.ecommerce.rest.customer.model.ProductWithCount;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	private final String query = "select  first_name  from employees where rownum < 5";

	private final String adminSelectquery = "SELECT i_prod_admin_id adminId, c_admin_name adminName FROM "
			+ "(SELECT i_prod_admin_id, c_admin_name FROM prod_admin ORDER BY DBMS_RANDOM.value) WHERE ROWNUM = 1";

	private final String orderInsertQuery = "INSERT INTO prod_order(i_cust_id, i_admin_id, i_status, c_input_user) "
			+ "VALUES (?,?,1,?)";

	private final String orderItemInsertQuery = "INSERT INTO "
			+ "order_items(i_prod_order_id, i_product_id, i_prod_count, c_approve_status, i_status, c_input_user)"
			+ "VALUES (?,?,?,'N',1,?)";

	@Override
	public void placeOrder(List<Integer> orderIds) {

		List<String> nameList = new ArrayList<String>();

		jdbcTemplate.query(query, new ResultSetExtractor<List<String>>() {

			@Override
			public List<String> extractData(ResultSet rs) throws SQLException {

				while (rs.next()) {
					String name = rs.getString("first_name");
					nameList.add(name);
				}
				return nameList;
			}

		});

		for (String name : nameList) {
			System.out.println("Name here: " + name);
		}
	}

	@Override
	public AdminDetail getAdminDetail() {

		int adminId = 1;
		String adminName = "ADM_RHL";

		Map<String, Object> adminMap = jdbcTemplate.queryForMap(adminSelectquery);

		adminId = ((BigDecimal) adminMap.get("adminId")).intValue();
		adminName = (String) adminMap.get("adminName");

		AdminDetail adminDetail = new AdminDetail();
		adminDetail.setAdminId(adminId);
		adminDetail.setAdminName(adminName);

		return adminDetail;
	}

	@Override
	public int getOrderId(ProdOrder prodOrder) {

		int orderId = 0;

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(orderInsertQuery,
						new String[] { "i_prod_order_id" });
				ps.setInt(1, prodOrder.getCustId());
				ps.setInt(2, prodOrder.getAdminId());
				ps.setString(3, prodOrder.getAdminName());
				return ps;
			}
		}, keyHolder);

		Number orderNumber = keyHolder.getKey();

		orderId = orderNumber.intValue();

		return orderId;
	}

	public int insertOrderItem(int orderId, String adminName, List<ProductWithCount> orderList) {

		int[] insertCount = jdbcTemplate.batchUpdate(orderItemInsertQuery, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, orderId);
				ps.setInt(2, orderList.get(i).getProductId());
				ps.setInt(3, orderList.get(i).getOrderCount());
				ps.setString(4, adminName);
			}

			@Override
			public int getBatchSize() {
				return orderList.size();
			}
		});
		return insertCount.length;
	}
}
