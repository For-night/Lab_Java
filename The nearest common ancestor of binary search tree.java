class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val){
            return f(root,p,q);
        }else{
            return f(root,q,p);
        }

    }

    public static TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(p == q){
            return q;
        }

        if( p.val <= root.val && root.val <= q.val){
            return root;
        } 

        if(root.val < p.val){
            return f(root.right , p , q);
        }else{
            return f(root.left , p , q);
        }
    }
}
