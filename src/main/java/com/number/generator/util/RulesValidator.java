package com.number.generator.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.number.generator.dto.RandomNumber;

import static com.number.generator.constants.NumberConstants2.NUMBER_LIMIT;
import static com.number.generator.constants.NumberConstants2.RULES_FACTOR;

public final class RulesValidator {
	
	static String commonNumbers = 	"1-10," +
									"1-19," +
									"1-28," +
									"1-36," +
									"1-37," +
									
									"2-11," +
									"2-29," +
									"2-35," +
									
									"4-7," +
									"4-12," +
									"4-13," +
									"4-22," +
									"4-31," +
									"4-33," +
									
									"5-9," +
									"5-32," +
									"5-10," +

									"6-33," +
									
									"14-17," +
									"14-34," +
									
									"16-19," +
									
									"17-5," +
									"17-34," +
									
									"18-3," +
									
									"23-33," +
									
									"27-9," +
									"27-30," +
									
									"28-31," +
									
									"31-6," +
									
									"33-36," +
									
									//OZ Most Common Pairs
									"17-34," +
									"16-28," +
									"21-25," +
									"21-45," +
									"33-34," +
									"35-7," +
									"1-19," +
									
									//OZ Most Common Triplets
									"1-31-35," +
									"18-33-37," +
									"11-13-2," +
									"30-7-9," +
									"27-33-34," +
									"18-44-5," +
									"21-24-7," +
									
									//OZ Most Common Consecutive Pairs
									"33-34," +
									"20-21," +
									"24-25," +
									"16-17," +
									"7-8," +
									"34-35," +
									"15-16," +

									//PB Most Common Pairs
									"26-29," +
									"36-8," +
									"23-26," +
									"23-4," +
									"20-23," +
									"32-9," +
									
									//PB Most Common Triplets
									"25-26-29," +
									"24-23-26," +
									"10-34-37," +
									"13-38-5," +
									"19-36-8," +
									"23-34-4," +
									
									//PB Most Common Consecutive Pairs
									"25-26," +
									"19-20," +
									"3-4," +
									"24-25," +
									"16-17," +
									"23-24," +
									
									//SL Most Common Pairs
									"29-33," +
									"29-40," +
									"13-18," +
									"10-26," +
									"21-22," +
									"1-15," +
									
									//SL Most Common Triplets
									"33-40-43," +
									"21-24-30," +
									"20-29-5," +
									"30-37-43," +
									"28-32-40," +
									"12-22-38," +
									
									//SL Most Common Consecutive Pairs
									"21-22," +
									"33-34," +
									"31-32," +
									"10-11," +
									"11-12," +
									"42-43," +

									//ML Most Common Pairs
									"13-14," +
									"13-43," +
									"13-39," +
									"20-43," +
									"28-34," +
									"21-41," +
									
									//ML Most Common Triplets
									"28-33-42," +
									"28-34-38," +
									"13-14-4," +
									"21-26-41," +
									"1-23-7," +
									"14-31-43," +

									//ML Most Common Consecutive Pairs
									"13-14," +
									"14-15," +
									"38-39," +
									"15-16," +
									"20-21," +
									"8-9," +
									
									//WL Most Common Pairs
									"10-24," +
									"1-32," +
									"15-32," +
									"27-45," +
									"32-6," +
									"19-37," +
									
									//WL Most Common Triplets
									"30-44-5," +
									"10-24-32," +
									"27-32-6," +
									"19-32-42," +
									"10-19-23," +
									"11-41-44," +

									//WL Most Common Consecutive Pairs
									"22-23," +
									"32-33," +
									"3-4," +
									"35-36," +
									"37-38," +
									"44-45," +

									//SFL Most Common Pairs
									"10-5," +
									"5-9," +
									"16-19," +
									"23-33," +
									"17-5," +
									"27-9," +
									"1-27," +
									"33-36," +
									
									//SFL Triplets
									"19-32-9," + 
									"23-27-33," +
									"23-26-33," +
									"12-33-36," +
									"10-17-5," + 
									"20-25-3," +
									"16-21-5," +
									"10-5-9," +
									
									//SFL Most Common Consecutive Pairs
									"27-28," +
									"3-4," +
									"32-33," +
									"19-20," +
									"18-19," +
									"10-11," +
									"11-12," +
									"21-22," +
									
						  			
						  			"1-10-19-28," +
						  			"";
	public static boolean validateRules(List<ArrayList<Integer>> rules, List<ArrayList<Integer>> lines) {
		int count = 0;
		
		for(ArrayList<Integer> rule : rules) {
			for(ArrayList<Integer> line : lines) {
				if(lineContainsRule(line, rule)) {
					count++;
				}
			}
		}
		
		if((count/rules.size()) >= RULES_FACTOR) {
			return true;
		}
		
		return false;
	}
	
	public static List<ArrayList<Integer>> getRules() {
		List<ArrayList<Integer>> rulesList = new ArrayList<ArrayList<Integer>>();
		for(String commonNumber : commonNumbers.split(",")) {
			String[] array = commonNumber.split("-");
			ArrayList<Integer> rule = new ArrayList<Integer>();
			boolean flag = true;
			for(String str : array) {
				Integer number = Integer.valueOf(str);
				if(number > NUMBER_LIMIT) {
					flag = false;
					break;
				} else {
					rule.add(number);
				}
			}
			if(flag && !ruleListContainsRule(rulesList, rule)) {
				rulesList.add(rule);
			}
		}
		return rulesList;
	}
	
	public static boolean ruleListContainsRule(List<ArrayList<Integer>> rulesList, List<Integer> rules) {
		for(ArrayList<Integer> list : rulesList) {
			if(listEqualsList(list, rules)) {
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
	
	private static boolean isNumberGreater(List<Integer> list1, List<Integer> list2) {
		return new HashSet<Integer>(list1).equals(new HashSet<Integer>(list2));
	}
	
}
