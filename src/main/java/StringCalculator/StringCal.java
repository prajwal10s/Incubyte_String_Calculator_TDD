package StringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCal {
    public static int add(String numbers){
        if(numbers.isEmpty())return 0;
        int ans = customSplitAndCal(numbers);
        return ans;
    }
    //below function is added to support custom delimiter apart from comma and newline
    private static int customSplitAndCal(String numbers) {
        if(numbers.isEmpty())return 0;
        else if(hasCustomDelimiter(numbers)){
            String[] delimNum = CustomDelim(numbers);
            String[] newNums = splitCustomDelimiter(delimNum);
            int size = newNums.length;
            if(isAsterisk(delimNum[0])){
                return calMultiply(newNums,size);
            }
            else{
                return calSum(newNums,size);
            }
        }
        else  {
            String[] newNums = splitCommaOrNewline(numbers);
            int size = newNums.length;
            return calSum(newNums,size);
        }
    }
    //below method is to check for custom delimiter
    private static boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private static String[] CustomDelim(String numbers){
        Matcher matcher = Pattern.compile("//(\\[.*?]|.)\\n(.*)").matcher(numbers);
        if (matcher.matches()) {
            String delim = matcher.group(1);
            String newNumbers = matcher.group(2);
            String[] delimNum = new String[2];
            delimNum[0] = delim;
            delimNum[1] = newNumbers;
            return delimNum;
        }
        else{
            throw new IllegalArgumentException("Invalid input format");
        }
    }
    private static String[] splitCustomDelimiter(String[] delimNum) {
        //Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            String delim = delimNum[0];
            String newNumbers = delimNum[1];
            if (delim.startsWith("[") && delim.endsWith("]")) {
                delim = delim.substring(1, delim.length() - 1);
            }
        return newNumbers.split(Pattern.quote(delim));
    }
    private static boolean isAsterisk(String delim){
        if(delim.length()==1 && delim.charAt(0)=='*')return true;
        return false;
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
        if(!negatives.isEmpty())throw new RuntimeException("Negative values are not allowed "+negative);
        return sum;
    }
    private static int calMultiply(String[] nums, int size){
        int prod = 1;
        if(size==0)return 0;
        List<String> negatives = new ArrayList<>();
        for(int i=0;i<size;i++){
            int curr = Integer.parseInt(nums[i]);
            if(curr<0)negatives.add(nums[i]);
            if(curr<1000 && curr>=0)prod*= curr;
        }
        String negative = String.join(", ",negatives);
        if(!negatives.isEmpty())throw new RuntimeException("Negative values are not allowed "+negative);
        return prod;
    }
}



