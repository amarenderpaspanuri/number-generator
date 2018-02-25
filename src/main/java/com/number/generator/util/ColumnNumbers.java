package com.number.generator.util;

import static com.number.generator.constants.NumberConstants2.DUPLICATES_ALLOWED;
import static com.number.generator.constants.NumberConstants2.NUMBERS_PER_LINE;
import static com.number.generator.constants.NumberConstants2.NUMBER_OF_REPETITIONS;
import static com.number.generator.constants.NumberConstants2.MAX_SUPPLEMTARY_NUMBER;
import static com.number.generator.constants.NumberConstants2.NEED_SUPPLEMANTARY_NUMBER;
import static com.number.generator.constants.NumberConstants2.NUMBER_LIMIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public final class ColumnNumbers {

	public static List<ArrayList<Integer>> totalLines;

	public static void main(String[] args) {
		totalLines = new ArrayList<ArrayList<Integer>>();
		generate_column_numbers();
	}

	public static void generate_column_numbers() {
		int maxColumns = NUMBER_LIMIT;

		int rowCount = 1;
		while (rowCount <= maxColumns) {
			int columnCount = NUMBER_LIMIT / rowCount;
			int extraRowCount = NUMBER_LIMIT - (columnCount * rowCount);
			int[][] numbers = new int[rowCount][columnCount + extraRowCount];
			int count = 1;
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++) {
					if (count <= NUMBER_LIMIT) {
						numbers[i][j] = count;
						count++;
					}
				}
			}
			if(extraRowCount > 0) {
				Random random = new Random();
				count = columnCount * rowCount;
				while (count < NUMBER_LIMIT) {
					//Random random = new Random();
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
		while (rowCount <= NUMBER_OF_REPETITIONS) {
			final List<Integer> row = new ArrayList<Integer>();
			Random random = new Random();
			int count = 1;
			while (count <= NUMBERS_PER_LINE) {
				int rowIndex = 0;
				//Random random = new Random();
				int columnIndex = random.nextInt(numbers[rowIndex].length);
				int number = numbers[rowIndex][columnIndex];
				while (number == 0) {
					random = new Random();
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
		while (rowCount <= NUMBER_OF_REPETITIONS) {
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
				//Random random = new Random();
				outerList.get(random.nextInt(outerList.size())).add(number);
			}

			final List<Integer> row = new ArrayList<Integer>();
			int count = 1;
			while (count <= NUMBERS_PER_LINE) {
				//Random random = new Random();
				int randomOuterIndex = random.nextInt(outerList.size());
				int randomInnerIndex = random.nextInt(outerList.get(randomOuterIndex).size());

				int number = outerList.get(randomOuterIndex).get(randomInnerIndex);
				while (number == 0) {
					random = new Random();
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
		if(!supplemantaryNumberExists(row)) {
			return false;
		}
		boolean exists = true;
		if (totalLines.isEmpty()) {
			exists = false;
		} else {
			for (ArrayList<Integer> existingList : totalLines) {
				exists = rowEqualsRow(existingList, row);
				if (!exists) {
					break;
				}
			}
		}
		if (!exists) {
			Collections.sort(row);
			totalLines.add((ArrayList<Integer>) row);
		}
		return exists;
	}

	private static boolean rowEqualsRow(List<Integer> row1, List<Integer> row2) {
		return new HashSet<Integer>(row1).equals(new HashSet<Integer>(row2));
	}
	
	private static boolean supplemantaryNumberExists(List<Integer> row) {
		if(NEED_SUPPLEMANTARY_NUMBER) {
			for(int number : row) {
				if(number > 0 && number <= MAX_SUPPLEMTARY_NUMBER) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}