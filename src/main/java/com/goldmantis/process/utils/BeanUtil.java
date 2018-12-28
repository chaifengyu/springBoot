package com.goldmantis.process.utils;

import java.text.ParseException;
import java.util.Collection;
import java.util.Map;

/**
 * @author chengwei
 * @date 2017年3月2日 下午4:32:28
 * @Description: 工具类, 用于对象空值判断
 */
public class BeanUtil {

//	private BeanUtil() {
//		super();
//	}

	public static String toString(Object object) {
		return object == null ? "" : object.toString();
	}

	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.isEmpty();
	}

	public static boolean isNotEmpty(Collection collection) {
		return !isEmpty(collection);
	}

	public static boolean isEmpty(Map map) {
		return map == null || map.isEmpty();
	}

	public static boolean isNotEmpty(Map map) {
		return !isEmpty(map);
	}

	public static boolean isEmpty(String string) {
		return toString(string).isEmpty();
	}

	public static boolean isEmptyTrim(String string) {
		return toString(string).trim().isEmpty();
	}

	public static boolean isEmpty(Object object) {
		return toString(object).isEmpty();
	}

	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}

	public static boolean isEmptyTrim(Object object) {
		return toString(object).trim().isEmpty();
	}

	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	public static void main(String[] args) throws ParseException {
		String numberStr = "56.5%";
//		NumberFormat numberFormat = NumberFormat.getInstance();
//		Double number = numberFormat.parse(numberStr).doubleValue()/100;
		Double number = Double.valueOf(numberStr.substring(0,numberStr.length()-1));
		System.out.println(number);
	}

}
