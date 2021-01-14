class Solution {
    int [] ans;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};

        int size = matrix.length * matrix[0].length;
        ans = new int[size];
        int x1=0, y1=0, x2= matrix.length -1, y2= matrix[0].length -1,cnt = 0,j = 0;

        while(cnt < size){
            for( j = y1 ; j < y2 + 1; j++ ){
                ans[cnt++] = matrix[x1][j];
                if(cnt == size) return ans;
            }
            for( j = x1 +1 ; j < x2 + 1; j++ ){
                ans[cnt++] = matrix[j][y2];
                if(cnt == size) return ans;
            }
            for( j = y2 -1 ; j > y1 - 1; j-- ){
                ans[cnt++] = matrix[x2][j];
                if(cnt == size) return ans;
            }
            for( j = x2 -1 ; j > x1 ; j-- ){
                ans[cnt++] = matrix[j][y1];
                if(cnt == size) return ans;
            }
            x1++;
            y1++;
            x2--;
            y2--;
        }
        return ans;
    }
}
