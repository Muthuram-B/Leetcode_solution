class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;// 2 pointer approach
        //it is efficient for O(1)  space complexity
        while(i<j){
            if(numbers[i]+numbers[j]==target){// 2+7==9
                return new int[]{i+1,j+1}; //[1,2]
            }if(numbers[i]+numbers[j]<target){
                i++;
            }else{ j--;}
        }
        return new int[0];
    }
}