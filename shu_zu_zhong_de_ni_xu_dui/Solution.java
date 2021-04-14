package shu_zu_zhong_de_ni_xu_dui;


import java.util.ArrayList;

public class Solution {
    // res is bigger with index
    ArrayList<Integer> res;

    public int reversePairs(int[] nums) {
        res = new ArrayList<>();

        if(nums.length< 2){
            return 0;
        }
        res.add(nums[0]);
        int p = 1;
        int ans = 0;
        while(p < nums.length){
            int position =  sortRes(nums[p]);
//            System.out.println(res);
//            System.out.println(position);
            ans += res.size() - position - 1;
            p++;
        }
        return ans;
    }

    public int sortRes(int x){

        if(x<res.get(0)){
            res.add(0,x);
            return 0;
        }
        if(x>=res.get(res.size() - 1)){
            res.add(x);
            return res.size() - 1;
        }

        int left = 0;
        int right = res.size() - 1;
        int ptr = (left + right) / 2;

        if(right == 0){
            if(x < res.get(0)){
                res.add(0,x);
                return 0;
            }else{
                res.add(x);
                return 1;
            }
        }

        while(left != ptr){
            if(x < res.get(ptr)){
                right = ptr;
                ptr = (left + right) / 2;
            }else {
                left = ptr;
                ptr = (left + right) / 2;
            }
        }
        if(x < res.get(left)){
            res.add(left,x);
            return left;
        }else{
            res.add(right,x);
            return right;
        }

    }

    public static void main(String [] args) {
        String str = "shu-zu-zhong-de-ni-xu-dui";
        System.out.println(str.replace('-', '_'));
        Solution s = new Solution();
        System.out.println(s.reversePairs(new int[]{1,3,2,3,1}));
    }
}
