package java_lab;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


class Solution {
    public double[] dicesProbability(int n) {
        int dp[][] = new int[n + 1][6*n + 1];
        for(int i = 1 ; i <= 6 ; i ++){
            dp[1][i] = i ;
        }

        for(int i = 1 ; i < dp[1].length; i ++) {
        	System.out.println("1 ge shai zi :" + dp[1][i]);
        }
        
        for(int hang = 2 ; hang <= n ; hang ++){

            for(int he = hang ; he <= hang * 6 ; he ++){
            	
                for(int curIs = 1  ; curIs <= 6 ; curIs ++){
                    // lie 就是 sum
                    if(he - curIs <= 0){
                    	System.out.println("break he :" + he);
                        break;
                    }
                    dp[hang][he] += dp[hang - 1][he - curIs];
                    System.out.println("jisuan :" + dp[hang][he]);
                }
            }

        }

        double []ans = new double[6 * n - n + 1];
        for(int index = 0 ; index < ans.length ; index ++){
            ans[index] = dp[n][n + index] / Math.pow(6.0 , n);
        }
        return ans;
    }
}

//class Solution {
//    static List<Integer> al;
//    static int deep;
//    public double[] dicesProbability(int n) {
//        al = new ArrayList<Integer>();
//        deep = n;
//        ArrayList<int []> ans = new ArrayList<int[]>();
//   
//        for(int m = 1 ; m < 7 ; m++){
//            dg(m , 1);
//        }
//        
//        System.out.println(" al size : " + al.size());
//        
//        al.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//            	return o1.compareTo(o2);
//            }
//        });
//        System.out.println(" debug al: ");
//        for(int i = 0 ; i < al.size(); i ++) {
//        	
//        	System.out.print(" al:" + al.get(i));
//        }
//        
//
//        int lengthOfAns = 0;
//        int ache = al.get(0);
//        int ache2 = 1;
//        
//        for(int i = 1; i < al.size(); i ++){
//        	
//            if(ache == al.get(i)){
//            	ache2 ++;
//            	if(i == al.size()- 1) {
//            		int [] ii = {al.get(i) , ache2};
//                    ans.add(ii);
//            	}
//            }else{
//            	int [] ii = {ache , ache2};
//                ans.add(ii);
//                System.out.println(" add : " + al.get(i) + "  i :" + i);
//                ache2 = 1;
//                ache = al.get(i);
//            	if(i == al.size()- 1) {
//            		int [] iii = {al.get(i) , ache2};
//                    ans.add(iii);
//            	}
//            }
//        }
//        System.out.println(" ans size : " + ans.size());
//        ans.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//            	return (o1[0])-(o2[0]);
//            }
//        });
//        
//        System.out.println(" debug ans: ");
//        for(int i = 0 ; i < ans.size(); i ++) {
//        	
//        	System.out.print(" ans:" + ans.get(i)[0] + " " + ans.get(i)[1] );
//        }
//        System.out.println(" debugend-- ");
//
//        lengthOfAns = ans.size();
//        double [] res = new double[lengthOfAns];
//        for(int j = 0 ; j <lengthOfAns; j++){
//            res[j] = (double)(ans.get(j)[1] )/ al.size();
//        }
//        return res;
//    }
//    public void dg(int num ,int d){
//        if(d == deep){
//            al.add(num);
//            return;
//        }else{
//            d++;
//            dg(num+1,d);
//            dg(num+2,d);
//            dg(num+3,d);
//            dg(num+4,d);
//            dg(num+5,d);
//            dg(num+6,d);
//        }
//    }
//}