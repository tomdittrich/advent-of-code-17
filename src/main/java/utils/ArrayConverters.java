package utils;

/**
 * Converts arrays into each other
 *
 * @author Tom Dittrich s0555944@htw-berlin.de
 * @version 0.1
 */
public class ArrayConverters {

    /**
     * Converts an string array into an int array
     *
     * @param input string array
     * @return int array
     */
    public static int[] convertStringToInt(String[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}
