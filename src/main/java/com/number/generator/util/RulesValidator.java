package com.number.generator.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.number.generator.type.PlayType;

public final class RulesValidator {
	
	public static PlayType playType;
	
	static String doubleRules = "1-10," +
								"1-19," +
								"1-28," +
								"1-36," +
								"1-37," +
								
								"2-5," +
								"2-11," +
								"2-29," +
								"2-35," +
								
								"3-6," +
								"3-21," +
								
								"4-7," +
								"4-12," +
								"4-13," +
								"4-22," +
								"4-31," +
								"4-33," +
								
								"5-9," +
								"5-10," +
								"5-15," +
								"5-23," +
								"5-32," +
								
								"6-33," +
								"6-31," +
								"6-35," +
								
								"7-16," +
								"7-25," +
								"7-27," +
								"7-34," +
								
								"8-17," +
								"8-11," +
								"8-15," +
								"8-21," +
								"8-26," +
								"8-35," +
								
								"9-18," +
								"9-19," +
								"9-27," +
								"9-29," +
								
								"10-5," +
								"10-15," +
								"10-30," +
								"10-19," +
								"10-28," +
								"10-37," +
								
								"11-2," +
								"11-8," +
								"11-29," +
								"11-22," +
								"11-33," +
								
								"12-4," +
								"12-6," +
								"12-18," +
								"12-24," +
								"12-36," +
								
								"13-4," +
								"13-10," +
								"13-22," +
								"13-31," +
																	
								"14-17," +
								"14-15," +
								"14-34," +
								
								"15-5," +
								"15-10," +
								"15-18," +
								"15-30," +
								
								"16-7," +
								"16-19," +
								"16-25," +
								"16-34," +
								
								"17-5," +
								"17-14," +
								"17-34," +
								"17-35," +
								
								"18-3," +
								"18-9," +
								"18-15," +
								"18-36," +
								
								"19-1," +
								"19-9," +
								"19-10," +
								"19-16," +
								"19-28," +
								"19-37," +
								
								"20-8," +
								"20-30," +
								
								"21-3," +
								
								"22-4," +
								"22-11," +
								"22-13," +
								"22-31," +
								"22-33," +
								
								"23-33," +
								"23-5," +
								"23-14," +
								"23-32," +
								"23-35," +
								
								"24-6," +
								"24-12," +
								"24-22," +
					
								"25-7," +
								"25-16," +
								"25-27," +
								
								"26-8," +
								"26-13," +
								"26-17," +
								"26-35," +
								
								"27-9," +
								"27-30," +
								"27-4," +
								"27-7," +
								
								"28-31," +
								"28-6," +
								"28-10," +
								"28-12," +
								"28-1," +
								"28-19," +
								
								"29-2," +
								"29-11," +
								"29-9," +
								"29-19," +
								"29-28," +
								
								"30-15," +
								"30-27," +
								"30-10," +
								"30-5," +
								"30-25," +
								
								"31-6," +
								"31-28," +
								"31-4," +
								"31-22," +
								"31-12," +
								"31-13," +
								
								"32-5," +
								"32-14," +
								"32-23," +
								"32-25," +
								"32-35," +
								
								"33-3," +
								"33-4," +
								"33-6," +
								"33-7," +
								"33-11," +
								"33-22," +
								"33-36," +
								
								"34-2," +
								"34-14," +
								"34-16," +
								"34-17," +
								"34-3," +
								"34-35," +
								
								"35-2," +
								"35-8," +
								"35-17," +
								"35-23," +
								"35-32," +
								"35-6," +
								"35-4," +
								
								"36-1," +
								"36-4," +
								"36-7," +
								"36-9," +
								"36-18," +
								"36-33," +
								"";
	
	static String tripleRules = "1-10-19," +
								"1-10-28," +
								"1-10-37," +
								
								"2-11-29," +
								"2-11-35," +
								"2-22-33," +
								
								"4-13-22," +
								"4-13-31," +
								"4-13-31," +
								"4-13-22," +
								"4-7-33," +
								"4-7-33," +
								"4-7-6-33," +
								
								"5-10-23," +
								"5-15-23," +
								
								"6-33-31," +
								"6-16-35," +
								
								"7-4-16," +
								"7-4-16," +
								"7-4-27," +
								"7-4-34," +
								
								"8-2-35," +
								"8-26-35," +
								"8-13-35," +
								"8-17-35," +
								
								"9-1-19," +
								"9-19-29," +
								"9-19-27," +
								"9-19-36," +
								"9-19-31," +
								"9-19-28," +
								
								"10-5-30," +
								"10-1-19," +
								"10-15-30," +
								"10-1-19," +
								"10-1-37," +
								"10-19-28," +
								"10-19-37," +
								"10-13-28," +
								
								"11-2-29," +
								"11-22-33," +
								"11-4-22," +
								"11-8-2," +
								"11-14-23," +
								
								"12-4-31," +
								"12-4-28," +
								"12-6-24," +
								"12-18-36," +
								
								"13-4-22," +
								"13-4-31," +
								"13-4-26," +
								
								"14-17-34," +
								
								"15-5-31," +
								"15-5-18," +
								"15-18-10," +
								
								"16-19-18," +
								
								"17-5-14," +
								"17-5-8," +
								"17-5-34," +
								"17-5-26," +
								"17-26-35," +
								
								"18-55-36," +
								
								"19-10-1," +
								
								"21-3-4," +
								
								"22-4-24," +
								"22-4-11," +
								"22-13-11," +
								
								"23-5-32," +
								"23-5-27," +
								"23-5-25," +
								
								"26-13-8," +
								"26-17-8," +
								"26-35-8," +
								
								"27-25-4," +
								"27-25-7," +
								"27-25-30," +
								
								"28-31-6," +
								"28-1-10," +
								"28-19-12," +
								
								"29-9-28," +
								"29-11-2," +
								
								"30-15-5," +
								"30-28-37," +
								"30-27-15," +
								"30-18-15," +
								
								"31-6-4," +
								"31-13-22," +
								"31-28-22," +
								"31-4-7," +
								"31-22-13," +
								"31-28-34," +
								
								"32-23-5," +
								"32-14-5," +
								
								"33-36-6," +
								"33-4-7," +
								"33-6-31," +
								"33-22-31," +
								"33-24-31," +
								"33-24-22," +
								
								"34-14-17," +
								
								"35-2-8," +
								"35-8-11," +
								"35-26-11," +
								"35-6-4," +
								"35-17-7," +
								
								"36-1-18," +
								"36-24-18," +
								"36-33-18," +
								"36-15-18," +
								"36-9-18," +
								"36-12-24," +
								"";
	
	static String quadruples = 	"1-10-19-28," +
								"1-10-19-37," +
								"4-13-33-28," +
								"1-10-19-37," +
								"";
		
	static String ozRules = 	//OZ Most Common Pairs
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
								"";

	static String pbRules =		//PB Most Common Pairs
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
								"";
									
	static String slRules =	//SL Most Common Pairs
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
								"";

	static String mlRules =		//ML Most Common Pairs
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
								"";
									
	static String wlRules =		//WL Most Common Pairs
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
								"";

	static String sflRules =	//SFL Most Common Pairs
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
								"";
	
	public static List<ArrayList<Integer>> loadRules() {
		List<ArrayList<Integer>> rulesList = new ArrayList<ArrayList<Integer>>();
		String[] rules = decideRules().split(",", -1);
		for(String pair : rules) {
			if(!pair.trim().isEmpty()) {
				String[] numberArray = pair.split("-", -1);
				ArrayList<Integer> rule = new ArrayList<Integer>();
				boolean flag = true;
				for(String str : numberArray) {
					Integer number = Integer.valueOf(str);
					if(number > playType.getNumberLimit()) {
						flag = false;
						break;
					} else {
						rule.add(number);
					}
				}
				if(flag && !rule.isEmpty() && !ruleListContainsRule(rulesList, rule)) {
					rulesList.add(rule);
				}
			}
		}
		return rulesList;
	}
	
	public static String decideRules() {
		
		String rules = doubleRules + tripleRules;
		
		return rules;
	}
	
	public static boolean validateRules(List<ArrayList<Integer>> rules, List<ArrayList<Integer>> lines) {
		float ruleCount = 0;
		
		for(ArrayList<Integer> rule : rules) {
			for(ArrayList<Integer> line : lines) {
				if(lineContainsRule(line, rule)) {
					ruleCount++;
				}
			}
		}
		
		float ruleSize = rules.size();
		float ruleFactor = ruleCount/ruleSize;
		if(ruleFactor >= playType.getRulesFactor()) {
			return true;
		}
		
		return false;
	}
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
		loadRules();
	}
}
