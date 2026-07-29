class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int row=0;row<9;row=row+3){
            for(int col=0;col<9;col=col+3){
                if(!checkBoxes(board,set,row,col))return false;
                set.clear();
            }
        }

        for(int i=0;i<9;i++){
            if(!checkRows(board,set,i))return false;
        }

        for(int i=0;i<9;i++){
            if(!checkColumns(board,set,i))return false;
        }
        return true;
    }


    private boolean checkRows(char[][] board,Set<Character> set,int row){
        for(int i=0;i<9;i++){
            char ch = board[row][i];
            if(ch!='.' && !set.add(ch)){
                return false;
            }
        }
        set.clear();
        return true;
    }

    private boolean checkColumns(char[][] board,Set<Character> set,int col){
        for(int i=0;i<9;i++){
            char ch = board[i][col];
            if(ch!='.' && !set.add(ch)){
                return false;
            }
        }
        set.clear();
        return true;
    }

    private boolean checkBoxes(char[][] board,Set<Character> grid,int row,int col){
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                char ch = board[i][j];
                if(board[i][j]!='.' && !grid.add(ch))return false;
            }
        }
        return true;
    }
}
