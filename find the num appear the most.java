class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length < 1){
            return nums[0];
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int ache = map.get(nums[i]) + 1;
                if(ache > nums.length/2){
                    return nums[i];
                }else{
                    map.put(nums[i] , ache);
                }
            }else{
                map.put(nums[i],1);
            }
        }
        
        return nums[0];
    }
}
