package com.product.ecommerce.rest.customer;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.ecommerce.rest.customer.model.ProdOrder;
import com.product.ecommerce.rest.customer.model.ProductWithCount;
import com.product.ecommerce.rest.customer.service.OrderService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	protected Logger logger = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	private OrderService orderService;

	@RequestMapping("/add")
	public String doAdd(@RequestParam(defaultValue = "0") String addend1,
			@RequestParam(defaultValue = "0") String addend2) {

		int augend1 = Integer.valueOf(addend1);
		int augend2 = Integer.valueOf(addend2);
		int sum = augend1 + augend2;

		return "{\"addend1\":\"" + addend1 + "\", \"addend2\":\"" + addend2 + "\", \"sum\": \"" + sum + "\"}";
	}

	@PutMapping("/placeOrder/{custId}")
	public String placeOrder(@RequestBody ProdOrder orderIds, @PathVariable String custId) {

		// The map consist of productid and count for the product
		List<ProductWithCount> orderList = orderIds.getOrderedProducts();

		orderService.placeOrder(orderList, custId);

		return "";
	}
}
