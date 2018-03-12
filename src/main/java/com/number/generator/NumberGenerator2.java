package com.number.generator;

import static com.number.generator.util.GenerateNumberUtil.generateLines;
import static com.number.generator.validator.NumberOccuranceValidator.validateOccurances;
import static com.number.generator.validator.RulesValidator.loadRules;
import static com.number.generator.validator.RulesValidator.validateRules;
import static com.number.generator.util.GenerateNumberUtil.getLinesRequired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.number.generator.type.PlayType;
import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.GenerateNumberUtil;
import com.number.generator.validator.NumberOccuranceValidator;
import com.number.generator.util.RowNumbers;
import com.number.generator.validator.RulesValidator;

public class NumberGenerator2 {

	public static PlayType playType = PlayType.OZ;
	public static boolean testMode = false;
	public static boolean isOccuranceValid = false;
	public static Integer[] testLine = new Integer[]{4, 15, 37, 27, 35, 29, 31, 36};
	
	public static void setMode() {
		testMode = false;
		playType = PlayType.SFL;
		
		if(testMode) {
			playType.setRequiredLines(1);
			playType.setRepetitions(0);
		} else {
			playType.setRequiredLines(200);
			playType.setRepetitions(3);
		}
	}
	public static void main(String[] args) {
		setMode();
		
		int rawLineCount = 0;
		int numberOfTotalAttempts = 0;
		int numberOfValidOccuranceAttempts = 0;
		int numberOfValidRuleAttempts = 0;
		
		initPlayType(playType);
		
		loadRules();
		
		//HashMap<Integer, Integer> rulesMap = getRuleOccurances(RulesValidator.multiRules);
		List<ArrayList<Integer>> validLines = new ArrayList<ArrayList<Integer>>();
		while(true) {
			List<ArrayList<Integer>> rawLines = new ArrayList<ArrayList<Integer>>();
			
			RowNumbers.rawLines = rawLines;
			RowNumbers.generate_row_numbers();
			
			ColumnNumbers.rawLines = rawLines;
			ColumnNumbers.generate_column_numbers();
			
			rawLineCount += rawLines.size();	
			
			numberOfTotalAttempts++;

			List<ArrayList<Integer>> requiredRawLines;
			if(testMode) {
				isOccuranceValid = true;
				requiredRawLines = getTestLines();
			} else {
				requiredRawLines = getLinesRequired(rawLines);
				isOccuranceValid = validateOccurances(requiredRawLines);
				System.out.print("* ");
			}
			
			if(isOccuranceValid) {
				numberOfValidOccuranceAttempts++;
				//System.out.print("OV ");
				boolean isRulesValid = validateRules(requiredRawLines, validLines);
				if(isRulesValid) {
					numberOfValidRuleAttempts++;
					//System.out.print("RV ");
					System.out.println();
					generateLines(rawLineCount, validLines);
					System.out.println("Play type: " + playType.getValue());
					System.out.println("Raw lines per attempt: " + rawLines.size());
					System.out.println("Total number of raw attempts: " + numberOfTotalAttempts);
					System.out.println("Total number of valid occurances attempts: " + numberOfValidOccuranceAttempts);
					System.out.println("Total number of valid rule attempts: " + numberOfValidRuleAttempts);
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
		/*ArrayList<Integer> testLine = new ArrayList<Integer>();
		testLine.add(Arrays.asList(testLine));*/
		testLines.add(new ArrayList<Integer>(Arrays.asList(testLine)));
		return testLines;
	}
}










