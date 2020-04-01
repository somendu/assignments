/**
 * 
 */
package com.product.ecommerce.rest.admin.service;

import com.product.ecommerce.rest.admin.model.AdminOrders;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
public interface AdminOrderService {

	public AdminOrders getOrdersForAdmin(String adminId);

}
