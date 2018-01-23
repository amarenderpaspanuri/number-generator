package com.number.generator.util;

import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;
import static com.number.generator.constants.NumberConstants.MIN_COLUMN_NUMBERS;
import static com.number.generator.util.CommonUtil.add_to_final_numbers;
import static com.number.generator.util.CommonUtil.get_list_copy;
import static com.number.generator.util.CommonUtil.get_random_numbers_from_list_by_size;
import static com.number.generator.util.CommonUtil.get_sorted_numbers;

import java.util.ArrayList;
import java.util.List;

import com.number.generator.comparator.WeightageComparator;
import com.number.generator.dto.RandomNumber;

public final class ColumnUtil {

	public static List<RandomNumber> randomNumbers;
	
	/* 3 numbers*/
	public static void generate_column_numbers(){
		generate_numbers(randomNumbers);
		
		//sorted column numbers based on weightage
		List<RandomNumber> randomNumbersCopy = get_sorted_numbers(get_list_copy(randomNumbers), new WeightageComparator());
		generate_numbers(randomNumbersCopy);
	}
	
	private static void generate_numbers(List<RandomNumber> numbers){
		List<RandomNumber> firstColumnNumbers = get_column_numbers(numbers, 0, 3);
		List<RandomNumber> secondColumnNumbers = get_column_numbers(numbers, 1, 3);
		List<RandomNumber> thirdColumnNumbers = get_column_numbers(numbers, 2, 3);
		
		int diff = MAIN_NUMBER_SIZE - MIN_COLUMN_NUMBERS;
		List<RandomNumber> list = get_random_numbers_from_list_by_size(firstColumnNumbers, MIN_COLUMN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(secondColumnNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(thirdColumnNumbers, diff/2));
		add_to_final_numbers(list);
		
		list = get_random_numbers_from_list_by_size(secondColumnNumbers, MIN_COLUMN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(firstColumnNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(thirdColumnNumbers, diff/2));
		add_to_final_numbers(list);
		
		list = get_random_numbers_from_list_by_size(thirdColumnNumbers, MIN_COLUMN_NUMBERS);
		list.addAll(get_random_numbers_from_list_by_size(firstColumnNumbers, diff/2));
		list.addAll(get_random_numbers_from_list_by_size(secondColumnNumbers, diff/2));
		add_to_final_numbers(list);
	}
	
	private static List<RandomNumber> get_column_numbers(List<RandomNumber> list, int index, int increment) {
		List<RandomNumber> listCopy = get_list_copy(list);
		List<RandomNumber> columnList = new ArrayList<RandomNumber>();
		for(int i = index; i < listCopy.size();i += increment) {
			columnList.add(listCopy.get(i));
		}
		return columnList;
	}
}
