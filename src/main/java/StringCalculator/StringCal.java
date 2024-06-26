package StringCalculator;

public class StringCal {
    public static int add(String numbers){
        if(numbers.isEmpty())return 0;
        String[] nums = numbers.split(",");
        int size = nums.length;
        return calSum(nums, size);
    }
    public static int calSum(String[] nums, int size){
        int sum = 0;
        if(size==0)return 0;
        for(int i=0;i<size;i++){
            sum+= Integer.parseInt(nums[i]);
        }
        return sum;
    }
}
