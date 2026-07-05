class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxlen=1; int currlen=1;
         
         int lastdirection=0;
        for(int i=1;i<arr.length;i++){

            int currentdirection=Integer.compare(arr[i],arr[i-1]);
           if(currentdirection==0) currlen=1;

           else if(currentdirection == -lastdirection) currlen++;

             else currlen=2;

             maxlen=Math.max(maxlen,currlen);
             lastdirection=currentdirection;

        }
        return maxlen;
    }
}