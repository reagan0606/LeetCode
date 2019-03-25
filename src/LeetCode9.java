/**
 * @author Li Gen
 * @date 2018-11-16 10:03
 */
public class LeetCode9 {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(12));
    }

    /**
     * 利用String的reverse方法
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        StringBuffer s = new StringBuffer().append(x);
        return s.toString().equals(s.reverse().toString());
    }

    /**
     * 利用取模和取余将整数反转
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return Boolean.FALSE;
        }
        Long rev = 0L;
        int y = x;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            rev = rev * 10 + pop;
        }
        if(rev > 0 && rev > Integer.MAX_VALUE){
            rev = 0L;
        }
        return rev.intValue() == y;
    }
}
