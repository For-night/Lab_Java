class Solution {
    public int cuttingRope(int n) {
        if(n <= 3 ) return n-1;
        int m = 1000000007;
        int num3 = n / 3;
        int num = n % 3;
        long ans = 1;
        for(int i = 0 ; i < num3 - 1 ; i ++){
            ans = ans * 3 % m;
        }

        if(num == 0 ) {
            return (int)(ans * 3 % m);
        }
        if(num == 1 ){
            return (int)(ans  * 4 % m);
        }
        return (int)(ans * 6 % m);
    }
}
