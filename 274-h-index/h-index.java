class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length <= 0){
            return 0;
        }
        int n = citations.length;
        int[] countarr = new int[n + 1];
        
        for(int num:citations){
            if(num >= n){
                countarr[n]++;
            }else{
                countarr[num]++;
            }
        }
        int papers = 0;
        for(int i = n;i>= 0;i--){
            papers += countarr[i];
            if(papers >= i){
                return i;
            }
        }
        return 0;
    }
    
}