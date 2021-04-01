package shu_zi_xu_lie_zhong_mou_yi_wei_de_shu_zi;


class Solution {
    public int findNthDigit(int n) {
    	if(n < 10) {
    		return n;
    	}
    	
    	int x = 2;
    	int iniLen = 10;
    	while(iniLen + x * (9 * Math.pow(10,x-2)) * 10 < n) {
    		iniLen += x * (9 * Math.pow(10,x-2)) * 10;
    		//System.out.println("iniLen: " + iniLen);
    		x ++;
    	}
    	
    	int hang = (int) ((n - iniLen) / (10.0*x));
    	int lie = (int) (((n - iniLen) /x) % 10);
    	int ge = (n - iniLen) % x;
    	//System.out.println("hang : " + hang + " lie : " + lie + " ge : " + ge);
    	hang = (int) ( hang * 10 + Math.pow(10, x - 1));
    	hang += lie;
    	
    	String s = "" + hang;
    	return s.charAt(ge) - '0';

    }
    public static void main(String [] args) {
    	String ss = "ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu";
    	System.out.println(ss.replace('-', '_'));
    	
    	Solution s = new Solution();
    	System.out.println(s.findNthDigit(111111));
	}
}