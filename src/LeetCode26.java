import java.util.Arrays;
import java.util.Stack;

/**
 * @author Li Gen
 * @date 2018-11-19 15:29
 */
public class LeetCode26 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        long time = System.currentTimeMillis();
        System.out.println(removeDuplicates1(nums));
        System.out.println(System.currentTimeMillis()-time);
        System.out.println(removeDuplicates(nums));
        System.out.println(System.currentTimeMillis()-time);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        return Arrays.stream(nums).distinct().toArray().length;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {return 0;}
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
