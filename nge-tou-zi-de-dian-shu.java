class Solution {
    static List<Integer> al;
    static int deep;
    public double[] dicesProbability(int n) {
        al = new ArrayList<Integer>();
        deep = n;
        ArrayList<int []> ans = new ArrayList<int[]>();
   
        for(int m = 1 ; m < 7 ; m++){
            dg(m , 1);
        }
    
        
        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
            	return o1.compareTo(o2);
            }
        });

        

        int lengthOfAns = 0;
        int ache = al.get(0);
        int ache2 = 1;
        
        for(int i = 1; i < al.size(); i ++){
        	
            if(ache == al.get(i)){
            	ache2 ++;
            	if(i == al.size()- 1) {
            		int [] ii = {al.get(i) , ache2};
                    ans.add(ii);
            	}
            }else{
            	int [] ii = {ache , ache2};
                ans.add(ii);
                //System.out.println(" add : " + al.get(i) + "  i :" + i);
                ache2 = 1;
                ache = al.get(i);
            	if(i == al.size()- 1) {
            		int [] iii = {al.get(i) , ache2};
                    ans.add(iii);
            	}
            }
        }

        ans.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	return (o1[0])-(o2[0]);
            }
        });
        

        lengthOfAns = ans.size();
        double [] res = new double[lengthOfAns];
        for(int j = 0 ; j <lengthOfAns; j++){
            res[j] = (double)(ans.get(j)[1] )/ al.size();
        }
        return res;
    }
    public void dg(int num ,int d){
        if(d == deep){
            al.add(num);
            return;
        }else{
            d++;
            dg(num+1,d);
            dg(num+2,d);
            dg(num+3,d);
            dg(num+4,d);
            dg(num+5,d);
            dg(num+6,d);
        }
    }
}
