/**
 * 
 */
package com.product.ecommerce.rest.admin.service;

import java.util.List;

import com.product.ecommerce.rest.admin.model.AdminOrders;
import com.product.ecommerce.rest.admin.model.AdminProduct;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
public interface AdminOrderService {

	public AdminOrders getOrdersForAdmin(String adminId);

	public List<AdminProduct> getOrderItems(AdminOrders orderId);

	public void setOrderStock(AdminOrders orderId);

}
