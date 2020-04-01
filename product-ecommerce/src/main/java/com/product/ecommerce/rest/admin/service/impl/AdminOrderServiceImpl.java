/**
 * 
 */
package com.product.ecommerce.rest.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ecommerce.rest.admin.dao.AdminOrderDao;
import com.product.ecommerce.rest.admin.model.AdminOrders;
import com.product.ecommerce.rest.admin.service.AdminOrderService;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
@Service
public class AdminOrderServiceImpl implements AdminOrderService {

	@Autowired
	private AdminOrderDao adminOrderDao;

	@Override
	public AdminOrders getOrdersForAdmin(String adminId) {

		AdminOrders adminOrders = new AdminOrders();

		List<Map<String, Object>> adminOrderList = adminOrderDao.getAdminOrderList(adminId);

		List<Integer> orderIntList = new ArrayList<Integer>();

		for (Map<String, Object> adminOrderMap : adminOrderList) {
			int orderId = ((BigDecimal) adminOrderMap.get("prodOrderId")).intValue();
			orderIntList.add(orderId);
		}

		adminOrders.setOrderIdList(orderIntList);

		for (int i : adminOrders.getOrderIdList()) {
			System.out.println("Order Id " + i);
		}

		return adminOrders;
	}

}
