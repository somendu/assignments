package com.product.ecommerce.rest.admin;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.ecommerce.rest.admin.model.AdminOrders;
import com.product.ecommerce.rest.admin.service.AdminOrderService;

@RestController
@RequestMapping("/api")
public class AdminController {
	protected Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	private AdminOrderService adminOrderService;

	@RequestMapping("/subtract")
	public String doSubtract(@RequestParam(defaultValue = "0") String minuend,
			@RequestParam(defaultValue = "0") String subtrahend) {

		int m = Integer.valueOf(minuend);
		int s = Integer.valueOf(subtrahend);
		int difference = m - s;

		return "{\"minuend\":\"" + minuend + "\", \"subtrahend\":\"" + subtrahend + "\", \"difference\": \""
				+ difference + "\"}";
	}

	@PutMapping("/approveOrder/{adminId}")
	public String placeOrder(@PathVariable String adminId) {

		// AdminOrderService
		// TODO Query prod_order table - get order id
		AdminOrders orderId = adminOrderService.getOrdersForAdmin(adminId);
		orderId.setAdminId(adminId);

		// TODO Use order id to query order_items for product id and prod count
		adminOrderService.setOrderStock(orderId);

//		stockService.checkCount

		// AdminOrder Service //Stock Service
		// TODO If count is less update order_stock table subtracting the order count
		// and approve yes order_items table

		// TODO If count is more, then approve N
		return "";
	}

}
