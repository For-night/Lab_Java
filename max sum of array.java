class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < length){
            max = Math.max(max,f(i,nums));
            
        }
        return max;
    }
    public static int f(int i,int[] nums){

    }
}
