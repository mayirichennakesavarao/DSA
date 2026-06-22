class Solution {
    public int maxProfit(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int maxprofit=0;
        int minprice=nums[0];
        for(int i=0;i<nums.length;i++){
           if(nums[i] < minprice){
            minprice = nums[i];
           }else{
            int currentprofit= nums[i] - minprice;
            maxprofit=Math.max(maxprofit,currentprofit);
           }
        }
        return maxprofit;
    }
}