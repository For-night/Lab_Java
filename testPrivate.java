public class testPrivate {
    static int test2 = 0;
    private static  int test = 0;
    private int test3 = 0;
    public testPrivate() {
        test = 1;
        System.out.println(this.getClass().getName()+"   "+test);
    }
    void sadd(){
        test ++;
    }
    void dis(){
        System.out.println(this.getClass()+"   "+test);
    }
}
