public class SudokoSolver {

    public static void solveSudoku(char[][] board) {
        if(null == board) return;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    for(char c = '9'; c > '0'; c--) {
                        if(isValid(c, i, j, board)) {
                            board[i][j] = c;
                            if(solve(board)) {
                                return true;
                            } else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isValid(char c, int i, int j, char[][] board) {
        for(int r = 0;  r < 9; r++) {
            if(board[r][j] != '.' && board[r][j] == c) return false;
            if(board[i][r] != '.' && board[i][r] == c) return false;
            if(board[i/3*3 + r/3][j/3*3 + r%3] != '.' &&
                    board[i/3*3 + r/3][j/3*3 + r%3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        char c = '.';
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = c;
            }
        }
        board[6][0] = 2;
        board[0][1] = 4;
        board[1][5] = 6;
        board[1][7] = 8;
        board[1][1] = 2;
        board[2][4] = 5;
        board[3][8] = 9;
        solveSudoku(board);
    }
}
