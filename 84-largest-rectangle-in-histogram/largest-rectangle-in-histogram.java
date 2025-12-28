class Solution {
   public static  int largestRectangleArea(int [] heights){
    Stack<Integer> stack = new Stack<>();
    int max =0;

    // stack.push(0);
    for(int i=0;i <= heights.length;i++){
        int currheight = (i == heights.length) ? 0 : heights[i];
        while(!stack.isEmpty() && currheight < heights[stack.peek()]){
            max = getMax(heights,stack,max,i);
        }
        stack.push(i);
    }
    return max;
  }
  static int getMax(int [] arr,Stack<Integer> stack,int max,int i){
    int area;
    int popped = stack.pop();
    if(stack.isEmpty()){
        area = arr[popped] * i;
    }else{
        area = arr[popped] * (i - stack.peek() - 1);
    }
    return Math.max(max,area);
  }
}
