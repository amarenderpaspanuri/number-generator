package com.number.generator.util;

import static com.number.generator.constants.NumberConstants2.DUPLICATES_ALLOWED;
import static com.number.generator.constants.NumberConstants2.MAX_NUMBERS_PER_ROW;
import static com.number.generator.constants.NumberConstants2.MAX_ROWS;
import static com.number.generator.constants.NumberConstants2.TOTAL_NUMBERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public final class RowNumbers {

	public static List<ArrayList<Integer>> rows;

	public static void main(String[] args) {
		rows = new ArrayList<ArrayList<Integer>>();
		generate_row_numbers();
	}

	public static void generate_row_numbers() {
		int maxColumns = TOTAL_NUMBERS;

		int columnCount = 1;
		while (columnCount <= maxColumns) {
			int rowCount = TOTAL_NUMBERS / columnCount;
			int extraColumnCount = TOTAL_NUMBERS - (rowCount * columnCount);
			int[][] numbers = new int[rowCount][columnCount + extraColumnCount];
			int count = 1;
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					if (count <= TOTAL_NUMBERS) {
						numbers[i][j] = count;
						count++;
					}
				}
			}
			if(extraColumnCount > 0) {
				Random random = new Random();
				count = rowCount * columnCount;
				while (count < TOTAL_NUMBERS) {
					int[] row = numbers[random.nextInt(numbers.length)];
					int index = random.nextInt(row.length - columnCount) + columnCount;
					int number = row[index];
					if (number != 0) {
						continue;
					} else {
						row[index] = ++count;
					}
				}
			}
			generate_numbers(numbers);
			columnCount++;
		}
	}
	
	public static void generate_numbers(final int[][] numbers) {
		if (numbers[0].length == 1) {
			generate_single_column_numbers(numbers);
		} else {
			generate_multi_column_numbers(numbers);
		}
	}

	public static void generate_single_column_numbers(final int[][] numbers) {
		int rowCount = 1;
		while (rowCount <= MAX_ROWS) {
			final List<Integer> row = new ArrayList<Integer>();
			Random random = new Random();
			int count = 1;
			while (count <= MAX_NUMBERS_PER_ROW) {
				int rowIndex = random.nextInt(numbers.length);
				int columnIndex = 0;
				int number = numbers[rowIndex][columnIndex];
				while (number == 0) {
					rowIndex = random.nextInt(numbers.length);
					number = numbers[rowIndex][columnIndex];
				}
				if (DUPLICATES_ALLOWED) {
					row.add(number);
					count++;
				} else if (!row.contains(number)) {
					row.add(number);
					count++;
				}
			}
			check_if_row_existz(row);
			rowCount++;
		}
	}

	public static void generate_multi_column_numbers(final int[][] numbers) {
		int rowCount = 1;
		while (rowCount <= MAX_ROWS) {
			final List<Integer> row = new ArrayList<Integer>();
			Random random = new Random();
			int count = 1;
			while (count <= MAX_NUMBERS_PER_ROW) {
				int rowIndex = random.nextInt(numbers.length);
				int columnIndex = random.nextInt(numbers[rowIndex].length);

				int number = numbers[rowIndex][columnIndex];
				while (number == 0) {
					columnIndex = random.nextInt(numbers[rowIndex].length);
					number = numbers[rowIndex][columnIndex];
				}
				if (DUPLICATES_ALLOWED) {
					row.add(number);
					count++;
				} else if (!row.contains(number)) {
					row.add(number);
					count++;
				}
			}
			check_if_row_existz(row);
			rowCount++;
		}
	}

	public static boolean check_if_row_existz(List<Integer> row) {
		boolean exists = true;
		if (rows.isEmpty()) {
			exists = false;
		} else {
			for (ArrayList<Integer> existingList : rows) {
				exists = rowEqualsRow(existingList, row);
				if (!exists) {
					break;
				}
			}
		}
		if (!exists) {
			Collections.sort(row);
			rows.add((ArrayList<Integer>) row);
		}
		return exists;
	}

	private static boolean rowEqualsRow(List<Integer> row1, List<Integer> row2) {
		return new HashSet<Integer>(row1).equals(new HashSet<Integer>(row2));
	}
}
