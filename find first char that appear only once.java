import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
class Solution {
    public char firstUniqChar(String s) {
        Map<String,Integer> map = new HashMap<String,Integer>();    // int - Integer   char - Character !!!
        for(int i = 0; i < s.length() ; i++){
            if(map.containsKey(""+s.charAt(i))){
                map.put(""+s.charAt(i),map.get(""+s.charAt(i))+1);
            }else{
                map.put(""+s.charAt(i),1+ i*10000);                 // only need bigger than 1 or 1 ,so can use true or false!!!
            } 
        }
                                                                    // Map.Entry e  = map.entrySet()  
                                                                    // e.getKey() ; e.getValue()  ;  本来就是有序的！
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();

        char c = ' ';
        int  min = Integer.MAX_VALUE;                               // stupid , we can use origin string to find the first
        while(it.hasNext()) {
            Map.Entry<String, Integer>  entryAche = it.next();
            if(entryAche.getValue()%10000 == 1){
                System.out.println("value : "+ entryAche.getValue() );
                if(min > entryAche.getValue()/1000 ) {
                    c = entryAche.getKey().charAt(0);
                    min = entryAche.getValue()/1000;
                } 
            }
        }
        return c;
    }
}
