/**
 * @author Li Gen
 * @date 2018-11-19 16:42
 */
public class LeetCode28 {
    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */

    public static void main(String[] args) {
      String haystack = "a", needle = "a";
        System.out.println(strStr(haystack,needle));
    }

    /**
     * 使用substr方法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")){
            return 0;
        }
        int i = 0, length = haystack.length();
        while (i < length){
            for (int j = i+1; j <= length; j++) {
                if (needle.equals(haystack.substring(i,j))){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    /**
     * 使用indexOf方法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
