import java.util.Scanner;
public class Main{
    static public void main(String arg[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            s = s.substring(2,s.length());
            int ans = 0;
            for(int i = 0 ; i < s.length() ; i ++){
                if(s.charAt(i) <= '9' && s.charAt(i) >= '0'){
                    ans += (s.charAt(i) - '0') * Math.pow(16,s.length() - i - 1);
                }else{
                    ans += (s.charAt(i) - 'A' + 10) * Math.pow(16,s.length() - i - 1);
                }
                
            }
            System.out.println(ans);
        }
    }
}
