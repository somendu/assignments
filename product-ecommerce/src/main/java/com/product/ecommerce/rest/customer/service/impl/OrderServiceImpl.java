/**
 * 
 */
package com.product.ecommerce.rest.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ecommerce.rest.customer.dao.OrderDao;
import com.product.ecommerce.rest.customer.model.AdminDetail;
import com.product.ecommerce.rest.customer.model.ProdOrder;
import com.product.ecommerce.rest.customer.model.ProductWithCount;
import com.product.ecommerce.rest.customer.service.OrderService;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public void placeOrder(List<ProductWithCount> orderedProducts, String custId) {

		// Query admin details from admin table
		AdminDetail adminDetail = orderDao.getAdminDetail();

		// TODO Create insert for prod_order table
		ProdOrder prodOrder = new ProdOrder();
		prodOrder.setAdminId(adminDetail.getAdminId());
		prodOrder.setCustId(Integer.parseInt(custId));
		prodOrder.setAdminName(adminDetail.getAdminName());

		int orderId = orderDao.getOrderId(prodOrder);

		System.out.println("Order Id here " + orderId);

		// TODO Create insert for order_items table - need to use the order id from
		// above table
		int orderItemCount = orderDao.insertOrderItem(orderId, adminDetail.getAdminName(), orderedProducts);

		// TODO Return a proper message that records inserted order is ready

		// orderDao.placeOrder(orderIdList);

	}

}
