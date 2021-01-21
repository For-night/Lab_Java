class Solution {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i:nums){
            if(hs.contains(i)){
                hs.remove(i);
            }else{
                hs.add(i);
            }
        }
        int []ans = new int[hs.size()];
        int j = 0;
        for(int i:hs){
            ans[j++] = i;
        }
        return ans;
    }
}
