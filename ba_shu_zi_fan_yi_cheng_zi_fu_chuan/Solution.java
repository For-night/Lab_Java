package ba_shu_zi_fan_yi_cheng_zi_fu_chuan;

public class Solution {
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
            if(((reLast - '0') * 10 + curLast - '0') > 25){
            	System.out.println("debug no "+ ((reLast - '0') * 10 + curLast - '0'));
                return new int[]{ans[0],ans[0],curLast};
            }else{
            	System.out.println("debug yes "+ ((reLast - '0') * 10 + curLast - '0'));
                return new int[]{ans[0] + ans[1],ans[0],curLast};
            }
        }
    }
	public static void main(String [] args) {
//		String s = String.valueOf(255);
//		System.out.println(s + " " + s.length());
//		int [] i = {1,2};
//		System.out.println(i[1]);
//		String str = "abc";
//		System.out.println(str.charAt(1));
//		
//		char c = 'a';
//		int x = c;
//		System.out.println(x);
//		int [] ans = f();
//		System.out.println("new "+ans[1]);
		
		Solution s = new Solution();
		System.out.println("main "+s.translateNum(624));
	}
//	public static int [] f() {
//		return new int[] {1,2};
//	}
}
