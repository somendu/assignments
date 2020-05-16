/**
 * 
 */
package com.sql.util.rest.sql.model;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Data
@Accessors(chain = true)
public class StringListBody {

	private List<String> stringList;

}
