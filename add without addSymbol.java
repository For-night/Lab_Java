class Solution {
    public int add(int a, int b) {
        int jinwei = a,sum = b,ache = 0;
        while(jinwei != 0){
            ache = (jinwei & sum) << 1; // 进位就是 与 的结果
            sum = jinwei ^ sum; // 不进位和等于 异或 的结果
            jinwei = ache;
        }
        
        return sum;
    }
}
