/**
 * Created by hanzihao on 2017/8/26.
 */
public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        else return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
}
