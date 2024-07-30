class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] boxes = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char x = board[i][j];
                if (x == '.')
                    continue;
                if (rows[i].contains(x) || cols[j].contains(x) || boxes[i / 3][j / 3].contains(x)) {
                    return false;
                }
                rows[i].add(x);
                cols[j].add(x);
                boxes[i / 3][j / 3].add(x);
            }
        }

        return true;
    }
}