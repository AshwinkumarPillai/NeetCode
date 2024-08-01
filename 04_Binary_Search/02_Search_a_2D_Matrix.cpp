class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int m = matrix.size(), n = matrix[0].size();
        int i = 0, j = n - 1;

        while (i < m && j >= 0)
        {
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
};