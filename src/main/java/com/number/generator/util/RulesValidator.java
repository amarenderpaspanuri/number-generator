package com.number.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.number.generator.type.PlayType;

public final class RulesValidator {
	
	public static PlayType playType;
	
	public static List<Integer> singleRules;
	public static List<ArrayList<Integer>> multiRules;
	
	static String singleRule = "2-4-5-7-8-9-11-14-15-19-21-23-25-26-27-28-29-31-32-33-35-37-38-43-45" + "";
	
	static String multiRule = "1-10," +
								"1-19," +
								"1-28," +
								"1-36," +
								"1-37," +
								
								"2-5," +
								"2-11," +
								"2-29," +
								"2-35," +
								
								"3-21," +
								
								"4-7," +
								"4-12," +
								"4-13," +
								"4-22," +
								"4-31," +
								"4-33," +
								
								"5-7," +
								"5-10," +
								"5-15," + //**
								"5-23," +
								"5-32," +
								
								"6-33," +
								"6-28," +
								"6-31," +
								
								"7-16," +
								"7-25," +
								"7-27," +
								"7-34," +
								
								"8-15," + //**
								"8-16," +
								"8-17," +
								"8-11," + //**
								"8-21," + //**
								"8-26," +
								"8-35," +
								
								"9-11," +
								"9-18," +
								"9-19," +
								"9-27," +
								"9-29," +
								
								"10-15," +
								"10-30," +
								"10-19," +
								"10-28," +
								"10-37," +
								
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
											
								"14-5," +
								"14-17," +
								"14-34," +
								
								"15-18," +
								"15-30," +
								
								"16-7," +
								"16-18," +
								"16-19," +
								"16-25," +
								"16-34," +
								
								"17-26," +
								"17-35," +
								
								"18-36," +
								
								"19-28," +
								"19-29," +
								"19-37," +
								
								"22-2," +
								"22-4," +
								"22-11," +
								"22-13," +
								"22-24," +
								"22-31," +
								"22-33," +
								
								"23-5," +
								"23-14," +
								"23-32," +
								"23-35," +
								
								"24-6," +
								"24-27," +
								"24-30," +
								
								"25-7," +
								"25-12," +
								"25-16," +
								"25-27," +
								
								"26-35," +
																
								"27-9," +
								"27-30," +
								"27-4," +
								"27-7," +
								
								"28-31," +
								
								"30-5," +
								
								"31-12," +
								
								"32-14," +
								"32-25," +
								
								"33-7," +
								"33-36," +
								
								"35-32," +
								"35-6," +
								
								"36-7," +
								"36-9," +
								
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
	
	public static void loadRules() {
		singleRules = loadSingleRules();
		multiRules = loadMultiRules();
	}
	
	public static List<Integer> loadSingleRules() {
		List<Integer> rulesList = new ArrayList<Integer>();
		
		String[] numberArray = singleRule.split("-", -1);
		for(String str : numberArray) {
			Integer number = Integer.valueOf(str);
			if(!(number > playType.getNumberLimit()) && !rulesList.contains(number)) {
				rulesList.add(number);
			} 
		}
		return rulesList;
	}
	
	public static List<ArrayList<Integer>> loadMultiRules() {
		List<ArrayList<Integer>> rulesList = new ArrayList<ArrayList<Integer>>();
		
		String[] rules = loadStatisticalRules().split(",", -1);
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
	
	public static String loadStatisticalRules() {
		if(playType == PlayType.OZ) {
			multiRule = multiRule + ozRules;
		} else if(playType == PlayType.PB) {
			multiRule = multiRule + pbRules;
		} else if(playType == PlayType.SL) {
			multiRule = multiRule + slRules;
		} else if(playType == PlayType.SFL) {
			multiRule = multiRule + sflRules;
		} else if(playType == PlayType.ML) {
			multiRule = multiRule + mlRules;
		} else if(playType == PlayType.WL) {
			multiRule = multiRule + wlRules;
		}
		return multiRule;
	}
	
	public static boolean validateRules(List<ArrayList<Integer>> lines, List<ArrayList<Integer>> validLines) {
		for(int j = 0; j < lines.size(); j++){
			ArrayList<Integer> line = lines.get(j);
			
			boolean validSingleRule = validateSingleRules(line);
			
			boolean validMultiRule = validateMultiRules(line);
			
			if(validSingleRule && validMultiRule) {
				validLines.add(line);
				if(validLines.size() == playType.getRequiredLines()) {
					return true;
				}
			} else {
				lines.remove(j);
				j--;
			}
			
		}
		return false;
	}
	
	public static boolean validateSingleRules(ArrayList<Integer> line) {
		int passedRuleCount = 0;
		for(Integer number : line) {
			if(singleRules.contains(number)) {
				passedRuleCount++;
			}
		}
		
		if(passedRuleCount >= playType.getMinSingleRuleCount() && passedRuleCount <= playType.getMaxSingleRuleCount()){
			return true;
		}
		return false;
	}
	
	public static boolean validateMultiRules(ArrayList<Integer> line) {
		float passedRuleCount = 0;
		
		for(int i = 0; i < multiRules.size(); i++){
			ArrayList<Integer> rule = multiRules.get(i);
			if(lineContainsRule(line, rule)) {
				passedRuleCount++;
			}
		}
		
		if(passedRuleCount >= playType.getMinMultiRuleCount() && passedRuleCount <= playType.getMaxMultiRuleCount()){
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
		playType = PlayType.SFL;
		
		loadRules();
		
		System.out.println("Total Rules Size : " + (singleRules.size() + multiRules.size()));
		
		System.out.println("Single Rules Size : " + singleRules.size());
		System.out.println("Single Rule Number Occurances : ");
		System.out.println(singleRules);
		
		HashMap<Integer, Integer> rulesMap = getRuleOccurances(multiRules);
		System.out.println("Multi Rules Size: " + multiRules.size());
		System.out.println("Multi Rule Number Occurances : ");
		System.out.println(rulesMap);
	}
	
	public static HashMap<Integer, Integer> getRuleOccurances(List<ArrayList<Integer>> rules) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(ArrayList<Integer> row : rules) {
			for(int number : row) {
				if(map.containsKey(number)) {
					map.put(number, map.get(number) + 1);
				} else {
					map.put(number, 1);
				}
			}
		}
		return map;
	}
}
