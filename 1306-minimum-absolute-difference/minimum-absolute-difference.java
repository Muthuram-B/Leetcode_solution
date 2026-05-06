class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        //to find the mindiff first sort array then add the pairs which match them

        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        // to find the mindiff between the elements
        for(int i=1;i<arr.length;i++){
            mindiff=Math.min(mindiff,arr[i]-arr[i-1]);
        }

        //to list the matched pairs
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==mindiff)
            result.add(Arrays.asList(arr[i-1],arr[i]));
        }
        return result;
    }
}