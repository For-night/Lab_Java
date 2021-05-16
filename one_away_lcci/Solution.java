

class Solution {
    public boolean oneEditAway(String first, String second) {

        if(first.equals(second)){
            return true;
        }

        int s1 = first.length();
        int s2 = second.length();
        String chang;
        String duan;
        if(s1 > s2){
            chang = first;
            duan = second;
        }else {
            chang = second;
            duan = first;
        }
        int big = Math.max(s1,s2);
        int small = Math.min(s1,s2);

        if(small == 0 && big == 1){
            return true;
        }

        if(big - small > 1){
            return false;
        }

        if(s1 == s2){
            return eCheck(chang,duan);
        }else{
            return iCheck(chang,duan);
        }
    }

    public static boolean eCheck(String s1,String s2){
        int notSame = 0;
        int p = 0;
        for(p = 0; p < s1.length();p++){
            if(s1.charAt(p) != s2.charAt(p)){
                notSame ++;
            }
            if(notSame > 1){
                return false;
            }
        }
        return true;
    }

    public static boolean iCheck(String s1,String s2){
        int p1 = 0;
        int p2 = 0;

        while(p2<s2.length()){

            if(s1.charAt(p1) == s2.charAt(p2)){
                p1 ++;
                p2 ++;
            }else{
                p1 ++;
            }


            if(p1 - p2 > 1){
                return false;
            }

        }

        if(p1 - p2 > 1){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.oneEditAway("a","ab"));
        //s.oneEditAway("horse","ros");
    }
}
