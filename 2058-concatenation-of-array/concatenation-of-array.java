class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int m = 2*n;
        int[] ans = new int[2*n];
        for(int i=0;i<=n-1;i++){
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        
        }
        return ans;
    }
}