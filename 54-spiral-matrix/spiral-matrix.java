class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colb=0; int rowb=0; int cole=matrix[0].length-1;
        int rowe=matrix.length-1;
       List<Integer> list=new ArrayList<>();
        while(rowb<=rowe && colb <= cole){
            
            for(int i=colb;i<=cole;i++){
                list.add(matrix[rowb][i]);
            }
            rowb++;

            for(int i=rowb;i<=rowe;i++){

             list.add(matrix[i][cole]);
            }
            cole--;

            if(rowb<=rowe){
                for(int i=cole;i>=colb;i--) list.add(matrix[rowe][i]);

                rowe--;
            }

            if(colb<=cole) {
                for(int i=rowe;i>=rowb;i--) list.add(matrix[i][colb]);
                colb++;
            }
        }
            return list;
    
    }
}