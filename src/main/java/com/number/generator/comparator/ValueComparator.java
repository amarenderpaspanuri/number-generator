package com.number.generator.comparator;

import java.util.Comparator;

import com.number.generator.dto.RandomNumber;

public class ValueComparator implements Comparator<RandomNumber> {

	public int compare(RandomNumber number1, RandomNumber number2) {
		if (number1.getValue() == number2.getValue())
			return 0;
		else if (number1.getValue() > number2.getValue())
			return 1;
		else
			return -1;
	}
}
