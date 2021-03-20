package ji_qi_ge_zi;

import java.util.ArrayList;

class Solution {
    int answer = 0;
    int[][] gone;
    public int movingCount(int m, int n, int k) {
        gone = new int[m][n] ;
        findGeZi(m,n,k,0,0);
        return answer;
    }

    public void findGeZi(int m , int n, int k ,int x , int y){
        gone[x][y] = -1;
        if( sumOfx(x) + sumOfx(y) > k){
            return;
        }
        answer ++;
        System.out.println("ans ++  x:" + x + " y: "+y);
        // up
        if(x - 1 >= 0 && gone[x-1][y] != -1){
            findGeZi(m,n,k,x-1,y);
        }
        // down
        if(x + 1 < m && gone[x+1][y] != -1){
            findGeZi(m,n,k,x+1,y);
        }

        //left
        if(y - 1 >= 0 && gone[x][y-1] != -1){
            findGeZi(m,n,k,x,y-1);
        }
        //right
        if(y + 1 < n && gone[x][y+1] != -1){
            findGeZi(m,n,k,x,y+1);
        }
    }

    public int longOfNum(int num){
        int ans = 0 ;
        while(num > 0){
            num = num / 10;
            ans ++;
        }
        return ans;
    }

    public int sumOfx(int x){
        int ans = 0;
        int xx = x;
        for(int i = 0 ; i < longOfNum(xx) ; i++){
            ans += x % 10;
            x = x / 10;
        }
        return ans;
    }
    
    public static void main(String [] args) {
    	Solution s = new Solution();
    	//System.out.println(s.sumOfx(110001)+" "+s.longOfNum(110001));
    	System.out.println(s.movingCount(38,15,9));
	}
}
