/**
 * 
 */
package com.product.ecommerce.rest.customer.dao;

import java.util.List;

import com.product.ecommerce.rest.customer.model.AdminDetail;
import com.product.ecommerce.rest.customer.model.ProdOrder;
import com.product.ecommerce.rest.customer.model.ProductWithCount;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
public interface OrderDao {

	public void placeOrder(List<Integer> orderIds);

	public AdminDetail getAdminDetail();

	public int getOrderId(ProdOrder prodOrder);

	public int insertOrderItem(int orderId, String adminName, List<ProductWithCount> orderList);
}
