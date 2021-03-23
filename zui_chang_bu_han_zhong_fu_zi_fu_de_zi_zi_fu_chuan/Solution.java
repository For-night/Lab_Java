package zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        String subStr = "";
        int start = 0  , end = 0; // the item end printing is not member
        if(s.length() == 0){
            return 0;
        }
        for(int i = 0 ; i < s.length() ; i ++){
        	subStr = s.substring(start, end );
        	System.out.println("sub is:" + subStr + "#");
            if(!subStr.contains(s.charAt(i) + "")){
                end = i+1;
                System.out.println("after end ++ end is :"+end+" start is :"+ start + " ans is : " + ans);
            }else{
            	ans = Math.max(ans,end - start);
            	end = i + 1 ;
            	while(s.charAt(start) != s.charAt(i)) {
            		start ++;
            	}
            	start ++;
                System.out.println("after start ++ end is :"+end+" start is :"+ start+ " ans is : " + ans);
            }
        }
        ans = Math.max(ans,end - start);
        return ans;
    }
    public static void main(String [] args) {
    	Solution s = new Solution();
    	System.out.println(s.lengthOfLongestSubstring("aab")); 
    	String ss = "shu-de-zi-jie-gou";
    	System.out.println(ss.replace('-', '_'));
    	
	}
}
/*
* dic.put(s.charAt(j), j); // 鏇存柊鍝堝笇琛ㄨ褰曪紝鐢╟har鍋歬ey锛屾潵鏇存柊鏈�闈犲悗闈㈢殑index!! NB
*/