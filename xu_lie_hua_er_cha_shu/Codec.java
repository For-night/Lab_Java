package xu_lie_hua_er_cha_shu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tn = queue.poll();
            if(tn == null){
                res.add("null");
                res.add(",");
            }else{
                res.add(tn.val+"");
                res.add(",");
                if(tn.left != null){
                    queue.add(tn.left);
                }else{
                    queue.add(null);
                }

                if(tn.right != null){
                    queue.add(tn.right);
                }else{
                    queue.add(null);
                }
            }
        }
        int end = res.size() - 1;
        while(end > 0){
            if(res.get(end).equals(",") && res.get(end-1).equals("null")){
                end -= 2;
            }else{
                break;
            }
        }
        //System.out.println("res i : " + end);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0 ; i < end ; i ++){
            sb.append(res.get(i));
        }
        sb.append("]");

        return  sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        data = data.replace("[","");
        data = data.replace("]","");
        String [] res = data.split(",");


        TreeNode ans = new TreeNode(Integer.parseInt(res[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(ans);
        int i = 1;
        while(i< res.length){
            TreeNode curTn = queue.poll();
            //System.out.println("poll : "+curTn.val);
            if(!res[i].equals("null")){
                if (curTn != null) {
                    curTn.left = new TreeNode(Integer.parseInt(res[i]));
                }
                if (curTn != null) {
                    queue.add(curTn.left);
                }
            }
            i++;
            if(i>= res.length){
                break;
            }
            if(!res[i].equals("null")){
                if (curTn != null) {
                    curTn.right = new TreeNode(Integer.parseInt(res[i]));
                }
                if (curTn != null) {
                    queue.add(curTn.right);
                }
            }
            i++;
        }

        return  ans;
    }
    public static void main(String [] args){
        String str = "shu-zu-zhong-de-ni-xu-dui";
        System.out.println(str.replace('-', '_'));

        Codec c = new Codec();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.left = new TreeNode(4);
        t.right.right = new TreeNode(5);
        System.out.println( "serial: " + c.serialize(t) );
        TreeNode tn = c.deserialize("[1,2,3,null,null,4,5]");
        System.out.println( "tn: " + tn.right.left.val );
    }
}

