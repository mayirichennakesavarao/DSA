/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> currentlevel = new ArrayList<>(level);
            for(int i=0;i<level;i++){
                TreeNode currentnode = queue.poll();
                currentlevel.add(currentnode.val);
                if(currentnode.left != null){
                    queue.offer(currentnode.left);
                }
                if(currentnode.right != null){
                    queue.offer(currentnode.right);
                }
            }
            result.add(0,currentlevel);
        }
        return result;
    }
}