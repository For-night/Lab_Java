class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0){
            return true;
        }
        return verifyPostorderMy(postorder , 0 , postorder.length - 1);
    }

    public boolean verifyPostorderMy(int[] postorder,int start , int end){
        if(end - start < 3){ // length 是 1 or 2 or 3
            return true;
        }else{
            // length 是 4以及以上
            int center = postorder[end];
            int fenjie = -1; // 右子树第一个元素位置
            for(int i = start ; i < end ; i ++){ // 达不到end
                if(postorder[i] > center){
                    fenjie = i;
                    break;
                }
            }

            if(fenjie == -1){ // 说明全是左子树 
                return verifyPostorderMy(postorder , start ,end - 1);
            }else if(fenjie == start) { // all 右子树
                for(int i = start ; i < end ; i ++){
                    if(postorder[i] < center)
                        return false;
                }                
                return verifyPostorderMy(postorder , start ,end - 1);
            }else{
                for(int i = fenjie ; i < end ; i ++){
                    if(postorder[i] < center)
                        return false;
                } 
                return verifyPostorderMy(postorder , start ,fenjie - 1) && verifyPostorderMy(postorder , fenjie ,end - 1);
            }

        }
    }
}
