/**
 * 
 */
package com.product.ecommerce.rest.customer.model;

import java.util.List;

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
public class ProdOrder {

	private List<ProductWithCount> orderedProducts;

	private int orderId;
	private int custId;
	private int adminId;
	private String adminName;
}
