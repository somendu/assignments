/**
 * 
 */
package com.product.ecommerce.rest.admin.dao;

import java.util.Map;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
public interface StockDao {

	public Map<String, Object> getStockCount(int productId);

	public int updateStockCount(int adminId, int stockUpdateCount, int productId);
}
