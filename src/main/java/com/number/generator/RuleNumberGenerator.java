package com.number.generator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;;

public final class RuleNumberGenerator {
	
	public static HashMap<Integer, List<Integer>> rules = new HashMap<Integer, List<Integer>>();
	
	static {
		rules.put(1, Arrays.asList(new Integer[]{36}));
		rules.put(2, Arrays.asList(new Integer[]{35}));
		rules.put(3, Arrays.asList(new Integer[]{21}));
		rules.put(4, Arrays.asList(new Integer[]{7, 12, 33}));
		rules.put(5, Arrays.asList(new Integer[]{7, 12}));
		rules.put(6, Arrays.asList(new Integer[]{28, 31, 35}));
		rules.put(7, Arrays.asList(new Integer[]{4, 5, 12, 30}));
		rules.put(8, Arrays.asList(new Integer[]{2, 11, 23}));
		rules.put(9, Arrays.asList(new Integer[]{}));
		rules.put(10, Arrays.asList(new Integer[]{5, 15}));
		rules.put(11, Arrays.asList(new Integer[]{8, 23}));
		rules.put(12, Arrays.asList(new Integer[]{4, 15, 25}));
		rules.put(13, Arrays.asList(new Integer[]{10}));
		rules.put(14, Arrays.asList(new Integer[]{17}));
		rules.put(15, Arrays.asList(new Integer[]{10, 18}));
		rules.put(16, Arrays.asList(new Integer[]{18, 19}));
		rules.put(17, Arrays.asList(new Integer[]{14}));
		rules.put(18, Arrays.asList(new Integer[]{15, 16}));
		rules.put(19, Arrays.asList(new Integer[]{16}));
		rules.put(20, Arrays.asList(new Integer[]{}));
		rules.put(21, Arrays.asList(new Integer[]{3}));
		rules.put(22, Arrays.asList(new Integer[]{33}));
		rules.put(23, Arrays.asList(new Integer[]{2, 8, 11}));
		rules.put(24, Arrays.asList(new Integer[]{27, 30}));
		rules.put(25, Arrays.asList(new Integer[]{12}));
		rules.put(26, Arrays.asList(new Integer[]{13}));
		rules.put(27, Arrays.asList(new Integer[]{4, 7, 30}));
		rules.put(28, Arrays.asList(new Integer[]{6, 31}));
		rules.put(29, Arrays.asList(new Integer[]{}));
		rules.put(30, Arrays.asList(new Integer[]{5, 15, 27}));
		rules.put(31, Arrays.asList(new Integer[]{6, 28, 33}));
		rules.put(32, Arrays.asList(new Integer[]{}));
		rules.put(33, Arrays.asList(new Integer[]{11, 22, 31}));
		rules.put(34, Arrays.asList(new Integer[]{}));
		rules.put(35, Arrays.asList(new Integer[]{2, 6}));
		rules.put(36, Arrays.asList(new Integer[]{1}));
		
		}
	
	public static List<Integer> getNumbers(Integer number) {
		return rules.get(number);
	}
}
