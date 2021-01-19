class Solution {
    public int fib(int n) {
        int ache1 = 0 , ache2 = 1,ans = 0;
        if(n == 1)return ache2;
        if(n == 0)return ache1;
        for(int i = 2 ; i < n +1 ; i++){
            ans = (ache1 + ache2) % 1000000007;
            ache1 = ache2;
            ache2 = ans;
        }
        return ans;
    }
}
