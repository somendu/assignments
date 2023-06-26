/**
 * 
 */
package com.practice.jdk19;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 17-Jun-2023
 */
public class HashmapPractice {

	public static void main(String[] args) {
		Map<String, String> map = HashMap.newHashMap(10);

		map.put("test", "test");
		map.put("test", "test");
		map.put("test", "test");
		map.put("test", "test");
		map.put("test", "test");

		map.put("test", "test");
		map.put("test", "test");
		map.put("test", "test");

		map.put("test", "test");
		map.put("test", "test");

		map.put("test", "test");
		map.put("test", "test");

		System.out.println(map.get("test"));
	}
}
