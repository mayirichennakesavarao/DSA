class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
     boolean solve(char [][] board){
        int n = board.length;
        int row= -1;
        int col= -1;
        boolean emptyLeft=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '.'){
                    row=i;
                    col=j;
                    emptyLeft=false;
                    break;
                    
                }
            }
            //if found some empty element in row,then break
            if(emptyLeft == false){
                break;
            }
        }
        if(emptyLeft == true){
            return true;
        }
        //backtrack
        for(char number='1';number<='9';number++){
            if(issafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

 boolean issafe(char [][] board,int row,int col,int num){
        //check the row
        for(int i=0;i<board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }
        //check the col
        for(char[] nums:board){
            //check the if num is col
            if(nums[col] == num){
                return false;
            }
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int rowstart=row-row % sqrt;
        int colstart=col-col % sqrt;
        for(int r=rowstart;r<rowstart + sqrt;r++){
            for(int c=colstart;c<colstart + sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
