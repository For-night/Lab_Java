class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int mr = 0 , mc = 0 , ans = Integer.MIN_VALUE;
        // ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i]< prices[mr]){
                // res.add(prices[mc] - prices[mr]);
                ans = Math.max(ans,prices[mc] - prices[mr]);
                mr = i;
                mc = i;
            }else if(prices[i] > prices[mc]){
                mc = i;
            }
        }
        ans = Math.max(ans,prices[mc] - prices[mr]);
        return ans;
    }
}
