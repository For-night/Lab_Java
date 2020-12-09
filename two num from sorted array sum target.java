class Solution {
    public int[] twoSum(int[] nums, int target) {
        int fast =nums.length - 1 , slow = 0;

        while(fast > slow){
            if(nums[slow] + nums[fast] == target){
                return new int[]{nums[slow] , nums[fast]};
            }else if(nums[slow] + nums[fast] < target){
                slow++;
            }else{
                fast--;
            }
        }
        return new int[]{0 , 0};
    }
}
