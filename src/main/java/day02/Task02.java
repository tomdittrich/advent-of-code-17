package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Advent of code 2017 - Day02 - Task02
 * http://adventofcode.com/2017/day/2
 *
 * @author Tom Dittrich s0555944@htw-berlin.de
 * @version 0.8
 */
public class Task02 {
    public static void main(String[] args) {
        final String FILEPATH = "src/main/java/day02/input.txt";

        List<String> input = new ArrayList<>();
        int checksum = 0;

        input = getInputFile(FILEPATH);
        checksum = calculateTotalDivision(input);

        System.out.println(checksum);

    }

    private static List<String> getInputFile(String filepath) {
        List<String> input = new ArrayList<>();
        try {
            // reads out every whole line as a separate string
            input = Files.readAllLines(Paths.get(filepath));
        } catch (IOException e) {
            System.out.println("Problem during file reading (wrong filename?)...");
            return input;
        }
        return input;
    }

    private static int calculateTotalDivision(List<String> input) {
        int result = 0;

        for (String line : input) {
            String[] numbers = line.split("\t");

            result += calculateLineDivision(numbers);
        }

        return result;
    }

    private static int calculateLineDivision(String[] lineOfNumbers) {
        int result = 0;

        int[] numbersToCheck = convertStringToInt(lineOfNumbers);

        for (int number : numbersToCheck) {
            for (int compareNumber : numbersToCheck) {
                if ((number % compareNumber == 0) && (number / compareNumber != 1)) {
                    result = number / compareNumber;
                }
            }
        }

        return result;
    }

    private static int[] convertStringToInt(String[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}
