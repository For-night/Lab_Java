// 剪绳子，3是最小单位，乘起来最大
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3 ) return n-1;
        int num3 = n / 3;
        int num = n % 3;
        if(num == 0 ) return (int)Math.pow(3,num3);
        if(num == 1 ) return (int)Math.pow(3,num3 - 1) * 4;
        return (int)Math.pow(3,num3) * 2;

    }
}
