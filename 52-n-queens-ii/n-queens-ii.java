class Solution {
    public int totalNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        return queens(board,0);
    }
    int queens(boolean[][] board,int row){
        if(row == board.length){
            return 1;
        }
        int count=0;
        for(int col = 0; col < board.length;col++){
            if(issafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }
    boolean issafe(boolean [][] board,int row,int col){
        //check vertical
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //check left
        int minLeft=Math.min(row,col);
            for(int i=1;i <= minLeft;i++){
                if(board[row-i][col-i]){
                    return false;
                }
            }
        
        int minRight=Math.min(row,board.length-col-1);
            for(int i=1;i<=minRight;i++){
                if(board[row-i][col+i]){
                    return false;
                }
            }
            return true;
        }
    

}