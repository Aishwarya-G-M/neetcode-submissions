class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    if(!set.add(ch+" seen in row "+i) ||
                    !set.add(ch+" seen in col "+j) ||
                    !set.add(ch+" seen in grid with "+i/3+"th row and "+j/3+"col")){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
