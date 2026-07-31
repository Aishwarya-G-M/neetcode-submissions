class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numOfColumns = matrix[0].length;
        return searchMatrix(matrix,target,0,(matrix.length*numOfColumns-1),numOfColumns);
    }

    private boolean searchMatrix(int[][] matrix,int target,int left,int right,int numOfColumns){
        while(left<=right){
            int mid = (left+right)/2;
            int row = mid/numOfColumns;
            int col = mid%numOfColumns;
            if(matrix[row][col]==target)return true;
            if(matrix[row][col]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
