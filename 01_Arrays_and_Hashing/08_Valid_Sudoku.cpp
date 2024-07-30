class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        vector<set<int>> cols(9), rows(9);
        vector<vector<set<int>>> boxes(3, vector<set<int>>(3));

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char x = board[i][j];
                if (x == '.')
                    continue;
                if (rows[i].contains(x) || cols[j].contains(x) || boxes[i / 3][j / 3].contains(x))
                    return false;
                rows[i].insert(x);
                cols[j].insert(x);
                boxes[i / 3][j / 3].insert(x);
            }
        }

        return true;
    }
};