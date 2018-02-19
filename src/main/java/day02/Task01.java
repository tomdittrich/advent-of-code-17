package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Advent of code 2017 - Day02 - Task01
 * http://adventofcode.com/2017/day/2
 *
 * @author Tom Dittrich s0555944@htw-berlin.de
 * @version 0.8
 */
public class Task01 {
    public static void main(String[] args) {
        final String FILEPATH = "src/main/java/day02/input.txt";

        List<String> input = new ArrayList<>();
        int checksum = 0;

        input = getInputFile(FILEPATH);
        checksum = calculateTotalChecksum(input);

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

    private static int calculateTotalChecksum(List<String> input) {
        int result = 0;

        for (String line : input) {
            String[] numbers = line.split("\t");

            result += calculateLineChecksum(numbers);
        }

        return result;
    }

    private static int calculateLineChecksum(String[] lineOfNumbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String number : lineOfNumbers) {
            int numberToCalculate = Integer.parseInt(number);

            if (numberToCalculate > max) {
                max = numberToCalculate;
            }

            if (numberToCalculate < min) {
                min = numberToCalculate;
            }
        }

        // difference
        return max - min;
    }
}
