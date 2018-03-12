package com.number.generator.util;

import java.util.*;

import com.number.generator.type.PlayType;

import static com.number.generator.validator.NumberOccuranceValidator.getNumberOccurances;
import static com.number.generator.validator.RulesValidator.appliedMultiRuleMap;
import static com.number.generator.validator.RulesValidator.appliedSingleRuleMap;
import static com.number.generator.validator.RulesValidator.rawSingleRules;
import static com.number.generator.validator.RulesValidator.rawMultiRules;

public final class GenerateNumberUtil {

	public static PlayType playType;
	
	public static List<ArrayList<Integer>> getLinesRequired(List<ArrayList<Integer>> lines) {
		Random random = new Random();
		if(playType.getRequiredLines() != 0) {
			List<ArrayList<Integer>> requiredLines = new ArrayList<ArrayList<Integer>>(); 
			for(int i = 0; i < playType.getRequiredLines(); i++) {
				if(lines.isEmpty()) {
					i = i-1;
				} else {
					int randomIndex = random.nextInt(lines.size());
					requiredLines.add(lines.get(randomIndex));
					lines.remove(randomIndex);
				}
			}
			return requiredLines;
		} 
		return lines;
	}
	
	public static void generateLines(int rawLinesCount, List<ArrayList<Integer>> validLines) {
		
		for(ArrayList<Integer> line : validLines) {
			System.out.println(line);
		}

		System.out.println();
		System.out.println("-----------------------------------------Statistics--------------------------------------------------------------------------------------------------");
		System.out.println("Total raw lines: " + rawLinesCount);
		System.out.println("Required lines: " + playType.getRequiredLines());
		System.out.println("Generated valid lines: " + validLines.size());
		System.out.println("Total valid numbers: " + validLines.size() * playType.getNumbersPerLine());
		System.out.println("Total valid single rules applied: " + getFinalRuleCount(appliedSingleRuleMap));
		System.out.println("Total valid multi rules applied: " + getFinalRuleCount(appliedMultiRuleMap));
		System.out.println();
		System.out.println("-----------------------------------------Valid Line and Rule Occurances----------------------------------------------------------------------------------");
		System.out.println("Valid number occurances details: ");
		HashMap<Integer, Integer> map = getNumberOccurances(validLines);
		printNumberOccuranceStats(map, validLines.size());
		System.out.println(map);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Valid single rules applied details: ");
		printRuleStats(appliedSingleRuleMap, rawSingleRules.size());
		System.out.println("Applied single rules: ");
		System.out.println(appliedSingleRuleMap);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Valid multi rules applied details: ");
		printRuleStats(appliedMultiRuleMap, rawMultiRules.size());
		System.out.println("Applied multi rules: ");
		System.out.println(appliedMultiRuleMap);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	}

	public static int getFinalRuleCount(HashMap<String, Integer> map) {
		int totalRuleCount = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			totalRuleCount += entry.getValue();
		}
		return totalRuleCount;
	}
	
	public static void printNumberOccuranceStats(HashMap<Integer, Integer> map, int validLineCount) {
		int lowestNumber = 0;
		int highestNumber = 0;
		int lowestNumberCount = 0;
		int highestNumberCount = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(lowestNumberCount == 0 && highestNumberCount == 0) {
				lowestNumber = entry.getKey();
				highestNumber = entry.getKey();
				lowestNumberCount = entry.getValue();
				highestNumberCount = entry.getValue();
			} else {
				if(entry.getValue() < lowestNumberCount) {
					lowestNumber = entry.getKey();
					lowestNumberCount = entry.getValue();
				}
				if(entry.getValue() > highestNumberCount) {
					highestNumber = entry.getKey();
					highestNumberCount = entry.getValue();
				}
			}
		}
		System.out.println("Lowest number frequency:" + lowestNumber + "=" +lowestNumberCount);
		System.out.println("Highest number frequency:" + highestNumber + "=" +highestNumberCount);
		System.out.println("Max number limit for play:" + playType.getNumberLimit());
		System.out.println("Missed numbers:" + (playType.getNumberLimit()-map.size()));
		System.out.println("Percentage of number occurance:" + ((map.size()*100)/playType.getNumberLimit()) + "%");
		
	}
	public static void printRuleStats(HashMap<String, Integer> map, int rawRuleCount) {
		String lowestRule = "";
		String highestRule = "";
		int lowestRuleCount = 0;
		int highestRuleCount = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(lowestRuleCount == 0 && highestRuleCount == 0) {
				lowestRule = entry.getKey();
				highestRule = entry.getKey();
				lowestRuleCount = entry.getValue();
				highestRuleCount = entry.getValue();
			} else {
				if(entry.getValue() < lowestRuleCount) {
					lowestRule = entry.getKey();
					lowestRuleCount = entry.getValue();
				}
				if(entry.getValue() > highestRuleCount) {
					highestRule = entry.getKey();
					highestRuleCount = entry.getValue();
				}
			}
		}
		System.out.println("Lowest rule count:" + lowestRule + "=" +lowestRuleCount);
		System.out.println("Highest rule count:" + highestRule + "=" +highestRuleCount);
		System.out.println("Raw rule count:" + rawRuleCount);
		System.out.println("Missed rule count:" + (rawRuleCount-map.size()));
		System.out.println("Applied rule count:" + map.size());
		System.out.println("Percentage of rules applied:" + ((map.size()*100)/rawRuleCount) + "%");
		
	}
}
