import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Li Gen
 * @date 2018-11-15 14:53
 */
public class LeetCode1 {
    /**
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] twoSum = twoSum2(nums,9);
        IntStream.of(twoSum).forEach(System.out::println);
    }

    /**
     * 暴力循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *  两遍哈希
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i){
                return new int[]{i,map.get(result)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)){
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
