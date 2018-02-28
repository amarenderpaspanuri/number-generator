package com.number.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.number.generator.type.PlayType;

public final class NumberOccuranceValidator {

	public static PlayType playType;
	
	public static boolean validateOccurances(List<ArrayList<Integer>> lines, HashMap<Integer, Integer> map) {
		int rowCount = lines.size();
		
		for(ArrayList<Integer> row : lines) {
			countNumberOccurances(row, map);
		}
		
		int totalNumbers = rowCount * playType.getNumbersPerLine();
		int average = Math.round(totalNumbers / playType.getNumberLimit());
		//int minFrequency = Math.round(average - (NUMBERS_PER_LINE / 2));
		int minFrequency = Math.round(average * playType.getMinNumberOccuranceFactor());
		int maxFrequency = Math.round(average * playType.getMaxNumberOccuranceFactor());
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if((entry.getValue() <= minFrequency) || (entry.getValue() > maxFrequency)) {
				return false;
			}
		}
		return true;
	}
	
	public static void countNumberOccurances(List<Integer> row, Map<Integer, Integer> map) {
		for(int number : row) {
			if(map.containsKey(number)) {
				map.put(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}
	}
}
