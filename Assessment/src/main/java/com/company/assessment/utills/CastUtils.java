package com.company.assessment.utills;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

/**
 * 
 * @author somendu
 *
 */
public class CastUtils {

	private CastUtils() {
	}

	/**
	 * Object to String
	 * 
	 * @param obj
	 * @return
	 */
	public static String asString(Object obj) {
		if (obj == null) {
			return null;
		}
		if (!(obj instanceof String)) {
			return null;
		}
		if (obj instanceof String && ((String) obj).isEmpty()) {
			return null;
		}
		return obj.toString();
	}

	/**
	 * Object to List of Strings
	 * 
	 * @param obj
	 * @return
	 */
	public static List<String> asStrings(Object obj) {
		List<String> result;

		if (obj instanceof List<?>) {
			List<?> list = (List<?>) obj;
			result = new ArrayList<>(list.size());

			for (Object entry : list) {
				String str = asString(entry);
				if (str != null) {
					result.add(str);
				}
			}
		} else {
			result = Collections.emptyList();
		}

		return result;
	}

	/**
	 * Objects to Map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> asMap(Object obj) {
		Map<String, String> result;

		if (obj instanceof Map<?, ?>) {
			Map<?, ?> map = (Map<?, ?>) obj;
			result = Maps.newHashMap();

			for (Object entyKey : map.keySet()) {
				String key = asString(entyKey);
				String value = asString(map.get(key));
				if (key != null && value != null) {
					result.put(key, value);
				}
			}

		} else {
			result = Collections.emptyMap();
		}
		return result;
	}

	/**
	 * Objects to generics
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> asList(Object obj) {
		if (obj instanceof List<?>) {
			return (List<T>) obj;
		}
		return null;
	}

	/**
	 * Convert string to list of string
	 * 
	 * @param elements
	 * @return
	 */
	public static List<String> parameterToList(String elements) {
		return parameterToSeparatorList(elements, ",");
	}

	/**
	 * String to list of string with separator
	 * 
	 * @param elements
	 * @param separator
	 * @return
	 */
	public static List<String> parameterToSeparatorList(String elements, String separator) {

		List<String> separateList = new ArrayList<String>();

		if (!elements.isEmpty()) {

			String[] separateString = elements.split(separator);

			for (int i = 0; i < separateString.length; i++) {
				separateList.add(separateString[i]);

			}

		}

		return separateList;
	}

	/**
	 * Object to integer
	 * 
	 * @param o
	 * @return
	 */
	public static Integer asInteger(Object o) {
		if (o instanceof Integer) {
			return (Integer) o;
		}
		if (o instanceof Number) {
			return ((Number) o).intValue();
		}
		if (o instanceof String) {
			String str = (String) o;
			if (str.isEmpty()) {
				return null;
			}
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException nfe) {
			}
		}
		return null;
	}

	/**
	 * Object to String
	 * 
	 * @param o
	 * @return
	 */
	public static String toString(Object o) {
		if (o == null) {
			return "";
		}

		return o.toString();
	}

	/**
	 * Object to boolean
	 * 
	 * @param o
	 * @return
	 */
	public static Boolean asBoolean(Object o) {
		if (o instanceof Boolean) {
			return (Boolean) o;
		}
		if (o instanceof String) {
			String value = (String) o;
			if (StringUtils.isBlank(value)) {
				return null;
			} else if (value.equalsIgnoreCase("yes")) {
				return true;
			} else {
				return new Boolean(value);
			}
		}
		return false;
	}

	/**
	 * Object to BigDecimal
	 * 
	 * @param o
	 * @return
	 */
	public static BigDecimal asBigDecimal(Object o) {
		if (o instanceof BigDecimal) {
			return (BigDecimal) o;
		}
		if (o instanceof String) {
			String str = (String) o;
			if (str.isEmpty()) {
				return BigDecimal.ZERO;
			}
			try {
				return new BigDecimal(str);
			} catch (NumberFormatException nfe) {
			}
		}
		return null;
	}
}
