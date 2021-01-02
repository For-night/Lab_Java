class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int[] ache = new int[k];
        //list.add(arr[0]);
        if(k > arr.length){ 
            return new int[0];
        }



        System.out.println("starrt!");
        for(int i = 0 ; i < k ; i++){
            ache[i] = arr[i];
        }
        Arrays.sort(ache);
        for(int i = 0 ; i < k ; i++){
            System.out.println("ache is :"+ache[i]); 
        }
        for(int i = 0 ; i < k ;i++){
            list.add(ache[i]);
            System.out.println("list is :"+list.get(i)); 
        }

        for(int i = k ; i< arr.length ; i++){
            System.out.println("arr[k]:"+arr[i]); 
            for(int j = 0 ; j <k ; j++){
                if(arr[i] > list.get(j)){
                    if(j+1 < k){// 
                        if(arr[i] <= list.get(j+1) ){
                            list.add( j+1  , arr[i]);
                            break;
                        }
                    }else{
                        list.add( j+1  , arr[i]);
                        break;
                    }
                }else{
                    list.add( j  , arr[i]);
                    break;
                }
            }
        }

        
        for(int i = 0 ; i < k ; i++){
            ache[i] = list.get(i);
        }
        return ache;
        // int[] ache = new int[k];
        // for(int i = 0; i < k ; i ++){
        //     ache[i] = arr[i];
        // }
        // int[] array = new int[k];
        // //正序排序
        // Arrays.sort(arr);//会检查数组个数大于286且连续性好就使用归并排序，若小于47使用插入排序，其余情况使用双轴快速排序
        // System.out.println("升序排序：");
        // for (int num = 0 ; num < k ; num ++) {
        //     System.out.println(num);
        //     array[num] = arr[num];
        // }
        // return array;
    }
}
