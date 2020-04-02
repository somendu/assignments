/**
 * 
 */
package com.product.ecommerce.rest.admin.dao;

import java.util.List;
import java.util.Map;

import com.product.ecommerce.rest.admin.model.AdminOrderItem;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
public interface AdminOrderDao {

	public List<Map<String, Object>> getAdminOrderList(String adminId);

	public List<Map<String, Object>> getAdminOrderItemList(int orderIdList);

	public int approveItem(AdminOrderItem adminOrderItem);

}
