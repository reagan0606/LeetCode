/**
 * @author Li Gen
 * @date 2018-11-19 17:11
 */
public class LeetCode35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     */
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums,target));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i =  0; i < length; i++) {
            if (target <= nums[i]){
                return i;
            }
            if (target > nums[i]){
                if (i == length-1){
                    return i+1;
                }
                if (target < nums[i+1]){
                    return  i+1;
                }
            }
        }

        return 0;
    }

    public static int searchInsert1(int[] nums, int target) {
        int length = nums.length;
        for (int i =  0; i < length; i++) {
            if (target <= nums[i]){
                return i;
            }
        }
        return length;
    }
}
