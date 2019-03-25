import sun.security.util.Length;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Gen
 * @date 2018-11-16 10:32
 */
public class LeetCode13 {
    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 理解罗马数字构造
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        int res = 0;
        do {
            Character c1 = s.charAt(0);
            Character c2 = s.length()>1 ? s.charAt(1) : null;
            int len = 1;
            if (c2 != null && ((c1 == 'I' && (c2 == 'V' || c2 == 'X')) || (c1 == 'X' && (c2 == 'L'|| c2 == 'C')) || (c1 == 'C' && (c2 == 'D'|| c2 == 'M')))){
                len = 2;
            }

            if (len == 1){
                res += romanMap.get(c1);
            }else {
                res += romanMap.get(c2) - romanMap.get(c1);
            }
            s = s.substring(len,s.length());
        }while (s.length()>=1);
        return res;
    }
}
