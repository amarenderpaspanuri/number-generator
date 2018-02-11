package com.number.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.RowNumbers;

import static com.number.generator.constants.NumberConstants2.FINAL_ROW_COUNT;
import static com.number.generator.constants.NumberConstants2.MAX_NUMBERS_PER_ROW;

public class NumberGenerator2 {

	public static void main(String[] args) {
		while(true) {
			List<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
			
			RowNumbers.rows = rows;
			RowNumbers.generate_row_numbers();
			
			ColumnNumbers.rows = rows;
			ColumnNumbers.generate_column_numbers();
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(ArrayList<Integer> row : rows) {
				countNumberOccurances(row, map);
			}
			
			if(checkIsValidNumbers(map, rows.size())) {
				for(ArrayList<Integer> row : rows) {
					System.out.println(row);
				}
				System.out.println("Total rows : " + rows.size());
				System.out.println(map);
				break;
			}
		}
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
	
	public static boolean checkIsValidNumbers(Map<Integer, Integer> map, int rowCount) {
		int totalNumbers = rowCount * MAX_NUMBERS_PER_ROW;
		//int average = Math.round(totalNumbers / rowCount);
		int average = Math.round(rowCount / MAX_NUMBERS_PER_ROW);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(!(entry.getValue() >= 9)) {
				return false;
			}
		}
		/*for(int number : row) {
			if(map.containsKey(number)) {
				map.put(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}*/
		return true;
	}
}
