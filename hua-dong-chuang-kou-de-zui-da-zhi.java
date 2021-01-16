class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || k == 0) return new int[]{};
        if(k == 1) return nums;

        int ans[] = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < k ; i++){
            max = Math.max(max,nums[i]);
        }
        ans[0] = max;
        for(int i = k ; i < nums.length ; i ++){
            if(max <= nums[i]){
                max = nums[i] ;
                ans[i - k + 1] = max;
            }else{
                if(nums[i - k] == max){
                    max = Integer.MIN_VALUE;
                    for(int j = i - k + 1 ; j <= i ; j ++){
                        max = Math.max(max,nums[j]);
                    }
                    ans[i - k + 1] = max;
                } else{
                    ans[i - k + 1] = max;
                }
            }
        }
        return ans;
    }
}
