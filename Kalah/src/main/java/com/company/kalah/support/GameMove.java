/**
 * 
 */
package com.company.kalah.support;

import java.net.URI;
import java.util.List;

import lombok.Data;

/**
 * @author somendu
 *
 */
@Data
public class GameMove {

	private int id;

	private URI uri;

	private List<KeyValue> status;

}
