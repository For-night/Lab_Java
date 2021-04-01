package biao_shi_shu_zhi_de_zi_fu_chuan;


public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        char [] res = s.toCharArray();
        if(res.length < 1){
            return false;
        }
        
        boolean headIsJJ = false;
        boolean hasOneE = false;
        boolean afterEisJJ = false;
        boolean hasD = false;
        int i = 0;
        
        if(res[0] == '.') {
        	hasD = true;
        	i = 1;
        	if( 1 >= res.length  ) {
        		//System.out.println("��� ����û������" + res.length);
        		return false;
        	}
        	if(!isNum(res[1])) {
        		//System.out.println("��� ���� ������" );
        		return false;
        	}
        }
        
        if(isJJ(res[0])) {
        	headIsJJ = true;
        	i = 1;
            // + - ��������
            if(isJJ(res[i]) &&  1 < res.length){
            	if(isJJ(res[1])) {
            		System.out.println("+- Lian xv");
            		return false;
            	}
            }
            if(res[1] == '.') {
            	if(2 >= res.length)return false;
            	if(!isNum(res[2])) return false;
            }
            if(res[1] == 'e' ||res[1] == 'E' ) {
            	return false;
            }
        }
        
        if(res[0] == 'e' ||res[0] == 'E' ) {
        	return false;
        }
        
        for(  ; i < res.length ; i ++) {
        	// ÿ������һ���� + - ����  e
            if(!isNumOrJJE(res[i])) {
            	System.out.println("bushi  JJ or NUM or e");
            	return false;
            }
            //��ǰ�� ���
            if(res[i] == '.') {
            	if(hasOneE) return false;
            	if(hasD) return false;
            	hasD = true;
            	if( i+1 >= res.length  ) {
            		return true;
            	}
            	if(isNum(res[i+1]) || res[i+1] == 'E' || res[i+1] == 'e') {
            		// do nothing
            	}else {
            		return false;
            	}
            }
            
            // +- ǰ��һ���� e E
            if(isJJ(res[i])) {
            	if(res[i - 1] == 'e' ||res[i - 1] == 'E' ) {
            		// do nothing
            	}else {
            		System.out.println("+- ǰ�治��e");
            		return false;
            	}
            }
            
            // + - ��������
            if(isJJ(res[i]) && i + 1 < res.length){
            	if(isJJ(res[i + 1])) {
            		System.out.println("for +- Lian xv");
            		return false;
            	}
            	if(res[1 + i] == '.') return false;
                if(res[1 + i] == 'e' ||res[1 + i] == 'E' ) {
                	return false;
                }
            }
            
            // ��ǰ��e
            if(res[i] == 'e' || res[i] =='E') {
            	if(hasOneE) {
            		System.out.println("���e");
            		return false;
            	}
            	hasOneE = true;
            	if(i+1 >= res.length) {
            		return false;
            	}
            	if(isJJ(res[i+1])) {
                	if(i+2 >= res.length) {
                		return false;
                	}
            	}
            	if(res[i+1] == '.')  {
                	if(i+2 >= res.length)return false;
                	if(!isNum(res[i+2])) return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isNumOrJJE(char c) {
    	if(c == '+' || c == '-' || c == 'e' || c == 'E' || c == '.') {
    		return true;
    	}else if(c >= '0' && c <= '9') {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean isNum(char c) {
    	if(c >= '0' && c <= '9') {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public boolean isJJ(char c) {
    	if(c == '+' || c == '-') {
    		return true;
    	}else {
    		return false;
    	}
    }
	
    public static void main(String [] args) {
    	String ss = "shu-ju-liu-zhong-de-zhong-wei-shu";
    	System.out.println(ss.replace('-', '_'));
    	
    	Solution s = new Solution();
    	System.out.println("main : "+s.isNumber("6e6.5"));
	}
}
