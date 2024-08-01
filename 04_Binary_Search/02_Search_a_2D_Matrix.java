class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            int x = matrix[i][j];
            if (x == target)
                return true;
            else if (x < target)
                i++;
            else if (x > target)
                j--;
            else
                return false;
        }

        return false;
    }
}