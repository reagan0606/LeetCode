/**
 * @author Li Gen
 * @date 2018-11-16 09:06
 */
public class LeetCode7 {
    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
     */


    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    /**
     * 利用String的reverse方法
     * @param x
     * @return
     */
    public static int reverse(int x) {
        Boolean flag = x > 0;
        Long y = flag ? Long.valueOf(x) : -Long.valueOf(x);
        StringBuffer s = new StringBuffer();
        s.append(y);
        Long l = Long.parseLong(s.reverse().toString());
        l = flag ? l : -l;
        if (!flag && l < Integer.MIN_VALUE){
            return 0;
        }

        if((flag && l > Integer.MAX_VALUE)){
            return  0;
        }
        return l.intValue();
    }

    /**
     * 取模和取余的应用
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        Long rev = 0L;
        while (x != 0){
            int pop = x % 10;
            x = x / 10;
            rev = rev * 10 + pop;
        }
        if (rev < 0 && rev < Integer.MIN_VALUE){
            rev = 0L;
        }
        if(rev > 0 && rev > Integer.MAX_VALUE){
            rev = 0L;
        }
        return  rev.intValue();
    }
}
