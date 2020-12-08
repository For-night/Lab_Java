class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        List<List<Integer> ListRoot = new ArrayList<List<Integer>();
        TreeNode currentNode;
        int levelNum = 1;

        queue.add(root);

        while(!queue.isEmpty()){

            levelNum = queue.size();
            List<Integer> ListCur = new ArrayList<Integer>();
            for(int i = 0; i < levelNum ; i ++){
                
                currentNode = queue.poll();
                ListCur.add(currentNode.val);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            ListRoot.add(ListCur);
        }
        return ListRoot;

    }
}
