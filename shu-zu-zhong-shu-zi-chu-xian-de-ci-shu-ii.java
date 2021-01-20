class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i ++){
            
            if(hm.containsKey(nums[i])){
                if(set.contains(nums[i])) set.remove(nums[i]);
                hm.put(nums[i],1 + hm.get(nums[i]));
            }else{
                set.add(nums[i]);
                hm.put(nums[i],1);
            }
        }
        for(int i : set){
            return i;
        }
        return -1;
    }
}
