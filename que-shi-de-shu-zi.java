class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length -1, center = (left + right) / 2;

        if(nums.length == 0 || nums[0] != 0) return 0;

        while(left != center){
            if(nums[center] == center){
                left = center;
            }else{
                right = center;
            }
            center = (left + right) / 2;
        }
        if(nums[left] == left){
            if(nums[right] == right){
                return right +1;
            }else{
                return right;
            }
        }else return left;
    }
}
