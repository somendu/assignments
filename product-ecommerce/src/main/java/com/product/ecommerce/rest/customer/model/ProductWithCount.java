/**
 * 
 */
package com.product.ecommerce.rest.customer.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Data
@Accessors(chain = true)
public class ProductWithCount {

	private int productId;
	private int orderCount;
}
