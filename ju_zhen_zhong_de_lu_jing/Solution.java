package ju_zhen_zhong_de_lu_jing;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public char[][] matrix;
    public char[] letter;
    public Set<String> set;
    public boolean exist(char[][] board, String word) {
        matrix = board;
        letter = word.toCharArray();
        set = new HashSet<String>();

        if(matrix.length == 0 || letter.length == 0){
            return true;
        }
        if(matrix.length * matrix[0].length < letter.length){
            return false;
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j ++){
                if(matrix[i][j] == letter[0]){
                    if(check( i , j , 0)){
                        return true;
                    }else{
                        set.clear();
                    }
                }
            }
        }
        return false;
    }

    public boolean check(int i , int j , int index){
    	
    	if(matrix[i][j] == letter[index]) {
    		if(index == letter.length - 1 ) 
    			return true;
    	}else {
            return false;
    	}
    	// 说明这个地方相等，那么就标记一下来过
    	set.add(i+ " " +j); 
    	
        boolean up = false,down= false,left= false,right= false;
        
        if( i > 0 ){
            if(set.contains((i-1) + " " +j)){
                up = false;
            }else {
				up = check(i - 1 , j , index + 1);
            }

        }
        
        if( i < matrix.length - 1){
            if(set.contains(i+1 + " " +j)){
                down = false;
            }else {
            	down = check(i + 1 , j , index + 1);
            }
        }
        
        if( j > 0 ){
            if(set.contains(i + " " +(j - 1))){
                left = false;
            }else {
            	left = check(i , j - 1 , index + 1);
            }
        }
        
        if( j < matrix[0].length - 1){
            if(set.contains(i + " " +(j + 1))){
                right = false;
            }else {
            	right = check(i , j + 1 , index + 1);
            }
        }
        
        boolean ans = up|down|right|left;
        
        if(ans == false) {
        	// 但是这个地方上下左右都是false，删除这个点
        	set.remove(i+ " " +j);
        }
        return ans;
    }
    
    public static void main(String [] args) {
    	Solution s = new Solution();
    	System.out.println(s.exist(new char[][] {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}},"aaaaaaaaaaab")); 

	}
}