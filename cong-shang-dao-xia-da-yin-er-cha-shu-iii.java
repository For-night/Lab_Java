class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> acheList = new LinkedList<>();
        boolean l2r  = true;

        queue.add(root);
        int hangSize ;//  按行打印的关键！每次都要清理一遍队列，装满新的行
        while(!queue.isEmpty()){
            hangSize = queue.size();
            for(int i = 0 ; i < hangSize ; i ++){
                TreeNode t = queue.poll();
                acheList.add(t.val);
                if(t.left != null){
                    queue.add(t.left);
                }
                if(t.right != null){
                    queue.add(t.right);
                }
            }
            ans.add(acheList);
            acheList = new LinkedList<>();
        }
        
        for(List l : ans){
            if(!l2r){
                Collections.reverse(l);
                System.out.println(l);
            }
            l2r = !l2r;
        }

        return ans;
    }
}
