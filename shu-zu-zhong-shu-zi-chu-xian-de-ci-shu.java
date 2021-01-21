class Solution {
    public int[] singleNumbers(int[] nums) {
        int yi_huo = 0;
        for(int i:nums){
            yi_huo = yi_huo ^ i;
        }
        int checker = 1;
        while(true){
            if((checker & yi_huo) == 0){
                checker = checker << 1;
            }else{
                break;
            } 
        }
        int ans[] = new int[2];
        for(int i:nums){
            if((i & checker) == 0){
                ans[0] ^= i;
            }else{
                ans[1] ^= i;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int[] singleNumbers(int[] nums) {
//         HashSet<Integer> hs = new HashSet<Integer>();
//         for(int i:nums){
//             if(hs.contains(i)){
//                 hs.remove(i);
//             }else{
//                 hs.add(i);
//             }
//         }
//         int []ans = new int[hs.size()];
//         int j = 0;
//         for(int i:hs){
//             ans[j++] = i;
//         }
//         return ans;
//     }
// }
