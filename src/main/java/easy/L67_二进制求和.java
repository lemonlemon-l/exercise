package easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  示例 1:
 *  输入: a = "11", b = "1"
 * 输出: "100" 
 * 
 *  示例 2:
 *  输入: a = "1010", b = "1011"
 * 输出: "10101" 
 *
 *  提示： 
 *
 *  每个字符串仅由字符 '0' 或 '1' 组成。 
 *  1 <= a.length, b.length <= 10^4 
 *  字符串如果不是 "0" ，就都不含前导零。 
 *  
 *  Related Topics 位运算 数学 字符串 模拟 
 *  👍 652 👎 0
 */
public class L67_二进制求和 {
    public static void main(String[] args) {
        String res = new L67_二进制求和().addBinary("1","111");
        System.out.println(res);
    }
    public String addBinary(String a, String b) {
        if (b == null || b.length() == 0){
            return a;
        }

        int len1 = a.length();
        int len2 = b.length();
        if (len1 < len2) { // 保持len1为较大的值.
            return addBinary(b, a);
        }
        int flag = 0; // 进位
        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();

        for (int i = 0; i < len1; i++){
            int index1 = len1 - i - 1;
            int index2 = len2 - i - 1;
            char numA = '0';
            char numB = '0';
            if (index1 < len1 && index1 >= 0){
                numA = ar[index1];
            }
            if (index2 < len2 && index2 >= 0){
                numB = br[index2];
            }

            ar[index1] = (char)((numA - '0' + numB - '0' + flag)%2 + '0');
            flag = (numA - '0' + numB - '0' + flag)/2;
        }

        // 有进位
        if (flag!=0){
            char[] res = new char[len1 + 1];
            res[0] = '1';
            for (int i = 1; i < res.length; i++) {
                res[i] = ar[i-1];
            }
            return new String(res);
        }
        return new String(ar);
    }
}
