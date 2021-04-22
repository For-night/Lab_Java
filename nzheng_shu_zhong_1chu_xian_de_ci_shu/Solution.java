package nzheng_shu_zhong_1chu_xian_de_ci_shu;

class Solution {
    public int countDigitOne(int n) {
        int ans = 0;

        String str = n + "";

        //System.out.println("String is : "+str);
        char [] res = str.toCharArray();
        int [] array = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            array[i] = res[i] - '0';
        }

        return f(array,0);

//        if(res.length == 1) {
//            //System.out.println("length is 1 :" + n);
//            return res[0] == '0'? 0 :1;
//        }

//        ans += (res[0] - '0') * (res.length  - 1) * Math.pow(10,res.length  - 2) ;
//        //System.out.println("no matter No1 need : " + ans);
//
//        if((res[0] - '0') > 1){
//            ans +=  Math.pow(10,res.length  - 1);
//            //System.out.println("No 1 > 1 : " +ans);
//        }else{ // == 1
//            ans +=  n- (int)((res[0] - '0') * Math.pow(10,res.length - 1)) + 1;
//            //System.out.println("No 1 == 1 : " +ans);
//        }
//
//        ans +=  countDigitOne((int) (n- (int) (res[0] - '0') * Math.pow(10, res.length - 1)));
//        //System.out.println("pass No1 need : " + ans);
//
//        return ans;
    }

    public int f(int [] array , int p){
        int ans = 0;
        System.out.println("String is : "+array2str(array,p));
        if(p == array.length - 1) {
            System.out.println("length is 1 :" + array2str(array,p));
            return array[p] == 0 ? 0 :1;
        }

        if(array[p] == 0){
            return f(array,p+1);
        }

        ans += array[p] * (array.length  - 1 - p ) * Math.pow(10,array.length  - 2 - p) ;
        System.out.println("no matter No1 need : " + ans);

        if(array[p] > 1){
            ans +=  Math.pow(10,array.length - p - 1);
            System.out.println("No 1 > 1 : " +ans);
        }else{ // == 1
            int cache = 0;
            int j = 0 ;
            for (int i = array.length -1 ; i > p ; i--) {
                cache += (int) (array[i] * Math.pow(10,j));
                j++;
            }
            ans += cache + 1;
            System.out.println("No 1 == 1 : " +ans);
        }

        ans +=  f(array,p+1);
        System.out.println("pass No1 need : " + ans);

        return ans;
    }

    public String array2str(int [] array , int p){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = p; i< array.length ; i++) {
            stringBuilder.append(array[i]+"");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "1nzheng-shu-zhong-1chu-xian-de-ci-shu";
        System.out.println(str.replace('-', '_'));

        Solution s = new Solution();
        System.out.println(s.countDigitOne(102));
        System.out.println(s.f(new int[]{1,0,2},0));
    }

}