import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(String s: array){
            if (value.equals(s)) 
                return true;
        }
        return false;
    }


    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ 
    public static String[] reverse(String[] array) {
        int j = 0;
        String [] backward = new String [array.length];
        for(int x = array.length-1; x >= 0; x--){
            backward[j] = array[x];
            j++;
        }
        return backward;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array){
        return (Arrays.equals(array, reverse(array)));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean answer = false;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder brokenStringArr = new StringBuilder();
        for (String s : array){
            brokenStringArr.append(s);
        }
        String newString = brokenStringArr.toString();
        char [] toChar = newString.toCharArray();
        for(int s = 0; s < alphabet.length(); s++){
            answer = (!StringArrayUtils.contains(toChar,alphabet.charAt(s))) ? false : true;
        }
        return answer;
    }

    public static boolean contains(char[] array, char value) {
        for(char s: array){
            if (value == s) 
                return true;
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for(String occurrences : array){
            if (occurrences.equals(value)){
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int count = getNumberOfOccurrences(array, valueToRemove);
        String [] goneBabyGone = new String [array.length-count];
        int j =0;
        for (String s: array){
            if (!valueToRemove.equals(s)){
                goneBabyGone[j] = s;
                j++;
            }  
        }
        return goneBabyGone;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        int j = 0;
        int count = counterArray(array);
        String last= null;
        String [] newArray = new String [array.length - count];

        for(int x = 0; x < array.length; x++){
            if(!array[x].equals(last)){
                newArray[j] = array[x];
                last = array[x];
                j++;
            }
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int count = counterArray(array);
        String [] newArray = new String [array.length-count];
        newArray[0] = array[0];
        int j = 0;
        String previous = array[0];
        for (int x=1; x<array.length; x++){
            if((array[x].equals(previous))){
                newArray[j] += array[x];
            }
            else{
                j++;
                newArray[j] = array[x];
                previous = array[x];
            }
        }
        return newArray;
    }

    public static int counterArray(String[] array) {
        int count = 0;    
        for(int x = 0; x < array.length-1; x++){
            if (array[x].equals(array[x+1])){
                count++;
            }
        }
        return count;   
    }
}
