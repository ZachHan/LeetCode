/**
 * Created by hanzihao on 2017/7/15.
 */
public class Solution {
    /**
    public static int reverse(int x) {
        int b = x / 10;
        int temp = x % 10;
        if (x < 10 && x >= 0) return x;
        if (x < 0 && x > -10) return x;
        while (b != 0) {
            temp = temp * 10 + b % 10 ;
            b = b / 10;
        }
        return temp;
    }
    */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String args[]) {
        int x = 123456789;
        System.out.println(reverse(x));
    }
}
