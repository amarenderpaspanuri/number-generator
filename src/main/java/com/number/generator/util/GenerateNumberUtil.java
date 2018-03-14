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
	
	public static void generateLines(StringBuilder sb, int rawLinesCount, List<ArrayList<Integer>> validLines) {
		
		for(ArrayList<Integer> line : validLines) {
			sb.append(line);
			sb.append("\n");
		}

		//StringBuilder sb = new StringBuilder();
		sb.append("\n");

		sb.append("-----------------------------------------Statistics--------------------------------------------------------------------------------------------------");
		sb.append("\n");
		sb.append("Total raw lines: " + rawLinesCount);sb.append("\n");
		sb.append("Required lines: " + playType.getRequiredLines());sb.append("\n");
		sb.append("Generated valid lines: " + validLines.size());sb.append("\n");
		sb.append("Total valid numbers: " + validLines.size() * playType.getNumbersPerLine());sb.append("\n");
		sb.append("Total valid single rules applied: " + getFinalRuleCount(appliedSingleRuleMap));sb.append("\n");
		sb.append("Total valid multi rules applied: " + getFinalRuleCount(appliedMultiRuleMap));sb.append("\n");
		sb.append("\n");
		sb.append("-----------------------------------------Valid Line and Rule Occurances----------------------------------------------------------------------------------");
		sb.append("\n");
		sb.append("Valid number occurances details: ");sb.append("\n");
		HashMap<Integer, Integer> map = getNumberOccurances(validLines);
		printNumberOccuranceStats(sb, map, validLines.size());
		sb.append(map);
		sb.append("\n");
		sb.append("-------------------------------------------------------------------------------------------------------------------------------------------");
		sb.append("\n");
		sb.append("Valid single rules applied details: ");sb.append("\n");
		printRuleStats(sb, appliedSingleRuleMap, rawSingleRules.size());
		sb.append("Applied single rules: ");sb.append("\n");
		sb.append(appliedSingleRuleMap);
		sb.append("\n");
		sb.append("-------------------------------------------------------------------------------------------------------------------------------------------");
		sb.append("\n");
		sb.append("Valid multi rules applied details: ");sb.append("\n");
		printRuleStats(sb, appliedMultiRuleMap, rawMultiRules.size());
		sb.append("Applied multi rules: ");sb.append("\n");
		sb.append(appliedMultiRuleMap);sb.append("\n");
		sb.append("-------------------------------------------------------------------------------------------------------------------------------------------");

		//System.out.println(sb.toString());
	}

	public static int getFinalRuleCount(HashMap<String, Integer> map) {
		int totalRuleCount = 0;
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			totalRuleCount += entry.getValue();
		}
		return totalRuleCount;
	}
	
	public static void printNumberOccuranceStats(StringBuilder sb, HashMap<Integer, Integer> map, int validLineCount) {
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
		sb.append("\n");
		sb.append("Lowest number frequency:" + lowestNumber + "=" +lowestNumberCount);sb.append("\n");
		sb.append("Highest number frequency:" + highestNumber + "=" +highestNumberCount);sb.append("\n");
		sb.append("Max number limit for play:" + playType.getNumberLimit());sb.append("\n");
		sb.append("Missed numbers:" + (playType.getNumberLimit()-map.size()));sb.append("\n");
		sb.append("Percentage of number occurance:" + ((map.size()*100)/playType.getNumberLimit()) + "%");sb.append("\n");
		
	}
	public static void printRuleStats(StringBuilder sb, HashMap<String, Integer> map, int rawRuleCount) {
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
		sb.append("\n");
		sb.append("Lowest rule count:" + lowestRule + "=" +lowestRuleCount);sb.append("\n");
		sb.append("Highest rule count:" + highestRule + "=" +highestRuleCount);sb.append("\n");
		sb.append("Raw rule count:" + rawRuleCount);sb.append("\n");
		sb.append("Missed rule count:" + (rawRuleCount-map.size()));sb.append("\n");
		sb.append("Applied rule count:" + map.size());sb.append("\n");
		sb.append("Percentage of rules applied:" + ((map.size()*100)/rawRuleCount) + "%");sb.append("\n");
		
	}
}
