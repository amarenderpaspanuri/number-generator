package com.number.generator.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.number.generator.type.PlayType;

public final class NumberOccuranceValidator {

	public static PlayType playType;
	
	public static boolean validateOccurances(List<ArrayList<Integer>> lines) {
		HashMap<Integer, Integer> map = getNumberOccurances(lines);
		
		int rowCount = lines.size();
		
		int totalNumbers = rowCount * playType.getNumbersPerLine();
		int average = Math.round(totalNumbers / playType.getNumberLimit());
		int minFrequency = Math.round(average * playType.getMinNumberOccuranceFactor());
		int maxFrequency = Math.round(average * playType.getMaxNumberOccuranceFactor());
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if((entry.getValue() <= minFrequency) || (entry.getValue() > maxFrequency)) {
				return false;
			}
		}
		return true;
	}
	
	public static HashMap<Integer, Integer> getNumberOccurances(List<ArrayList<Integer>> lines) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(ArrayList<Integer> row : lines) {
			countNumberOccurances(row, map);
		}
		
		return map;
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
