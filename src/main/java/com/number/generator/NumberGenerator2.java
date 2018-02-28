package com.number.generator;

import static com.number.generator.util.GenerateNumberUtil.generateLines;
import static com.number.generator.util.GenerateNumberUtil.getLinesRequired;
import static com.number.generator.util.NumberOccuranceValidator.validateOccurances;
import static com.number.generator.util.RulesValidator.loadRules;
import static com.number.generator.util.RulesValidator.validateRules;

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
		
		List<ArrayList<Integer>> rules = loadRules();
		while(true) {
			List<ArrayList<Integer>> totalLines = new ArrayList<ArrayList<Integer>>();
			HashMap<Integer, Integer> numberStatsMap = new HashMap<Integer, Integer>();
			
			RowNumbers.totalLines = totalLines;
			RowNumbers.generate_row_numbers();
			
			ColumnNumbers.totalLines = totalLines;
			ColumnNumbers.generate_column_numbers();
			
			int totalLineCount = totalLines.size();
			
			List<ArrayList<Integer>> requiredLines = getLinesRequired(totalLines);
			
			boolean isFrequencyValid = validateOccurances(requiredLines, numberStatsMap);	
			if(isFrequencyValid) {
				boolean isRulesValid = validateRules(rules, totalLines);
				System.out.print(count++ + " ");
				if(isRulesValid) {
					generateLines(totalLineCount, requiredLines, numberStatsMap);
					break;
				}
			}
		}
	}
}
