package com.number.generator.util;

import java.util.*;

import com.number.generator.type.PlayType;

import static com.number.generator.validator.NumberOccuranceValidator.getNumberOccurances;
import static com.number.generator.validator.RulesValidator.appliedMultiRuleMap;
import static com.number.generator.validator.RulesValidator.appliedSingleRuleMap;

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
		System.out.println("Total valid single rules applied: " + getFinalRuleCount(appliedSingleRuleMap));
		System.out.println("Total valid multi rules applied: " + getFinalRuleCount(appliedMultiRuleMap));
		System.out.println();
		System.out.println("-----------------------------------------Valid Line and Rule Occurances----------------------------------------------------------------------------------");
		System.out.println("Valid number occurances: ");
		System.out.println(getNumberOccurances(validLines));
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Valid single rules applied details: ");
		System.out.println(appliedSingleRuleMap);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Valid multi rules applied details: ");
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
}
