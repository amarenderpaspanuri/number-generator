package com.number.generator.constants;

import java.util.HashMap;
import java.util.Map;

public class NumberConstants {

	public static final int MAX_MAIN_NUMBERS = 45;
	public static final int MAIN_NUMBER_SIZE = 6;
	
	public static final int MIN_COLUMN_NUMBERS = 4;
	public static final int MIN_DOZEN_NUMBERS = 4;
	public static final int MIN_WEIGHTAGE_NUMBERS = 3;
	
	public static final int DOZEN_SIZE = 15;
	
	public static final boolean GENERATE_WEIGHTAGE_NUMBERS = true;
	public static final boolean GENERATE_COLUMN_NUMBERS = true;
	public static final boolean GENERATE_DOZEN_NUMBERS = true;
	public static final boolean GENERATE_FLAG_NUMBERS = true;
	
	public static final boolean USE_FLAG = true;
	public static final boolean USE_DATES = true;
	public static final boolean ADD_SYSTEM_WEIGHTAGE = true;
	public static final boolean ADD_MY_WEIGHTAGE = true;
	public static final boolean ADD_DATE_WEIGHTAGE = true;
	
	public static final boolean SUPPLEMENT_REQUIRED = false;
	public static final boolean ADD_SUPPLEMENTARY_WEIGHTAGE = false;
	public static final int MAX_SUPPLEMENTARY_NUMBERS = 20;
	public static final int SUPPLEMENTARY_NUMBER_SIZE = 1;
	
	public static final String[] IMPORTANT_DATES = new String[] { 
														"12-12-1951", 
														"5-9-1957", 
														"18-4-1975", 
														"8-2-1978", 
														"15-5-1983",
														"11-9-2012", 
														"21-6-1983", 
														"1-3-2017", 
														"13-6-2017", 
														"16-6-2017",
														"16-10-2017", 
														"21-10-2017", 
														"17-1-2018", 
														"22-1-2018",
														"8-2-2018",
														"10-2-2018"};
	
	public static final Map<Integer, Integer> MY_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	public static final Map<Integer, Integer> SYSTEM_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	public static final Map<Integer, Integer> SUPPLEMENTARY_WEIGHTAGE = new HashMap<Integer, Integer>();
	
	static {
		MY_WEIGHTAGE.put(1, 5);				MY_WEIGHTAGE.put(2, 5);				MY_WEIGHTAGE.put(3, 5);
		MY_WEIGHTAGE.put(4, 10);			MY_WEIGHTAGE.put(5, 5);				MY_WEIGHTAGE.put(6, 10);
		MY_WEIGHTAGE.put(7, 10);			MY_WEIGHTAGE.put(8, 10);			MY_WEIGHTAGE.put(9, 10);
		MY_WEIGHTAGE.put(10, 5);			MY_WEIGHTAGE.put(11, 10);			MY_WEIGHTAGE.put(12, 10);
//      -------------------------------------------------------------------------------------------------
		MY_WEIGHTAGE.put(13, 10);			MY_WEIGHTAGE.put(14, 5);			MY_WEIGHTAGE.put(15, 10);
		MY_WEIGHTAGE.put(16, 5);			MY_WEIGHTAGE.put(17, 10);			MY_WEIGHTAGE.put(18, 5);
		MY_WEIGHTAGE.put(19, 10);			MY_WEIGHTAGE.put(20, 5);			MY_WEIGHTAGE.put(21, 10);
		MY_WEIGHTAGE.put(22, 5);			MY_WEIGHTAGE.put(23, 10);			MY_WEIGHTAGE.put(24, 5);
//      -------------------------------------------------------------------------------------------------
		MY_WEIGHTAGE.put(25, 5);			MY_WEIGHTAGE.put(26, 10); 			MY_WEIGHTAGE.put(27, 10);
		MY_WEIGHTAGE.put(28, 10);			MY_WEIGHTAGE.put(29, 5);			MY_WEIGHTAGE.put(30, 5);
		MY_WEIGHTAGE.put(31, 10);			MY_WEIGHTAGE.put(32, 5);			MY_WEIGHTAGE.put(33, 10);
		MY_WEIGHTAGE.put(34, 5);			MY_WEIGHTAGE.put(35, 5);			MY_WEIGHTAGE.put(36, 5);
//      -------------------------------------------------------------------------------------------------
		MY_WEIGHTAGE.put(37, 10);			MY_WEIGHTAGE.put(38, 5);			MY_WEIGHTAGE.put(39, 5);
		MY_WEIGHTAGE.put(40, 5);			MY_WEIGHTAGE.put(41, 5);			MY_WEIGHTAGE.put(42, 5);
		MY_WEIGHTAGE.put(43, 10);			MY_WEIGHTAGE.put(44, 10);			MY_WEIGHTAGE.put(45, 5);
	}
	
	static {
		SYSTEM_WEIGHTAGE.put(1, 337);		SYSTEM_WEIGHTAGE.put(2, 292);		SYSTEM_WEIGHTAGE.put(3, 307);
		SYSTEM_WEIGHTAGE.put(4, 305);		SYSTEM_WEIGHTAGE.put(5, 318);		SYSTEM_WEIGHTAGE.put(6, 307);
		SYSTEM_WEIGHTAGE.put(7, 320);		SYSTEM_WEIGHTAGE.put(8, 330);		SYSTEM_WEIGHTAGE.put(9, 293);
		SYSTEM_WEIGHTAGE.put(10, 289);		SYSTEM_WEIGHTAGE.put(11, 329);		SYSTEM_WEIGHTAGE.put(12, 305);
//      ------------------------------------------------------------------------------------------------------
		SYSTEM_WEIGHTAGE.put(13, 301);		SYSTEM_WEIGHTAGE.put(14, 277);		SYSTEM_WEIGHTAGE.put(15, 309);
		SYSTEM_WEIGHTAGE.put(16, 303);		SYSTEM_WEIGHTAGE.put(17, 276);		SYSTEM_WEIGHTAGE.put(18, 309);
		SYSTEM_WEIGHTAGE.put(19, 298);		SYSTEM_WEIGHTAGE.put(20, 297);		SYSTEM_WEIGHTAGE.put(21, 301);
		SYSTEM_WEIGHTAGE.put(22, 315);		SYSTEM_WEIGHTAGE.put(23, 316);		SYSTEM_WEIGHTAGE.put(24, 295);
//      ------------------------------------------------------------------------------------------------------
		SYSTEM_WEIGHTAGE.put(25, 312);		SYSTEM_WEIGHTAGE.put(26, 312);		SYSTEM_WEIGHTAGE.put(27, 282);
		SYSTEM_WEIGHTAGE.put(28, 295);		SYSTEM_WEIGHTAGE.put(29, 298);		SYSTEM_WEIGHTAGE.put(30, 287);
		SYSTEM_WEIGHTAGE.put(31, 298);		SYSTEM_WEIGHTAGE.put(32, 304);		SYSTEM_WEIGHTAGE.put(33, 314);
		SYSTEM_WEIGHTAGE.put(34, 304);		SYSTEM_WEIGHTAGE.put(35, 278);		SYSTEM_WEIGHTAGE.put(36, 312);
//      ------------------------------------------------------------------------------------------------------
		SYSTEM_WEIGHTAGE.put(37, 289);		SYSTEM_WEIGHTAGE.put(38, 291);		SYSTEM_WEIGHTAGE.put(39, 287);
		SYSTEM_WEIGHTAGE.put(40, 325);		SYSTEM_WEIGHTAGE.put(41, 314);		SYSTEM_WEIGHTAGE.put(42, 314);
		SYSTEM_WEIGHTAGE.put(43, 295);		SYSTEM_WEIGHTAGE.put(44, 275);		SYSTEM_WEIGHTAGE.put(45, 293);
	}
	
	static {
		SUPPLEMENTARY_WEIGHTAGE.put(1, 11);		SUPPLEMENTARY_WEIGHTAGE.put(11, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(2, 17);		SUPPLEMENTARY_WEIGHTAGE.put(12, 17);
		SUPPLEMENTARY_WEIGHTAGE.put(3, 11);		SUPPLEMENTARY_WEIGHTAGE.put(13, 7);
		SUPPLEMENTARY_WEIGHTAGE.put(4, 9);		SUPPLEMENTARY_WEIGHTAGE.put(14, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(5, 20);		SUPPLEMENTARY_WEIGHTAGE.put(15, 7);
		SUPPLEMENTARY_WEIGHTAGE.put(6, 12);		SUPPLEMENTARY_WEIGHTAGE.put(16, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(7, 12);		SUPPLEMENTARY_WEIGHTAGE.put(17, 17);
		SUPPLEMENTARY_WEIGHTAGE.put(8, 11);		SUPPLEMENTARY_WEIGHTAGE.put(18, 15);
		SUPPLEMENTARY_WEIGHTAGE.put(9, 14);		SUPPLEMENTARY_WEIGHTAGE.put(19, 11);
		SUPPLEMENTARY_WEIGHTAGE.put(10, 13);	SUPPLEMENTARY_WEIGHTAGE.put(20, 11);
	}
}
