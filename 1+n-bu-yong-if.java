class Solution {
    public int sumNums(int n) {
        boolean flag = (n>0)&&( n += sumNums(n - 1))>0;
        return n;
    }
    // public int sumNums(int n) {
    //     if(n == 0) return 0;
    //     return n + sumNums(n-1);
    // }
}
