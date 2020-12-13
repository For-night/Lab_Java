// class Solution {
//     public int lastRemaining(int n, int m) {
//         ArrayList<Integer> data = new ArrayList<Integer>();
//         int cur = 0;
//         for(int i = 0;i < n ; i++){
//             data.add(i);
//         }
//         while(data.size()> 1){
//             int ache = (cur + m - 1) % data.size() ;
//             data.remove(ache);
//             System.out.println(ache);
//             cur = ache;
//         }
//         return data.get(0);
//     }
// }
class Solution {
    public int lastRemaining(int n, int m) {
        int cur = 0;
        for(int i = 2; i< n + 1 ; i++){
            cur = ( m + cur ) % i;   // m % i 上一次被删除的那个货的下标，加上cur就是幸存者在那一轮的位置
        }
        return cur;
    }
}
