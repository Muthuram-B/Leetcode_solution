class Solution {
    public int longestMountain(int[] arr) {
        
        int n=arr.length; int ans=0;
        // we need to run form 1 to n-2 because we need to find the peak(1<4>3)
        for(int i=1;i<=n-2;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
//once a peak is found then iterate over left and right elemnents to count the points
  int count=1;// the 1 adds the peak itself
                int j=i;
                //to find the leftmost points from the peak
                while(j>0 && arr[j]>arr[j-1]){
                    j--;
                    count++;
                }
                //to find the rightmost points from the peak
                while(i<n-1 && arr[i]>arr[i+1]){
                    i++;
                    count++;
                }
                ans=Math.max(count,ans);
            }
        }
        return ans;
    }
}