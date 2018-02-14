package day01;

import java.util.ArrayList;
import java.util.List;

/**
 * Advent of code 2017 - Day01 - Task01
 * http://adventofcode.com/2017/day/1
 *
 * @author Tom Dittrich s0555944@htw-berlin.de
 * @version 0.8
 */
public class Task01 {
    public static void main(String[] args) {
        Task01 task01 = new Task01();

        System.out.println(task01.calculateCaptcha(task01.getNumbers(args)));
    }

    List<Integer> getNumbers(String[] args) {
        List<Integer> result = new ArrayList<>();

        if (args.length == 0) {
            System.out.println("No arguments given");
            result.add(0);
            return result;
        }

        // convert the long-string-argument-input into single characters
        String tempResultWhole = args[0];
        char[] tempResultInArray = tempResultWhole.toCharArray();

        // convert into integer array
        for(Character number : tempResultInArray){
            result.add(Character.getNumericValue(number));
        }

        return result;
    }

    int calculateCaptcha(List<Integer> list) {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            int next = (i + 1) % list.size();

            if (list.get(i) == list.get(next)) {
                result += list.get(i);
            }
        }

        return result;
    }
}
