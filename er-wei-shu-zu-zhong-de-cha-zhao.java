class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        return find(0,matrix[0].length-1,matrix,target);
    }
    boolean find(int i ,int j, int[][]matrix , int target){

        if(target == matrix[i][j]){
            return true;
        }

        if(target > matrix[i][j]){// 目标比当前大 ， 往下运动
            if(i + 1 < matrix.length){ // 下不出界

                return find(i+1,j,matrix,target);

            }else{// 下出界
                return false;
            }

        }else{// 目标比当前小 ， 往左运动
            if(j - 1 > -1){ // 左没出界限

                return find(i,j-1,matrix,target);

            }else{
                return false;
            }
        }

    }
}
