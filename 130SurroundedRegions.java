/**
 * Created by hanzihao on 2017/8/25.
 */
import java.util.Queue;
import java.util.LinkedList;

public class Solution1 {
    private static Queue<Integer> queue = null;
    private static int rows = 0;
    private static int cols = 0;

    public void surroundedRegions(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0, board);
            enqueue(i, cols - 1, board);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j, board);
            enqueue(rows - 1, j, board);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                    y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y, board);
            enqueue(x + 1, y, board);
            enqueue(x, y - 1, board);
            enqueue(x, y + 1, board);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public void enqueue(int x, int y, char[][] board) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){
            queue.offer(x * cols + y);
        }
    }
}

