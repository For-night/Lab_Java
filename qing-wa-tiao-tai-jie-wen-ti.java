class Solution {
    public int ans;
    public int numWays(int n) {
        if(n == 0 || n == 1) return 1;
        if( n == 2) return 2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1 ; i++){
            dp[i] =  (dp[i - 1] + dp[i - 2]) % (1000000007);
        }
        return dp[n] ;
    }
}

/*
class Solution {
    public int ans;
    public int numWays(int n) {
        ans = 0;
        f( 0 , n );
        return ans % (1000000007);
    }

    public void f(int step,int n){
        if(n - step > 1){
            f(step + 1,n);
            f(step + 2,n);
        }else {
            ans ++;
        }
    }
}
*/
