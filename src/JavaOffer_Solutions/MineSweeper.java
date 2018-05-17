//package JavaOffer_Solutions;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class MineSweeper {
//    //DFS
//    public char[][] updateBoard(char[][] board, int[] click) {
//        int x = click[0], y = click[1];
//        if (board[x][y] == 'M') {
//            board[x][y] = 'X';
//            return board;
//        }
//
//        dfs(board, x, y);
//        return board;
//    }
//
//    int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
//    int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};
//    private void dfs(char[][] board, int x, int y) {
//        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E')  return;
//
//        int num = getNumsOfBombs(board, x, y);
//
//        if (num == 0) {
//            board[x][y] = 'B';
//            for (int i = 0; i < 8; i++) {
//                int nx = x + dx[i], ny = y + dy[i];
//                dfs(board, nx, ny);
//            }
//        } else {
//            board[x][y] = (char)('0' + num);
//        }
//
//    }
//
//    private int getNumsOfBombs(char[][] board, int x, int y) {
//        int num = 0;
//        for (int i = -1; i <= 1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                int nx = x + i, ny = y + j;
//                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)    continue;
//                if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
//                    num++;
//                }
//            }
//        }
//        return num;
//    }
//}
//
////BFS
//
//    public char[][] updateBoard2(char[][] board, int[] click) {
//        int m = board.length, n = board[0].length;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(click);
//
//        while (!queue.isEmpty()) {
//            int[] cell = queue.poll();
//            int row = cell[0], col = cell[1];
//
//            if (board[row][col] == 'M') { // Mine
//                board[row][col] = 'X';
//            }
//            else { // Empty
//                // Get number of mines first.
//                int count = 0;
//                for (int i = -1; i < 2; i++) {
//                    for (int j = -1; j < 2; j++) {
//                        if (i == 0 && j == 0) continue;
//                        int r = row + i, c = col + j;
//                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
//                        if (board[r][c] == 'M' || board[r][c] == 'X') count++;
//                    }
//                }
//
//                if (count > 0) { // If it is not a 'B', stop further BFS.
//                    board[row][col] = (char)(count + '0');
//                }
//                else { // Continue BFS to adjacent cells.
//                    board[row][col] = 'B';
//                    for (int i = -1; i < 2; i++) {
//                        for (int j = -1; j < 2; j++) {
//                            if (i == 0 && j == 0) continue;
//                            int r = row + i, c = col + j;
//                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
//                            if (board[r][c] == 'E') {
//                                queue.add(new int[] {r, c});
//                                board[r][c] = 'B'; // Avoid to be added again.
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return board;
//    }
//
//}
