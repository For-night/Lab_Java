class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i = 0 ; i< arr.length ; i++){
            if(list.size() <= k){
                for(int j = 0 ; j < list.size() ; j++){
                   if(list.get(j) < arr[i] || j = list.size() - 1){
                    list.add(arr[i]);
                   }else if(list.get(j) >= arr[i] || j = list.size() - 1 ){
                    v
                   }else if(list.get(j) < arr[i] || list.get(j+1) > arr[i] ){
                    list.add( j + 1 , arr[i]);
                   }else if(list.get(j) >= arr[i]){
                    list.add( j , arr[i]);
                   }
                }
            }else{

            }
        }





































        int[] ache = new int[k];
        for(int i = 0; i < k ; i ++){
            ache[i] = arr[i];
        }
        int[] array = new int[k];
        //正序排序
        Arrays.sort(arr);//会检查数组个数大于286且连续性好就使用归并排序，若小于47使用插入排序，其余情况使用双轴快速排序
        System.out.println("升序排序：");
        for (int num = 0 ; num < k ; num ++) {
            System.out.println(num);
            array[num] = arr[num];
        }
        return array;
    }
}
