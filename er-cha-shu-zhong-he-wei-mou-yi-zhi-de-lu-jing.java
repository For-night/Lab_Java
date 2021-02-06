class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        List<Integer> listCache = new ArrayList<Integer>();
        bianli(root,listCache,0,sum);
        return ans;
    }

    public void bianli(TreeNode root  ,List<Integer> list, int sumAche,int sum){
        if(root == null)  return;
        
        sumAche += root.val;

        List<Integer> listCache = new ArrayList<Integer>();
        List<Integer> listCache2 = new ArrayList<Integer>();
        for(int i : list){
            listCache.add(i);
            listCache2.add(i);
        }
        listCache.add(root.val);
        listCache2.add(root.val);

        //System.out.println(listCache);

        if(root.left != null) bianli(root.left , listCache, sumAche,sum);
        if(root.right != null) bianli(root.right , listCache2, sumAche,sum);
        if(root.left == null && root.right == null && sumAche == sum) ans.add(listCache);
    }
}
