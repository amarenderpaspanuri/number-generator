package com.number.generator.util;

import static com.number.generator.constants.NumberConstants2.LINES_REQUIRED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public final class GenerateNumberUtil {

	public static List<ArrayList<Integer>> getLinesRequired(List<ArrayList<Integer>> lines) {
		Random random = new Random();
		if(LINES_REQUIRED != 0) {
			List<ArrayList<Integer>> requiredLines = new ArrayList<ArrayList<Integer>>(); 
			for(int i = 0; i < LINES_REQUIRED; i++) {
				if(lines.isEmpty()) {
					i = i-1;
				} else {
					int randomIndex = random.nextInt(lines.size());
					requiredLines.add(lines.get(randomIndex));
					lines.remove(randomIndex);
				}
			}
			return requiredLines;
		} 
		return lines;
	}
	
	public static void generateLines(int totalLineCount, List<ArrayList<Integer>> lines, HashMap<Integer, Integer> map) {
		for(ArrayList<Integer> line : lines) {
			System.out.println(line);
		}
		
		System.out.println("Total Lines : " + totalLineCount);
		System.out.println("Required Lines : " + lines.size());
		System.out.println(map);
	}
}
