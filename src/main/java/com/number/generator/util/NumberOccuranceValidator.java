package com.number.generator.util;

import static com.number.generator.constants.NumberConstants2.MAX_NUMBER_OCCURANCE_FACTOR;
import static com.number.generator.constants.NumberConstants2.NUMBERS_PER_LINE;
import static com.number.generator.constants.NumberConstants2.NUMBER_LIMIT;
import static com.number.generator.constants.NumberConstants2.MIN_NUMBER_OCCURANCE_FACTOR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NumberOccuranceValidator {

	public static boolean validateOccurances(List<ArrayList<Integer>> lines, HashMap<Integer, Integer> map) {
		int rowCount = lines.size();
		
		for(ArrayList<Integer> row : lines) {
			countNumberOccurances(row, map);
		}
		
		int totalNumbers = rowCount * NUMBERS_PER_LINE;
		int average = Math.round(totalNumbers / NUMBER_LIMIT);
		//int minFrequency = Math.round(average - (NUMBERS_PER_LINE / 2));
		int minFrequency = Math.round(average * MIN_NUMBER_OCCURANCE_FACTOR);
		int maxFrequency = Math.round(average * MAX_NUMBER_OCCURANCE_FACTOR);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if((entry.getValue() <= minFrequency) || (entry.getValue() >= maxFrequency)) {
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
