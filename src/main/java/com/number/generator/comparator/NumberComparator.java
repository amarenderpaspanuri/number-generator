package com.number.generator.comparator;

import java.util.Comparator;

public class NumberComparator implements Comparator<Integer> {

	public int compare(Integer number1, Integer number2) {
		if (number2 == number1)
			return 0;
		else if (number1 > number2)
			return 1;
		else
			return -1;
	}
}
