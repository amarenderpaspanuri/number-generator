package com.number.generator.util;

import static com.number.generator.constants.NumberConstants.MAIN_NUMBER_SIZE;
import static com.number.generator.constants.NumberConstants.MAX_SUPPLEMENTARY_NUMBERS;
import static com.number.generator.constants.NumberConstants.SUPPLEMENTARY_WEIGHTAGE;
import static com.number.generator.constants.NumberConstants.ADD_SUPPLEMENTARY_WEIGHTAGE;
import static com.number.generator.util.CommonUtil.addDigits;
import static com.number.generator.util.CommonUtil.getString;

import java.util.ArrayList;
import java.util.List;

import com.number.generator.dto.RandomNumber;

public final class SupplementaryUtil {

	public static List<ArrayList<RandomNumber>> finalNumbers;
	private static List<RandomNumber> supplementaryNumbers;
	
	public static void generate_supplementary_number(){
		for(ArrayList<RandomNumber> list : finalNumbers) {
			supplementaryNumbers = new ArrayList<RandomNumber>();
			for(int i=1; i <= MAX_SUPPLEMENTARY_NUMBERS; i++) {
				RandomNumber randomNumber = new RandomNumber();
				randomNumber.setValue(i);
				if(ADD_SUPPLEMENTARY_WEIGHTAGE) {
					randomNumber.setWeightage(SUPPLEMENTARY_WEIGHTAGE.get(i));
				}
				supplementaryNumbers.add(randomNumber);
			}
		
			isAverage(list);
			isEquals(list);
			isMultiple(list);
			isEndsWith(list);
			isAddsWith(list);
			
			add_supplementary_number(list);
		}
	}
	
	private static void isAverage(ArrayList<RandomNumber> finalNumbers) {
		int average = Math.round(getSum(finalNumbers)/MAIN_NUMBER_SIZE);
		if(SUPPLEMENTARY_WEIGHTAGE.get(average) != null) {
			RandomNumber supplementaryNumber = supplementaryNumbers.get(average - 1);
			supplementaryNumber.setAverage(true);
		}
	}
	
	private static void isEquals(ArrayList<RandomNumber> finalNumbers) {
		for (RandomNumber finalNumber : finalNumbers) {
			if(finalNumber.getValue() <= MAX_SUPPLEMENTARY_NUMBERS) {
				RandomNumber supplementaryNumber = supplementaryNumbers.get(finalNumber.getValue() - 1);
				supplementaryNumber.setEquals(true);
			}
		}
	}

	private static void isMultiple(ArrayList<RandomNumber> finalNumbers) {
		for (RandomNumber finalNumber : finalNumbers) {
			for (RandomNumber supplementaryNumber : supplementaryNumbers) {
				if ((finalNumber.getValue() % supplementaryNumber.getValue()) == 0) {
					supplementaryNumber.setMultiple(true);
				}
			}
		}
	}

	private static void isEndsWith(ArrayList<RandomNumber> finalNumbers) {
		for (RandomNumber finalNumber : finalNumbers) {
			String[] finalNumberArray = getString(finalNumber.getValue()).split("");
			String finalNumberEndsWith = finalNumberArray[finalNumberArray.length - 1];
			
			for (RandomNumber supplementaryNumber : supplementaryNumbers) {
				String[] supplementaryNumberArray = getString(supplementaryNumber.getValue()).split("");
				String supplementaryNumberEndsWith = supplementaryNumberArray[supplementaryNumberArray.length - 1];
				if (finalNumberEndsWith.equals(supplementaryNumberEndsWith)) {
					supplementaryNumber.setAddsWith(true);
				}
			}
		}
	}

	private static void isAddsWith(ArrayList<RandomNumber> finalNumbers) {
		for (RandomNumber finalNumber : finalNumbers) {
			if (finalNumber.getValue() > 9) {
				int finalNumberValue = addDigits(finalNumber.getValue());
				if (finalNumber.getValue() > 9) {
					RandomNumber supplementaryNumber = supplementaryNumbers.get(finalNumberValue - 1);
					supplementaryNumber.setEquals(true);
				}
			}
		}
	}
	
	private static void add_supplementary_number(ArrayList<RandomNumber> finalNumbers) {
		for (RandomNumber number : supplementaryNumbers) {
			if (number.isAverage() && number.isEquals() && number.isMultiple() && number.isEndsWith() && number.isAddsWith()) {
				finalNumbers.add(number);
			}
		}
	}
	
	private static int getSum(ArrayList<RandomNumber> list) {
		int sum = 0;
		for(RandomNumber number : list) {
			sum += number.getValue();
		}
		return sum;
	}
}
