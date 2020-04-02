/**
 * 
 */
package com.product.ecommerce.rest.admin.service.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ecommerce.rest.admin.dao.StockDao;
import com.product.ecommerce.rest.admin.model.ProductStockCount;
import com.product.ecommerce.rest.admin.service.StockService;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;

	@Override
	public ProductStockCount getStockCount(int productId) {

		Map<String, Object> stockMap = stockDao.getStockCount(productId);

		ProductStockCount productStockCount = new ProductStockCount();

		productStockCount.setProductId(productId);
		productStockCount.setStockCount(((BigDecimal) stockMap.get("stockCount")).intValue());

		return productStockCount;
	}

	@Override
	public int updateStock(int adminId, int stockUpdateCount, int productId) {

		int stockUpdate = stockDao.updateStockCount(adminId, stockUpdateCount, productId);

		return stockUpdate;
	}

}
