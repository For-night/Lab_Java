// typical dp problem
class Solution {
    public int maxValue(int[][] grid) {
        int hang = grid.length , lie = grid[0].length;
        if(hang == 0 || lie == 0) return 0;

        int [][] dp  = new int[hang][lie];
        int ache_right = 0 , ache_down = 0;
        for(int i = hang - 1 ; i > -1 ; i --){
            for(int j = lie - 1 ; j > -1 ; j -- ){

                ache_right = (j + 1) < lie ? dp[i][j + 1] : 0;
                ache_down = (i + 1) < hang ? dp[i + 1][j] : 0;
                dp[i][j] = grid[i][j] + Math.max(ache_down,ache_right);
                //System.out.println(" hang :"+ i + " ,lie : "+j+" ,right :"+ache_right + " , down :" +ache_down+" ,dp :" + dp[i][j]);
            }
        }
        return dp[0][0];
    }
}
