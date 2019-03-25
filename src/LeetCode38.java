/**
 * @author Li Gen
 * @date 2018-11-20 10:04
 */
public class LeetCode38 {
    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     */

    public static void main(String[] args) {
        for (int i = 1; i < 31; i++) {
            System.out.println(countAndSay1(i));
        }
    }

    public static String countAndSay(int n) {
        String result = "1";
        while (--n>0){
            int count = 1;

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < result.length(); i++){
                if (result.charAt(i) == result.charAt(i-1)){
                    count++;
                }else {
                    sb.append(count).append(result.charAt(i-1));
                    count = 1;
                }
            }
            result = sb.append(count).append(result.charAt(result.length()-1)).toString();
        }
        return result;
    }

    public static String countAndSay1(int n) {
        String result = "1";
        for (int i = 1 ; i <= n;i++){
            int count = 1;

            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < result.length(); j++){
                if (result.charAt(j) == result.charAt(j-1)){
                    count++;
                }else {
                    sb.append(count).append(result.charAt(j-1));
                    count = 1;
                }
            }
            result = sb.append(count).append(result.charAt(result.length()-1)).toString();
        }
        return result;
    }
}
