class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int numsOfzero = 0;
        for(int i = 0 ; i < 5 ;i ++){
            if(nums[i] < 1){
                numsOfzero ++;
            }else{
                break;
            }
        }

        if(numsOfzero > 3) return true; //the num of zero is  4 or 5 can ans true

        int costZero = 0;
        for(int i = 4;i > numsOfzero ; i --){
            if(nums[i] == nums[i - 1]) return false;
            costZero += nums[i] - nums[i - 1] - 1;
            if(costZero > numsOfzero) return false;
        }
        return true;
    }
}
