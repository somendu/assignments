/**
 * 
 */
package com.product.ecommerce.rest.customer.service;

import java.util.List;

import com.product.ecommerce.rest.customer.model.ProductWithCount;

/**
 * @author Somendu
 *
 */

public interface OrderService {

	public void placeOrder(List<ProductWithCount> orderedProducts, String custId);
}
