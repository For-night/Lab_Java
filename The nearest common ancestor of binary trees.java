/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //遇到问题永远都是先分析问题！
 //回溯中会丢弃很多个节点，因为潜在叶节点很多，而我们只要目标的两个或者一个节点
// *****这个是后序遍历！ 吗？******//

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left != null && right != null) return root;
        if(left == null && right == null) return right;
        return left == null ? right : left;
    }
}


// ***非递归版本先序遍历*** //
public static void preOrder(TreeNode biTree){
 //非递归实现
	Stack<TreeNode> stack = new Stack<TreeNode>();
	while(biTree != null || !stack.isEmpty())	{
  
		while(biTree != null)		{
			System.out.println(biTree.value);
			stack.push(biTree);
				biTree = biTree.left;
		}
		if(!stack.isEmpty())		{
			biTree = stack.pop();
			biTree = biTree.right;
		}
  
	}
}
