class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        int x2 = 0 , x3 = 0 ,x5 = 0;
        for(int i = 1 ; i < n ; i++){
            dp[i] = Math.min(Math.min(dp[x2] * 2 , dp[x3] * 3 ) , dp[x5] * 5);
            //System.out.println("dp" + dp[i] + " x2 :" + x2 + " x3 :"+ x3 + " x5:" +x5);
            if(dp[i] == dp[x2] * 2 ) x2++;
            if(dp[i] == dp[x3] * 3 ) x3++;
            if(dp[i] == dp[x5] * 5 ) x5++;
        }
        return dp[n-1];
    }
}
