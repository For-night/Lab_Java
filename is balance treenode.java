class Solution {
    public boolean isBalanced(TreeNode root) {
        return lastOrder(root) != -1;
    }
    public static int lastOrder(TreeNode root){
        if(root == null) return 0;
        int left = lastOrder(root.left);
        if(left == -1) return -1;
        int right = lastOrder(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left,right) + 1 : -1;
    }
}
