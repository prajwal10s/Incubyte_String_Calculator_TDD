package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCal {
    public static int add(String numbers){
        if(numbers.isEmpty())return 0;
        String[] nums = customSplit(numbers);
        int size = nums.length;
        return calSum(nums, size);
    }
    //below function is added to support custom delimiter apart from comma and newline
    private static String[] customSplit(String numbers) {
        if(numbers.isEmpty())return new String[0];
        else if(hasCustomDelimiter(numbers)){
            return splitCustomDelimiter(numbers);
        }
        else return splitCommaOrNewline(numbers);
    }

    private static String[] splitCustomDelimiter(String numbers) {
        //Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        Matcher matcher = Pattern.compile("//(\\[.*?\\]|.)\\n(.*)").matcher(numbers);
        if (matcher.matches()) {
            String delim = matcher.group(1);
            String newNumbers = matcher.group(2);
            // Remove the square brackets from the delimiter if present
            if (delim.startsWith("[") && delim.endsWith("]")) {
                delim = delim.substring(1, delim.length() - 1);
            }
            return newNumbers.split(Pattern.quote(delim));
        } else {
            throw new IllegalArgumentException("Invalid input format");
        }
    }
    //below method is to check for custom delimiter
    private static boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private static String[] splitCommaOrNewline(String numbers) {
        return numbers.split("[\n" +
                ",]");
    }
    private static int calSum(String[] nums, int size){
        int sum = 0;
        if(size==0)return 0;
        List<String> negatives = new ArrayList<>();
        for(int i=0;i<size;i++){
            int curr = Integer.parseInt(nums[i]);
            if(curr<0)negatives.add(nums[i]);
            if(curr<1000 && curr>=0)sum+= curr;
        }

        String negative = String.join(", ",negatives);
        if(negatives.size()>0)throw new RuntimeException("Negative values are not allowed "+negative);
        return sum;
    }
}
