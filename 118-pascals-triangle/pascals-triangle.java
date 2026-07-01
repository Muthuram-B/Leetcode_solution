class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  result =new ArrayList<>();
        /*if(numRows==0) return result;
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if(numRows ==1 ) return result;

        for(int i=1;i<numRows;i++){
            List<Integer> preRow = result.get(i-1);

            List<Integer> row=new ArrayList<>();
            row.add(1);
            for(int j=0;j<i-1;j++){
                row.add(preRow.get(j)+preRow.get(j+1));

            }

            row.add(1);
            */
            for(int i=0;i<numRows;i++){
                List<Integer> row=new ArrayList<>();
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        row.add(1);
                    }else{
                    //     List<Integer> preRow=result.get(i-1);
                    // row.add(preRow.get(j)+preRow.get(j-1));
                    int prev1=result.get(i-1).get(j);
                    int prev2=result.get(i-1).get(j-1);
                    row.add(prev1+prev2);
                    }
                }
            
            result.add(row);
        }
return result;
    }
}