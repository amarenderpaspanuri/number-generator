package com.number.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.RowNumbers;

import static com.number.generator.constants.NumberConstants2.ROWS_REQUIRED;
import static com.number.generator.constants.NumberConstants2.MAX_NUMBERS_PER_ROW;
import static com.number.generator.constants.NumberConstants2.MAX_NUMBERS;
import static com.number.generator.constants.NumberConstants2.AVERAGE_FACTOR;

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
				int totalCount = rows.size();
				Random random = new Random();
				if(ROWS_REQUIRED != 0) {
					for(int i = 0; i < ROWS_REQUIRED; i++) {
						if(rows.size() == 0) {
							i = i-1;
						} else {
							int randomIndex = random.nextInt(rows.size());
							System.out.println(rows.get(randomIndex));
							rows.remove(randomIndex);
						}
					}
				} else {
					for(ArrayList<Integer> row : rows) {
						System.out.println(row);
					}
				}
				
				System.out.println("Total rows : " + totalCount);
				System.out.println("Required rows : " + (ROWS_REQUIRED != 0 ? ROWS_REQUIRED : rows.size()));
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
		int average = Math.round((totalNumbers / MAX_NUMBERS) - (MAX_NUMBERS_PER_ROW / 2));
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if((entry.getValue() < average) || (entry.getValue() > average * AVERAGE_FACTOR)) {
				return false;
			}
		}
		return true;
	}
}
