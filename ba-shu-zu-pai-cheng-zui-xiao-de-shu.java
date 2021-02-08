// compareTo() 方法 数字返回大小，字符串返回字典索引先后

class Solution {
    public String minNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++ ){
            ans[i] = nums[i]+"";
        }
        Arrays.sort(ans,new myCompare());
        String string = "";
        for(String s : ans){
            string += s;
        }

        return string;
    }

    public class myCompare implements Comparator<String>{
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
}
