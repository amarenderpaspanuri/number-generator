package com.number.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.number.generator.type.PlayType;
import static com.number.generator.util.NumberOccuranceValidator.getNumberOccurances;

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
	
	public static void generateLines(int rawLinesCount, List<ArrayList<Integer>> validLines, HashMap<Integer, Integer> rulesMap) {
		
		for(ArrayList<Integer> line : validLines) {
			System.out.println(line);
		}
		
		System.out.println("Total raw Lines : " + rawLinesCount);
		System.out.println("Required Lines : " + playType.getRequiredLines());
		System.out.println("Generated Lines : " + validLines.size());
		System.out.println("Valid Number Occurances : ");
		System.out.println(getNumberOccurances(validLines));
		System.out.println("Rule Occurances : ");
		System.out.println(rulesMap);
	}
}
