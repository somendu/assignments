/**
 * 
 */
package com.product.ecommerce.rest.admin.service;

import com.product.ecommerce.rest.admin.model.ProductStockCount;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
public interface StockService {

	public ProductStockCount getStockCount(int productId);

	public int updateStock(int adminId, int stockUpdateCount, int productId);
}
