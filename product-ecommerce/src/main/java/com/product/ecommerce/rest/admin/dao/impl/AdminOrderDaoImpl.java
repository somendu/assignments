/**
 * 
 */
package com.product.ecommerce.rest.admin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.product.ecommerce.rest.admin.dao.AdminOrderDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AdminOrderDaoImpl implements AdminOrderDao {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	private final String query = "select  first_name  from employees where rownum < 5";

	private final String adminOrderQuery = "SELECT i_prod_order_id prodOrderId FROM prod_order WHERE i_admin_id = ?";

	@Override
	public List<Map<String, Object>> getAdminOrderList(String adminId) {

		// TODO Query prod_order table - get order id
		List<Map<String, Object>> adminOrderList = jdbcTemplate.queryForList(adminOrderQuery, adminId);

		return adminOrderList;
	}

}
