class Solution {
    public TreeNode v(TreeNode root, TreeNode p, TreeNode q) {
        
        if( p.val <= root.val && root.val <= q.val){
            return root;
        }

        if(root.val < p.val){
            return lowestCommonAncestor(root.left , p , q);
        }

        if(root.val > q.val){
            return lowestCommonAncestor(root.right , p , q);
        }
    }
}
