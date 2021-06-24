package open_the_lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> deadSet = new HashSet<>();
        Set<String> seenSet = new HashSet<>();

        for(String dead:deadends){
            deadSet.add(dead);
        }
        if(deadSet.contains(target)){
            return -1;
        }

        queue.add("0000");
        int step = 0;
        while(!queue.isEmpty()){
            step ++;
            int size = queue.size();

            for(int i = 0 ; i < size ; i ++){
                String state = queue.poll();
                for(String eachStr:nextStep(state)){
                    if(deadSet.contains(eachStr)){
                        continue;
                    }else{
                        if(eachStr.equals(target)){
                            return step;
                        }
                        if(!seenSet.contains(eachStr)){
                            seenSet.add(eachStr);
                            queue.add(eachStr);
                        }
                    }
                }
            }

        }
        return -1;
    }

    public String[] nextStep(String str){
        char[] cArray = str.toCharArray();
        String [] ans = new String[8];
        int index = 0;
        for(int i = 0 ; i < 4 ; i ++){
            char [] ccA = cArray.clone();
            char [] ccB = cArray.clone();

            if(cArray[i] == '9'){
                ccA[i] = '0';
            }else{
                ccA[i] ++;
            }
            ans[index++] = String.valueOf(ccA);

            if(cArray[i] == '0'){
                ccB[i] = '9';
            }else{
                ccB[i] --;
            }
            ans[index++] = String.valueOf(ccB);
        }

//        for(String ss:ans){
//            System.out.println(str + " " + ss);
//        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
}