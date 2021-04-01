package ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu;

class Solution {
    public int strToInt(String str) {
        char [] res = str.toCharArray();
        if(res.length == 0){
            return 0;
        }
        int i = 0;
        
        while(res[i] == ' ' ){

            i ++;
            if(i == res.length){
            	return 0;
            }
            if(res[i] == '-' || res[i] == '+') {
        		break;
        	}
                        
        }
        System.out.println("i : " + i);
        
        if(res[i] == '+'){
            return trans(res,i+1,true);
        }else if(res[i] == '-'){
            return trans(res,i+1,false);
        }else if(res[i] >= '0' && res[i] <= '9'){
            return trans(res,i,true);
        }else{
            return 0;
        }
    }

    public int trans(char [] res , int p ,boolean flag){
        long ans = 0;
        while(p < res.length && res[p] >= '0' && res[p] <= '9'){
        	//System.out.println("res p : " + res[p] + " yunsuan :" + (res[p] - '0'));
            ans = ans * 10 + (int)(res[p++] - '0');
            //System.out.println("ans : " + ans);
            
            if(flag) {
            	if(ans > Integer.MAX_VALUE){
            		return Integer.MAX_VALUE;
            	}
            }else {
            	if(-ans < Integer.MIN_VALUE){
            		return Integer.MIN_VALUE;
            	}
            }
        }
        return flag ? (int)ans : (int)-ans;
    }
    
    public static void main(String [] args) {
    	String ss = "biao-shi-shu-zhi-de-zi-fu-chuan";
    	System.out.println(ss.replace('-', '_'));
    	
    	Solution s = new Solution();
    	System.out.println("main : "+s.strToInt(" "));
	}
}
