/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root,target,k,list);
        return list;
    }
    int dfs(TreeNode root,TreeNode target,int k,List<Integer> list){
        if(root == null){
            return -1;
        }
        //check target
        if(root.val == target.val){
            collect(root,k,list);
            return 0;
        }
        int left = dfs(root.left,target,k,list);
        //search left
        if(left != -1){
            if(left+1 == k){
                list.add(root.val);
            }else{
                collect(root.right,k-left-2,list);
            }
            return left+1;
        }
        //search right
        int right = dfs(root.right,target,k,list);
        if(right != -1){
            if(right+1 == k){
                list.add(root.val);
            }else{
                collect(root.left,k-right-2,list);
            }
            return right+1;
        }
        return -1;
    }
    void collect(TreeNode root,int k,List<Integer> list){
        if(root == null || k < 0){
            return ;
        }
        if(k == 0){
            list.add(root.val);
            return ;
        }
        collect(root.left,k-1,list);
        collect(root.right,k-1,list);
        
    }
}