package com.number.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.number.generator.util.ColumnNumbers;
import com.number.generator.util.RowNumbers;

import static com.number.generator.constants.NumberConstants2.FINAL_ROW_COUNT;;

public class NumberGenerator2 {

	public static void main(String[] args) {
		List<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
		
		RowNumbers.rows = rows;
		RowNumbers.generate_row_numbers();
		
		ColumnNumbers.rows = rows;
		ColumnNumbers.generate_column_numbers();
		
		for(ArrayList<Integer> row : rows) {
			System.out.println(row);
		}
		/*Random random = new Random();
		for(int i=0; i < FINAL_ROW_COUNT; i++) {
			int index = random.nextInt(rows.size());
			System.out.println(rows.get(index));
			rows.remove(index);
		}*/
	}
}
