import java.util.*;

public class Main {
     static public void main(String [] args){
        System.out.println("main.java : hello world!");
        String str = "open-the-lock";
        System.out.println(str.replace('-', '_'));
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(null);
//        if(q.poll() == null){
//            System.out.println("main q poll null!");
//        }
//        String data = "[1,2,3,null,null,4,5]";
//        data = data.replace("[","");
//        data = data.replace("]","");
//        String [] sa = data.split(",");
//        //String [] sa = {"1","null","2"};
//        for(int i = 0 ; i <  sa.length ; i ++){
//            System.out.println(sa[i]);
//            if(!sa[i].equals("null")){
//                System.out.println("bushi kong "+(sa[i]));
//            }
//        }
//        Map map;
//        Set<Integer> set = new HashSet<>();
//        set.add(6);
//        set.add(2);
//        set.add(4);
//        Integer[] arr =  set.toArray(new Integer[0]);
//        Arrays.sort(arr);
//        for (Integer integer : arr) {
//            System.out.println(integer);
//        }
         //System.out.println("checkMask: "+ checkMask("255.255.0.0"));
         String s = "11111111111001100000000000000000";
         //System.out.println(s.length());

         char [] c = {'1','2'};
         char [] c1 = c.clone();
         c1[0] ++;
         char [] c2 = c.clone();
         c2[0] --;
         System.out.println(c[0]);
         System.out.println(c1[0]);
         System.out.println(c2[0]);

    }
    public static boolean checkMask(String str){
        String [] strs;
        strs = str.split("\\.");
        if(strs.length != 4){
            //System.out.println("size != 4");
            return false;
        }
        int [] arr = new int[4];
        boolean catchErr = false;

        for(int i = 0 ; i < 4 ; i ++){
            try{
                arr[i] = Integer.parseInt(strs[i]);
            }catch(Exception eee){
                return false;
            }
        }

        if(arr[0] == 0 &&arr[1] == 0 &&arr[2] == 0 &&arr[3] == 0 ){
            return false;
        }
        if(arr[0] == 255 &&arr[1] == 255 &&arr[2] == 255 &&arr[3] == 255 ){
            return false;
        }

        //long ipSum = 256*256*256* arr[0] + 256*256* arr[1]+ 256* arr[2] + arr[3];

        String ip = "";
        for(int i = 0 ; i < 4 ; i++){
            String s = Integer.toString(arr[i],2);
            if(s.length()<8){
                s = "0"+s;
            }
            ip+= s;
        }
//        ip = Long.toString(ipSum,2);
//        System.out.println("ipSting: "+ip + "  " + ipSum);

        String ip2 = "";
        for(int i = ip.length()-1; i >= 0 ; i--){
            ip2+= ip.charAt(i)+"";
        }
        long sum = Long.parseLong(ip2,2);
        sum++;

        return Long.bitCount(sum) == 1;
    }

}
