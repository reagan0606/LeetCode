
/**
 * @author Li Gen
 * @date 2018-11-21 17:19
 */
public class LeetCode53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    /**
     * 动态规划 先求和,再判断和是否小于0，如果小于0则重新求和，并与之前的最大子序和对比，求最大值。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            ans = ans < 0 ? 0 : ans;
            ans += nums[i];
            max = Math.max(max, ans);
        }
        return max;
    }

    /**
     * 二分法
     * @param nums
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        }else {
            return divide(nums, 0, nums.length-1);
        }
    }

    private static int divide(int[] nums,int l, int r){

        if (l == r) {
            return nums[l];
        }

        int mid = (l + r)/2;
        int left = divide(nums, l , mid);
        int right = divide(nums, mid+1, r);

        int maxLeftBord = nums[mid];
        int leftBordSum = 0;
        for (int i = mid; i >= l ; i--){
            leftBordSum += nums[i];
            maxLeftBord = Math.max(leftBordSum,maxLeftBord);
        }

        int maxRightBord = nums[mid + 1];
        int rightBordSum = 0;
        for (int i = mid+1; i <= r; i++){
            rightBordSum += nums[i];
            maxRightBord = Math.max(rightBordSum, maxRightBord);
        }

        return Math.max(Math.max(left, right), (maxLeftBord + maxRightBord));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        long time = System.currentTimeMillis();
        int max = maxSubArray(nums);
        System.out.println("cost time "+ (System.currentTimeMillis() - time) + " ms. value is "+ max);
        long time1 = System.currentTimeMillis();
        int max1 = maxSubArray(nums);
        System.out.println("cost time "+ (System.currentTimeMillis() - time1) + " ms. value is "+ max1);
    }
}
