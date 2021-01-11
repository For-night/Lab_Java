class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int current = (nums.length)/2 , shang = nums.length , xia = 0 ,flag= 2 + (int)((Math.log(nums.length))/(Math.log(2)));
        while(flag > 0){ 
            if(nums[current] == target){
                flag = 0;
                break;
            }else{
                if(nums[current] > target){
                    shang = current;
                }else{
                    xia = current;
                }
                current =  (shang + xia )/ 2;
                flag --;
                if(flag == 0){
                    return 0;
                }            
            }
        }
        xia = current + 1;
        shang = 0;
        while(xia < nums.length && nums[xia] == target){
            shang++;
            xia ++;
        }
        while(current >= 0 && nums[current] == target){
            shang++;
            current --;
        }
        return shang;
    }
}
