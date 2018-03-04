package com.number.generator;

import static com.number.generator.util.GenerateNumberUtil.generateLines;
import static com.number.generator.util.GenerateNumberUtil.getLinesRequired;
import static com.number.generator.util.NumberOccuranceValidator.validateOccurances;
import static com.number.generator.util.RulesValidator.loadRules;
import static com.number.generator.util.RulesValidator.validateRules;
import static com.number.generator.util.RulesValidator.getRuleOccurances;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.number.generator.type.PlayType;
import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.GenerateNumberUtil;
import com.number.generator.util.NumberOccuranceValidator;
import com.number.generator.util.RowNumbers;
import com.number.generator.util.RulesValidator;

public class NumberGenerator2 {

	public static void main(String[] args) {
		int count = 1;
		PlayType playType = PlayType.OZ;
		
		RulesValidator.playType = playType;
		GenerateNumberUtil.playType = playType;
		RowNumbers.playType = playType;
		ColumnNumbers.playType = playType;
		NumberOccuranceValidator.playType = playType;
		
		loadRules();
		HashMap<Integer, Integer> rulesMap = getRuleOccurances(RulesValidator.multiRules);
		List<ArrayList<Integer>> validLines = new ArrayList<ArrayList<Integer>>();
		while(true) {
			List<ArrayList<Integer>> rawLines = new ArrayList<ArrayList<Integer>>();
			HashMap<Integer, Integer> numbersMap = new HashMap<Integer, Integer>();
			
			RowNumbers.rawLines = rawLines;
			RowNumbers.generate_row_numbers();
			
			ColumnNumbers.rawLines = rawLines;
			ColumnNumbers.generate_column_numbers();
			
			int totalLineCount = rawLines.size();
			
			//List<ArrayList<Integer>> requiredLines = getLinesRequired(rawLines);
			
			boolean isFrequencyValid = validateOccurances(rawLines, numbersMap);	
			if(isFrequencyValid) {
				boolean isRulesValid = validateRules(rawLines, validLines);
				System.out.print(". ");
				count++;
				if(isRulesValid) {
					System.out.println();
					generateLines(totalLineCount, rawLines, numbersMap, rulesMap);
					System.out.println("Number of attempts: " + count);
					break;
				}
			}
		}
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
}
