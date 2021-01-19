class Solution {
    public String reverseWords(String s) {
    	s = s.trim();  // trim() 方法用于删除字符串的头尾空白符。！！！！！！！！！！！！！！！！NB!
        String [] ans = s.split("\\s+");
        for(String ss : ans){
        	System.out.println("-"+ss+"-");
        }
        System.out.println("length is " +ans.length);
        String aannss = "";

        if(ans.length == 1){
            return ans[0];
        }
        for(int i = ans.length - 1 ; i >= 0  ; i --){
        	if(i == 0){
        		aannss += ans[i];
        	}else{
        		aannss += ans[i];
        		aannss +=  " ";
        	}
        }
        return aannss;
    }
}
