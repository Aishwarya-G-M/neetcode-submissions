class Solution {
    public boolean isValidSudoku(char[][] board) {
        // verify every 3*3 grid is valid
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                Set<Character> set = new HashSet<>();
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        char ch = board[k][l];
                        if(ch!='.' && !set.add(ch)){
                            return false;
                        }
                        // verify the row column correspoding to position <k,l> is valid
                        if(!isValidRowCol(board,k,l))return false;
                    }
                }
                j=j+2;
            }
            i=i+2;
        }
        return true;
    }

    private boolean isValidRowCol(char[][] board,int row,int col){
        Set<Character> set = new HashSet<>();
        // check validity of row
        for(int i=0;i<9;i++){
            if(board[i][col]!='.' && !set.add(board[i][col]))return false;
        }
        //reset the set;
        set.clear();
        for(int i=0;i<9;i++){
            if(board[row][i]!='.' && !set.add(board[row][i]))return false;
        }
        return true;
    }
}
