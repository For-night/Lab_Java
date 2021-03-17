//import java.util.Scanner;

import java.io.*;
 
import java.math.*;
 
import java.util.*;
 
import java.text.*;

public class Main{
    static public void main(String arg[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int i = in.nextInt();
            if(i == 0){
                break;
            }else{
                System.out.println(dg(i)[0]);
            }
        }
    }
    public static int[] dg(int num){
        if(num == 1){
            return new int[]{0,1};
        }else{
            int[] ans = dg(num-1);
            if(ans[1]==0){
                return new int[]{ans[0],1};
            }else{
                return new int[]{ans[0]+1,0};
            }
            
        }
    }
}
