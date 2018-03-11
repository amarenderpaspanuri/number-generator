package com.number.generator;

import static com.number.generator.util.GenerateNumberUtil.generateLines;
import static com.number.generator.validator.NumberOccuranceValidator.validateOccurances;
import static com.number.generator.validator.RulesValidator.getRuleOccurances;
import static com.number.generator.validator.RulesValidator.loadRules;
import static com.number.generator.validator.RulesValidator.validateRules;
import static com.number.generator.util.GenerateNumberUtil.getLinesRequired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.number.generator.type.PlayType;
import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.GenerateNumberUtil;
import com.number.generator.util.RowNumbers;
import com.number.generator.validator.NumberOccuranceValidator;
import com.number.generator.validator.RulesValidator;

public class NumberGenerator {

	public static boolean testMode = false;
	public static void main(String[] args) {
		int rawLineCount = 0;
		int numberOfAttempts = 0;
		PlayType playType = PlayType.OZ;
		
		initPlayType(playType);
		
		loadRules();
		
		HashMap<Integer, Integer> rulesMap = getRuleOccurances(RulesValidator.rawMultiRules);
		List<ArrayList<Integer>> validLines = new ArrayList<ArrayList<Integer>>();
		while(true) {
			List<ArrayList<Integer>> rawLines = new ArrayList<ArrayList<Integer>>();
			
			RowNumbers.rawLines = rawLines;
			RowNumbers.generate_row_numbers();
			
			ColumnNumbers.rawLines = rawLines;
			ColumnNumbers.generate_column_numbers();
			
			rawLineCount += rawLines.size();
			
			numberOfAttempts++;
			
			boolean isOccuranceValid = false;
			if(testMode) {
				isOccuranceValid = true;
				rawLines = getTestLines();
			} else {
				rawLines = getLinesRequired(rawLines);
				isOccuranceValid = validateOccurances(rawLines);
				System.out.print(". ");
			}
			
			if(isOccuranceValid) {
				System.out.print("OV ");
				boolean isRulesValid = validateRules(rawLines, validLines);
				if(isRulesValid) {
					System.out.print("RV ");
					System.out.println();
					generateLines(rawLineCount, validLines);
					System.out.println("Number of attempts: " + numberOfAttempts);
					break;
				}
			}
		}
	}
	
	public static void initPlayType(PlayType playType) {
		RulesValidator.playType = playType;
		GenerateNumberUtil.playType = playType;
		RowNumbers.playType = playType;
		ColumnNumbers.playType = playType;
		NumberOccuranceValidator.playType = playType;
	}
	public static List<ArrayList<Integer>> getcopy(List<ArrayList<Integer>> rules) {
		List<ArrayList<Integer>> destRules = new ArrayList<ArrayList<Integer>>();
		for(List<Integer> rule : rules) {
			ArrayList<Integer> destRule = new ArrayList<Integer>();
			for(Integer ruleNumber : rule) {
				destRule.add(ruleNumber);
			}
			destRules.add(destRule);
		}
		return destRules;
	}
	
	public static List<ArrayList<Integer>> getTestLines() {
		List<ArrayList<Integer>> testLines = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> testLine = new ArrayList<Integer>();
		testLine.addAll(Arrays.asList(new Integer[]{30, 9, 18, 27, 19, 12, 5,12}));
		testLines.add(testLine);
		return testLines;
	}
}
