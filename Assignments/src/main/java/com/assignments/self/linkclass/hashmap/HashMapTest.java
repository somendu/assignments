package com.assignments.self.linkclass.hashmap;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();

		stringMap.put("ONE", 1);
		stringMap.put("TWO", 2);
		stringMap.put("THREE", 3);
		stringMap.put("FOUR", 4);
		stringMap.put("FIVE", 5);

		System.out.println(stringMap.get("THREE"));

		System.out.println(stringMap.values());

		System.out.println(stringMap.keySet());
	}

}
