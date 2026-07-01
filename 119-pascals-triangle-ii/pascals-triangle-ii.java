class Solution {
    public List<Integer> getRow(int rowIndex) {
       
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){

            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) row.add(1);

                
                else{
                int prev1=result.get(i-1).get(j);
                int prev2=result.get(i-1).get(j-1);
                row.add(prev1+prev2);
            }
            }
            result.add(row);
        }
        return result.get(rowIndex);
    }
}