class Solution {
    public int[] constructArr(int[] a) {
        if(a.length == 0) return new int[0];
        int ans[] = new int[a.length];
        ans[0] = 1;
        for(int i = 1 ; i < a.length ; i ++){
            ans[i] = ans[i - 1] * a[i - 1];
        }
        int ache = 1;
        for(int i = a.length - 2 ; i >= 0 ; i --){
            ache *= a[i + 1];
            ans[i] *= ache; 
        }
        return ans;
    }
}
