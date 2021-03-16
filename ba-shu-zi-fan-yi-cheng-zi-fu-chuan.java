class Solution {
    public int translateNum(int num) {
        int [] ans = f(String.valueOf(num));
        return ans[0];
    }
    public static int [] f(String s){
        if(s.length() == 1){
            int last = s.charAt(0);
            int [] ans = {1,1,last}; // 总数，单独结尾的数量，单独结尾的字符
            return ans;
        }else{
            //记录最后一个字符
            int curLast = s.charAt(s.length() - 1);
            // 删除最后一个字符
            s = s.substring(0, s.length() - 1);
            int [] ans = f(s);
            int reLast = ans[2];
            if(((reLast - '0') * 10 + curLast - '0') > 25
             || ((reLast - '0') * 10 + curLast - '0') < 10){// 取值在10~25之间才有效
                return new int[]{ans[0],ans[0],curLast};
            }else{
                return new int[]{ans[0] + ans[1],ans[0],curLast};
            }
        }
    }
}
