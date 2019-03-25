import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Li Gen
 * @date 2018-11-19 10:23
 */
public class LeetCode20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */

    public static void main(String[] args) {
        System.out.println(isValid("([{])}"));
    }

    /**
     * 理解栈的先进先出
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)){
                Character top = stack.empty()? null : stack.pop();
                if (!map.get(c).equals(top)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
