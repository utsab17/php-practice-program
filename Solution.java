import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static int startRangeNum    =    264360;
    private static int endRangeNum      =    746325;
    private static int desiredLength    =    6;

    /**
     * validates that the number is six digits long
     *
     * @param number
     * @return boolean
     */



    public static boolean validateSixDigit(int number) {
        int length = String.valueOf(number).length();
        return length == desiredLength;
    }

    /**
     * validates that there is at least once set of adjacent same number
     *
     * @param number
     * @return boolean
     */
    public static boolean validateForSameAdjacentNumbers(int number) {
        char[] charArray = String.valueOf(number).toCharArray();
        boolean adjacent = false;
        for (int i = 0; i < charArray.length-1; i++) {
            if (charArray[i] == charArray[i + 1]) {

                adjacent = true;
                break;
            }
        }
        return adjacent;
    }


    /**
     * validates that the particular number is within the provided range
     * @param number
     * @return boolean
     */
    public static boolean validateNumberIsWithinRange(int number) {
        return number > startRangeNum && number < endRangeNum;

    }

    /**
     * validates that the given number has no digits in decreasing order
     * @param number
     * @return boolean
     */
    public static boolean validateSequenceIncrement(int number) {
        boolean increasing = true;
        char[] charArray = String.valueOf(number).toCharArray();

        for (int i = 0; i < charArray.length - 1; i++) {
            if (Character.getNumericValue(charArray[i]) > Character.getNumericValue(charArray[i + 1])) {
                increasing = false;
                break;
            }
        }
        return increasing;
    }



  public static void main(String[] args) {
        Instant start = Instant.now();
        List<Integer> resultList = new ArrayList<>();
        for (int i = startRangeNum; i < endRangeNum; i++){
            if (validateForSameAdjacentNumbers(i) &&validateSixDigit(i) && validateSequenceIncrement(i) && validateNumberIsWithinRange(i)){
                resultList.add(i);
                System.out.println(i);
            }
        }
        System.out.println("There are a total number of " + resultList.size() + " possibilities");
        Instant finish = Instant.now();
        System.out.println("It took " + Duration.between(start,finish).toMillis() + "  milliseconds to run this program");
  }
}










