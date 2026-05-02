class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // check rows
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < m; j++) {
                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // check columns
        for (int i = 0; i < m; i++) {
            HashSet<Character> set = new HashSet<>();
            
            for (int j = 0; j < n; j++) {
                char ch = board[j][i];

                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }
        }

        // check sub-boards
        for (int square = 0; square < 9; square++) {
            Set<Character> set = new HashSet<>();
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (set.contains(board[row][col])) {
                        return false;
                    }

                    set.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
