class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }else if(inorder.length == 0){
            return null;
        }

        TreeNode ans = new TreeNode(preorder[0]);
        int i;
        int preorderLeft[] ,preorderRight[] ,left_inorder[],right_inorder[];
        for(i = 0 ; i < inorder.length ; i ++){ //find center in inorder
            if(inorder[i] == preorder[0])
                break;
        }
        

        if(i == 0){  // no left
            left_inorder = new int[]{};
            preorderLeft = new int[]{};
            right_inorder = new int[inorder.length - 1];
            preorderRight = new int[preorder.length - 1];
            for(int j = 0 ; j < right_inorder.length ; j++){
                right_inorder[j] = inorder[j + 1];
                preorderRight[j] = preorder[j + 1];
            }
        }else if(i == inorder.length - 1){ // no right
            left_inorder = new int[inorder.length - 1];
            preorderLeft = new int[preorder.length - 1];
            right_inorder = new int[]{};
            preorderRight = new int[]{};
            for(int j = 0 ; j < left_inorder.length ; j++){
                left_inorder[j] = inorder[j];
                preorderLeft[j] = preorder[j+1];
            }
        }else{
            left_inorder = new int[i];
            preorderLeft = new int[i];
            right_inorder = new int[inorder.length -1 - i];
            preorderRight = new int[preorder.length -1 - i];
            System.out.println("inorder length is : " + inorder.length);
            System.out.println("inorderL length is : " + left_inorder.length);
            System.out.println("inorderR length is : " + right_inorder.length);
            for(int j = 0; j < i ; j++){
                left_inorder[j] = inorder[j];
                preorderLeft[j] = preorder[j+1];
            }
            for(int j = 0; j < right_inorder.length ; j++){
                right_inorder[j] = inorder[j+i+1];
                preorderRight[j] = preorder[j+i+1];
            }
        }






        ans.left = buildTree(preorderLeft,left_inorder);
        ans.right = buildTree(preorderRight,right_inorder);
        return ans;
    }
}

// import java.util.ArrayList;
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder.length == 0)
//             return null;

//         ArrayList<Integer> pre = new  ArrayList<Integer>();
//         ArrayList<Integer> in = new  ArrayList<Integer>();
//         for(int i = 0; i < preorder.length ;i ++){
//             pre.add(preorder[i]);
//             in.add(inorder[i]);
//         }
//         return builderArr(pre,in);
//     }

//     public TreeNode builderArr(ArrayList<Integer> pre, ArrayList<Integer> in){
//         if(pre.size() == 1){
//             return new TreeNode(pre.get(0));
//         }

//         TreeNode node = new TreeNode(pre.get(0));
//         int div= in.indexOf(pre.get(0));

//         //System.out.println( "div : " + div ) ;

//         ArrayList<Integer> inorderLeft = new  ArrayList<Integer>(div);
//         ArrayList<Integer> inorderRight = new  ArrayList<Integer>(in.size() - div - 1);

//         ArrayList<Integer> preorderLeft = (ArrayList<Integer>) pre.clone();
//         preorderLeft.remove(0);
        
//         ArrayList<Integer> preorderRight = (ArrayList<Integer>) pre.clone();
        
//         preorderRight.remove(0);
//         //生成左右中序，也就一分为2
        
//         for(int i = 0; i < div ; i++){
//             inorderLeft.add(in.get(i));
//         }
        
//         for(int i = div+1; i < in.size() ; i++){
//             inorderRight.add(in.get(i));
//         }
//         //删除左右pre中的多余成分
        
//         for(int i = 0; i < inorderRight.size() ; i++){
//             if(preorderLeft.indexOf(inorderRight.get(i)) != -1){
                
//                 preorderLeft.remove(preorderLeft.indexOf(inorderRight.get(i)));
                
//             }
//         }
//         for(int i = 0; i < inorderLeft.size() ; i++){
//             if(preorderRight.indexOf(inorderLeft.get(i)) != -1){
//                 preorderRight.remove(preorderRight.indexOf(inorderLeft.get(i)));
//             }
//         }


//         if(preorderLeft.size() > 0){
//             node.left = builderArr(preorderLeft,inorderLeft);
//         }
//         if(preorderRight.size() > 0){
//             node.right = builderArr(preorderRight,inorderRight);
//         }
        
//         return node;
//     }
    
// }
