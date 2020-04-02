/**
 * 
 */
package com.product.ecommerce.rest.admin.model;

import lombok.Data;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 1, 2020
 */
@Data
public class AdminOrderItem {

	private int productOrderId;
	private int productId;
	private int productCount;
}
