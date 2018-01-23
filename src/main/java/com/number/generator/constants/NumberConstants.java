package com.number.generator.constants;

import java.util.HashMap;
import java.util.Map;

public class NumberConstants {

	public static final int MAX_MAIN_NUMBERS = 40;
	
	public static final int MAIN_NUMBER_SIZE = 6;
	
	public static final int MIN_COLUMN_NUMBERS = 4;
	public static final int MIN_DOZEN_NUMBERS = 4;
	public static final int MIN_WEIGHTAGE_NUMBERS = 3;
	
	public static final int DOZEN_SIZE = 12;
	
	public static final boolean USE_FLAG = true;
	public static final boolean USE_DATES = true;
	
	public static final boolean SUPPLEMENT_REQUIRED = true;
	public static final boolean ADD_SUPPLEMENTARY_WEIGHTAGE = true;
	public static final int MAX_SUPPLEMENTARY_NUMBERS = 20;
	public static final int SUPPLEMENTARY_NUMBER_SIZE = 1;
	
	public static final String[] DATES = new String[] { 
														"12-12-1951", 
														"5-9-1957", 
														"18-4-1975", 
														"8-2-1978", 
														"15-5-1983",
														"11-9-2012", 
														"21-6-1983", 
														"1-3-2017", 
														"13-6-2017", 
														"16-10-2017", 
														"21-10-2017", 
														"17-1-2018", 
														"22-1-2018",
														"16-1-2018" };
	
	public static final Map<Integer, Integer> MY_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	public static final Map<Integer, Integer> SYSTEM_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	public static final Map<Integer, Integer> SUPPLEMENTARY_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	static {
		MY_WEIGHTAGE.put(1, 0);
		MY_WEIGHTAGE.put(2, 5);
		MY_WEIGHTAGE.put(3, 0);
		MY_WEIGHTAGE.put(4, 10);
		MY_WEIGHTAGE.put(5, 5);
		MY_WEIGHTAGE.put(6, 10);
		MY_WEIGHTAGE.put(7, 10);
		MY_WEIGHTAGE.put(8, 10);
		MY_WEIGHTAGE.put(9, 10);
		MY_WEIGHTAGE.put(10, 0);
		MY_WEIGHTAGE.put(11, 10);
		MY_WEIGHTAGE.put(12, 10);
		
		MY_WEIGHTAGE.put(13, 0);
		MY_WEIGHTAGE.put(14, 0);
		MY_WEIGHTAGE.put(15, 10);
		MY_WEIGHTAGE.put(16, 0);
		MY_WEIGHTAGE.put(17, 0);
		MY_WEIGHTAGE.put(18, 0);
		MY_WEIGHTAGE.put(19, 10);
		MY_WEIGHTAGE.put(20, 0);
		MY_WEIGHTAGE.put(21, 10);
		MY_WEIGHTAGE.put(22, 5);
		MY_WEIGHTAGE.put(23, 10);
		MY_WEIGHTAGE.put(24, 5);
		
		MY_WEIGHTAGE.put(25, 0);
		MY_WEIGHTAGE.put(26, 10);
		MY_WEIGHTAGE.put(27, 0);
		MY_WEIGHTAGE.put(28, 10);
		MY_WEIGHTAGE.put(29, 10);
		MY_WEIGHTAGE.put(30, 0);
		MY_WEIGHTAGE.put(31, 10);
		MY_WEIGHTAGE.put(32, 10);
		MY_WEIGHTAGE.put(33, 10);
		MY_WEIGHTAGE.put(34, 5);
		MY_WEIGHTAGE.put(35, 10);
		MY_WEIGHTAGE.put(36, 5);
		
		MY_WEIGHTAGE.put(37, 0);
		MY_WEIGHTAGE.put(38, 0);
		MY_WEIGHTAGE.put(39, 0);
		MY_WEIGHTAGE.put(40, 0);
		
		MY_WEIGHTAGE.put(41, 0);
		MY_WEIGHTAGE.put(42, 0);
		MY_WEIGHTAGE.put(43, 0);
		MY_WEIGHTAGE.put(44, 0);
		MY_WEIGHTAGE.put(45, 0);
		
	}
	
	static {
		SYSTEM_WEIGHTAGE.put(1, 27);
		SYSTEM_WEIGHTAGE.put(2, 29);
		SYSTEM_WEIGHTAGE.put(3, 35);
		SYSTEM_WEIGHTAGE.put(4, 46);
		SYSTEM_WEIGHTAGE.put(5, 42);
		SYSTEM_WEIGHTAGE.put(6, 42);
		SYSTEM_WEIGHTAGE.put(7, 39);
		SYSTEM_WEIGHTAGE.put(8, 43);
		SYSTEM_WEIGHTAGE.put(9, 40);
		SYSTEM_WEIGHTAGE.put(10, 36);
		SYSTEM_WEIGHTAGE.put(11, 30);
		SYSTEM_WEIGHTAGE.put(12, 31);
		
		SYSTEM_WEIGHTAGE.put(13, 41);
		SYSTEM_WEIGHTAGE.put(14, 32);
		SYSTEM_WEIGHTAGE.put(15, 36);
		SYSTEM_WEIGHTAGE.put(16, 34);
		SYSTEM_WEIGHTAGE.put(17, 41);
		SYSTEM_WEIGHTAGE.put(18, 34);
		SYSTEM_WEIGHTAGE.put(19, 47);
		SYSTEM_WEIGHTAGE.put(20, 44);
		SYSTEM_WEIGHTAGE.put(21, 29);
		SYSTEM_WEIGHTAGE.put(22, 38);
		SYSTEM_WEIGHTAGE.put(23, 48);
		SYSTEM_WEIGHTAGE.put(24, 44);
		
		SYSTEM_WEIGHTAGE.put(25, 43);
		SYSTEM_WEIGHTAGE.put(26, 51);
		SYSTEM_WEIGHTAGE.put(27, 34);
		SYSTEM_WEIGHTAGE.put(28, 28);
		SYSTEM_WEIGHTAGE.put(29, 42);
		SYSTEM_WEIGHTAGE.put(30, 32);
		SYSTEM_WEIGHTAGE.put(31, 44);
		SYSTEM_WEIGHTAGE.put(32, 52);
		SYSTEM_WEIGHTAGE.put(33, 34);
		SYSTEM_WEIGHTAGE.put(34, 44);
		SYSTEM_WEIGHTAGE.put(35, 39);
		SYSTEM_WEIGHTAGE.put(36, 42);
		
		SYSTEM_WEIGHTAGE.put(37, 35);
		SYSTEM_WEIGHTAGE.put(38, 40);
		SYSTEM_WEIGHTAGE.put(39, 32);
		SYSTEM_WEIGHTAGE.put(40, 30);
		
		SYSTEM_WEIGHTAGE.put(41, 30);
		SYSTEM_WEIGHTAGE.put(42, 30);
		SYSTEM_WEIGHTAGE.put(43, 30);
		SYSTEM_WEIGHTAGE.put(44, 30);
		SYSTEM_WEIGHTAGE.put(45, 30);
	}
	
	static {
		SUPPLEMENTARY_WEIGHTAGE.put(1, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(2, 17);
		SUPPLEMENTARY_WEIGHTAGE.put(3, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(4, 9);
		SUPPLEMENTARY_WEIGHTAGE.put(5, 20);
		SUPPLEMENTARY_WEIGHTAGE.put(6, 12);
		SUPPLEMENTARY_WEIGHTAGE.put(7, 12);
		SUPPLEMENTARY_WEIGHTAGE.put(8, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(9, 14);
		SUPPLEMENTARY_WEIGHTAGE.put(10, 13);
		SUPPLEMENTARY_WEIGHTAGE.put(11, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(12, 17);
		
		SUPPLEMENTARY_WEIGHTAGE.put(13, 10);
		SUPPLEMENTARY_WEIGHTAGE.put(14, 7);
		SUPPLEMENTARY_WEIGHTAGE.put(15, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(16, 7);
		SUPPLEMENTARY_WEIGHTAGE.put(17, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(18, 17);
		SUPPLEMENTARY_WEIGHTAGE.put(19, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(20, 11);
	}
}
