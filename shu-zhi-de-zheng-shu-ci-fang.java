class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(x == 0){
            return 0;
        }

        if(nn < 0){
            nn = -nn;
            x = 1/x;
        }

        while(nn > 0){
            if((nn & 1) == 1){
                ans *= x;  
            }
            x *= x;
            nn >>= 1;
        }
        return ans ;
    }
}
