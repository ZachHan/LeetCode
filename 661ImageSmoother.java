/**
 * Created by hanzihao on 2017/8/25.
 */
public class Solution2 {
    public static int[][] imageSmoother(int[][] M) {
        int[][] ans = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int sum = 0;
                int count = 0;
                if (i > 0 && j > 0) {
                    count++;
                    sum += M[i - 1][j - 1];
                }
                if (i > 0) {
                    count++;
                    sum += M[i - 1][j];
                }
                if (i > 0 && j < M[0].length - 1) {
                    count++;
                    sum += M[i - 1][j + 1];
                }
                if (j > 0) {
                    count++;
                    sum += M[i][j - 1];
                }
                if (j < M[0].length - 1) {
                    count++;
                    sum += M[i][j + 1];
                }

                if (i < M.length - 1 && j > 0) {
                    count++;
                    sum += M[i + 1][j - 1];
                }
                if (i < M.length - 1) {
                    count++;
                    sum += M[i + 1][j];
                }
                if (i < M.length - 1 && j < M[0].length - 1) {
                    count++;
                    sum += M[i + 1][j + 1];
                }
                count++;
                sum += M[i][j];
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        int[][] ans = {{1,2,3}, {4,5,6}};
        int[][] temp = imageSmoother(ans);
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                System.out.print(temp[i][j] + " ");


    }
}
