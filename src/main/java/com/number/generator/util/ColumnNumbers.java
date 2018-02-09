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

public final class ColumnNumbers {

	public static List<ArrayList<Integer>> rows;

	public static void main(String[] args) {
		rows = new ArrayList<ArrayList<Integer>>();
		generate_column_numbers();
	}

	public static void generate_column_numbers() {
		int maxColumns = TOTAL_NUMBERS;

		int rowCount = 1;
		while (rowCount <= maxColumns) {
			int columnCount = TOTAL_NUMBERS / rowCount;
			int extraRowCount = TOTAL_NUMBERS - (columnCount * rowCount);
			int[][] numbers = new int[rowCount][columnCount + extraRowCount];
			int count = 1;
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					if (count <= TOTAL_NUMBERS) {
						numbers[i][j] = count;
						count++;
					}
				}
			}
			if(extraRowCount > 0) {
				Random random = new Random();
				count = columnCount * rowCount;
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
			rowCount++;
		}
	}
	
	public static void generate_numbers(final int[][] numbers) {
		if (numbers.length == 1) {
			generate_single_row_numbers(numbers);
		} else {
			generate_multi_row_numbers(numbers);
		}
	}

	public static void generate_single_row_numbers(final int[][] numbers) {
		int rowCount = 1;
		while (rowCount <= MAX_ROWS) {
			final List<Integer> row = new ArrayList<Integer>();
			Random random = new Random();
			int count = 1;
			while (count <= MAX_NUMBERS_PER_ROW) {
				int rowIndex = 0;
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

	public static void generate_multi_row_numbers(final int[][] numbers) {
		int rowCount = 1;
		while (rowCount <= MAX_ROWS) {
			final List<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> extraList = new ArrayList<Integer>();
			for (int columnIndex = 0; columnIndex < numbers[0].length; columnIndex++) {
				ArrayList<Integer> innerList = new ArrayList<Integer>();
				for (int rowIndex = 0; rowIndex < numbers.length; rowIndex++) {
					int number = numbers[rowIndex][columnIndex];
					if(number > 0) {
						innerList.add(number);
					}
				}
				if(!innerList.isEmpty()) {
					if(outerList.isEmpty()) {
						outerList.add(innerList);
					} else {
						if(innerList.size() < outerList.get(0).size()/2) {
							extraList.addAll(innerList);
						} else {
							outerList.add(innerList);
						}
					}
				}
			}

			Random random = new Random();

			for(int number : extraList) {
				outerList.get(random.nextInt(outerList.size())).add(number);
			}

			final List<Integer> row = new ArrayList<Integer>();
			int count = 1;
			while (count <= MAX_NUMBERS_PER_ROW) {
				int randomOuterIndex = random.nextInt(outerList.size());
				int randomInnerIndex = random.nextInt(outerList.get(randomOuterIndex).size());

				int number = outerList.get(randomOuterIndex).get(randomInnerIndex);
				while (number == 0) {
					randomInnerIndex = random.nextInt(outerList.get(randomOuterIndex).size());
					number = outerList.get(randomOuterIndex).get(randomInnerIndex);
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
