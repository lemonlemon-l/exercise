package easy;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 *
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * Related Topics 数学 二分查找
 * 👍 745 👎 0
 */

public class L69_x的平方根 {
    public static void main(String[] args) {
        int res = new L69_x的平方根().mySqrt3(8); //期望3
        System.out.println(res);
    }

    /**
     * 直接调用.
     */
    public int mySqrt2(int x) {
        return (int) Math.sqrt((double) x);
    }

    /**
     * 二分法.
     */
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int res = -1;

        while (low <= high) {
            int med = (low + high) / 2;
            if ((long) med * med <= x) {
                low = med + 1;
                res = med;
            } else {
                high = med - 1;
            }
        }

        return res;
    }

    /**
     * 二分近似法.
     */
    public int mySqrt3(int x) {
        int low = 0;
        int high = x;

        while (low <= high) {
            int med = (low + high) / 2;
            long med2 = (long)med * med;
            if ((long)med * med <= x && (long)(med+1) * (med+1) > x) {
                return med;
            } else if (med2 < x) {
                low = med + 1;
            } else {
                high = med - 1;
            }
        }

        return -1;
    }
}
