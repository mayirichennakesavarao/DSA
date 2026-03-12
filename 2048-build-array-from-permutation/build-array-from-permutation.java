class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        for(int i=0;i<=nums.length-1;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}