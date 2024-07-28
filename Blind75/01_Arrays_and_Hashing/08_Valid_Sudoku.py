class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        cols = [set() for _ in range(9)]
        rows = [set() for _ in range(9)]
        boxes = [[set() for _ in range(3)] for _ in range(9)]

        for i in range(9):
            for j in range(9):
                x = board[i][j]
                if x == '.':
                    continue
                if x in rows[i] or x in cols[j] or x in boxes[i // 3][j // 3]:
                    return False

                rows[i].add(x)
                cols[j].add(x)
                boxes[i // 3][j // 3].add(x)
        
        return True