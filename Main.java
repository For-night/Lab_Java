import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String [] args){
        System.out.println("main.java : hello world!");
        String str = "xu-lie-hua-er-cha-shu";
        System.out.println(str.replace('-', '_'));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(null);
        if(q.poll() == null){
            System.out.println("main q poll null!");
        }
        String data = "[1,2,3,null,null,4,5]";
        data = data.replace("[","");
        data = data.replace("]","");
        String [] sa = data.split(",");
        //String [] sa = {"1","null","2"};
        for(int i = 0 ; i <  sa.length ; i ++){
            System.out.println(sa[i]);
            if(!sa[i].equals("null")){
                System.out.println("bushi kong "+(sa[i]));
            }
        }

    }
}
