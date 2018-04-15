package com.number.generator;

import java.util.*;

import com.number.generator.type.PlayType_Latest;;

public final class RuleNumberGenerator {
	
	public static PlayType_Latest playType;
	
	public static HashMap<Integer, List<Integer>> rules = new HashMap<Integer, List<Integer>>();
	
	static {
		rules.put(1, Arrays.asList(new Integer[]{36}));
		rules.put(2, Arrays.asList(new Integer[]{35}));
		rules.put(3, Arrays.asList(new Integer[]{}));
		rules.put(4, Arrays.asList(new Integer[]{7, 33}));
		rules.put(5, Arrays.asList(new Integer[]{7, 12}));
		rules.put(6, Arrays.asList(new Integer[]{28, 31, 35}));
		rules.put(7, Arrays.asList(new Integer[]{5, 12, 30}));
		rules.put(8, Arrays.asList(new Integer[]{11}));
		rules.put(9, Arrays.asList(new Integer[]{}));
		rules.put(10, Arrays.asList(new Integer[]{15}));
		rules.put(11, Arrays.asList(new Integer[]{8}));
		rules.put(12, Arrays.asList(new Integer[]{25}));
		rules.put(13, Arrays.asList(new Integer[]{10}));
		rules.put(14, Arrays.asList(new Integer[]{17}));
		rules.put(15, Arrays.asList(new Integer[]{18}));
		rules.put(16, Arrays.asList(new Integer[]{19}));
		rules.put(17, Arrays.asList(new Integer[]{14}));
		rules.put(18, Arrays.asList(new Integer[]{}));
		rules.put(19, Arrays.asList(new Integer[]{16}));
		rules.put(20, Arrays.asList(new Integer[]{16}));
		rules.put(21, Arrays.asList(new Integer[]{}));
		rules.put(22, Arrays.asList(new Integer[]{33}));
		rules.put(23, Arrays.asList(new Integer[]{}));
		rules.put(24, Arrays.asList(new Integer[]{27, 30}));
		rules.put(25, Arrays.asList(new Integer[]{12}));
		rules.put(26, Arrays.asList(new Integer[]{}));
		rules.put(27, Arrays.asList(new Integer[]{4, 7, 25, 30}));
		rules.put(28, Arrays.asList(new Integer[]{6, 31}));
		rules.put(29, Arrays.asList(new Integer[]{}));
		rules.put(30, Arrays.asList(new Integer[]{5, 7, 10, 20}));
		rules.put(31, Arrays.asList(new Integer[]{6, 28, 33}));
		rules.put(32, Arrays.asList(new Integer[]{}));
		rules.put(33, Arrays.asList(new Integer[]{31}));
		rules.put(34, Arrays.asList(new Integer[]{}));
		rules.put(35, Arrays.asList(new Integer[]{2, 6}));
		rules.put(36, Arrays.asList(new Integer[]{1}));
		
		}
	
	public static List<Integer> getNumbers(Integer number) {
		return rules.get(number);
	}
	
	static String multiRule =   "1-10," +
								"1-11," +
								"1-19," +
								"1-28," +
								"1-36," +
								
								"2-11," +
								"2-29," +
								"2-35," + //**
								
								"3-21," +
								
								"4-7," +
								"4-12," +
								"4-13," +
								"4-22," +
								"4-31," +
								"4-33," +
								
								"5-7," +
								"5-10," +
								"5-12," +
								"5-15," + 
								"5-23," +
								"5-30," + 
								"5-32," +
								
								"6-18," +
								"6-24," +
								"6-33," +
								"6-28," +
								"6-31," +
								"6-35," +
								
								"7-16," +
								"7-25," +
								"7-27," +
								"7-30," +
								"7-34," +
								
								"8-11," + 
								"8-17," +
								"8-26," +
								"8-35," +
								
								"9-19," +
								//"9-27," +
								"9-29," +
								
								"10-15," +
								"10-30," +
								"10-19," +
								"10-28," +
								
								"11-29," +
								"11-22," +
								"11-33," +
								
								"12-6," +
								"12-18," +
								"12-24," +
								"12-36," +
								
								"13-4," +
								"13-10," +
								"13-22," +
								"13-26," +
								"13-31," +
											
								"14-17," +
								"14-34," +
								
								"15-18," +
								"15-30," +
								
								"16-7," +
								"16-19," +
								"16-25," +
								"16-34," +
								
								"17-35," +
								
								"19-29," +
								
								"22-4," +
								"22-11," +
								"22-13," +
								"22-31," +
								"22-33," +
								
								"23-5," +
								"23-32," +
								
								"24-27," +
								"24-30," +
								
								//"25-7," +
								"25-12," +
								"25-16," +
								//"25-27," +
								
								//"26-35," +
																
								//"27-9," +
								"27-30," +
								//"27-4," +
								//"27-7," +
								
								//"28-31," +
								
								"30-5," +
								
								"31-12," +
								
								//"32-14," +
								//"32-25," +
								
								//"33-7," +
								"33-36," +

								"34-37," +

								//"35-32," +
								"35-6," +
								
								"36-7," +
								"36-9," +

								
								"";
	
	public static boolean ruleListContainsRule(List<ArrayList<Integer>> rulesList, List<Integer> rule) {
		for(ArrayList<Integer> list : rulesList) {
			if(listEqualsList(list, rule)) {
				//System.out.println(list + " = " + rule);
				return true;
			}
		}
	    return false;
	}
	
	public static boolean lineContainsRule(List<Integer> line, List<Integer> rule) {
		for(Integer ruleNumber : rule) {
			if(!line.contains(ruleNumber)) {
				return false;
			}
		}
	    return true;
	}
	
	private static boolean listEqualsList(List<Integer> list1, List<Integer> list2) {
		return new HashSet<Integer>(list1).equals(new HashSet<Integer>(list2));
	}	
	
	public static void main(String[] args) {
		
		
	}
}
