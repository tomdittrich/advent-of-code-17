package day01;

import java.util.List;

/**
 * Advent of code 2017 - Day01 - Task02
 * http://adventofcode.com/2017/day/1
 *
 * @author Tom Dittrich s0555944@htw-berlin.de
 * @version 0.8
 */
public class Task02 extends Task01 {
    public static void main(String[] args) {
        Task02 task02 = new Task02();

        System.out.println(task02.calculateCaptcha(task02.getNumbers(args)));
    }

    @Override
    int calculateCaptcha(List<Integer> list) {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            int next = (i + (list.size() / 2)) % list.size();

            if (list.get(i) == list.get(next)) {
                result += list.get(i);
            }
        }

        return result;
    }
}
