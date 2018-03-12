package com.number.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckNumber {

    public static void main(String[] args) {

        CheckNumber obj = new CheckNumber();
        obj.checkNumber("numbers.txt");
    }

    private void checkNumber(String fileName) {

        String jp = "4, 15, 37, 27, 35, 29, 31, 36";
        jp = jp.replace(" ", "");

        List<String> jpNumbers = getList(jp);

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> lineNumbers = getList(line.replace("[", "").replace("]", "").replace(" ", ""));

                int count = 0;
                List<String> matchList = new ArrayList<String>();
                for(String jpNumber : jpNumbers) {
                    for(String lineNumber : lineNumbers) {
                        if(jpNumber.equals(lineNumber)) {
                            matchList.add(jpNumber);
                            count++;
                        }
                    }
                }

                if(count == jpNumbers.size()) {
                    System.out.println("Congratulations !! The day has finally come !!");
                    System.exit(0);
                }
                System.out.println("Number of matches: " + count);
                System.out.println(line + " -->" + jpNumbers + " -->" +matchList);
                System.out.println();
            }
            scanner.close();
            System.out.println("Better luck next time !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getList(String numbers) {
        String[] numberArray = numbers.split(",");

        return Arrays.asList(numberArray);
    }
}
