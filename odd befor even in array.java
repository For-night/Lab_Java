class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int f = nums.length - 1 , i = 0;
        while(i<f){
            if(nums[i] % 2 == 0){
                changeIndex(i,f--,nums);
            }else{
                i++;
            }
        }
        return nums;
    }
    public static void changeIndex(int i, int j ,int[] data){
        int ache = data[i] ;
        data[i] = data[j];
        data[j] = ache;
    }
}
