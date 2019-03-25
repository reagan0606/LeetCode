/**
 * @author Li Gen
 * @date 2018-11-16 15:17
 */
public class LeetCode14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */

    public static void main(String[] args) {
        String[] strs = new String[]{"f","f","f"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }else if (strs.length == 1) {
            return strs[0];
        }else {
            String s = "";
            int i = 1;
            while (true){
                if ("".equals(strs[0])){
                    return "";
                }else{
                    s = strs[0].length()>i-1 ? strs[0].substring(0, i):"";
                    if ("".equals(s)){
                        return strs[0].substring(0, i - 1);
                    }
                    for (String str : strs) {
                        if (!str.startsWith(s)) {
                            return strs[0].substring(0, i - 1);
                        }
                    }
                    i++;
                }
            }
        }
    }
}
