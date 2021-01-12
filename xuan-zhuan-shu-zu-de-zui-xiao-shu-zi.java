class Solution {
    public int minArray(int[] numbers) {

        int left = 0 , center = (numbers.length - 1) / 2 , right = numbers.length - 1 ;

        if(numbers[right] > numbers[left]){
            return numbers[0];
        }

        while(left != center && right != center){
            
            if(numbers[center] > numbers[left]){
                left = center ; 
                center = (center + right) / 2 ;
            }else if(numbers[center] < numbers[left]){
                right = center ; 
                center = (center + left) / 2 ;
            }else if(numbers[center] > numbers[right]){ // means cent == left
                left = center ; 
                center = (center + right) / 2 ;
            }else if(numbers[center] < numbers[right]){
                right = center ; 
                center = (center + left) / 2 ;
            }else{// left == center == right
                right --;
                center = (right + left) / 2 ;
            }
        }
        //return numbers[center];
        return Math.min(numbers[left],numbers[right]);
    }
}
