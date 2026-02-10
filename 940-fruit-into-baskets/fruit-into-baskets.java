class Solution {
    public int totalFruit(int[] fruits) {
        // this is kind of same as longest substring with k distict characters

        int l=0; int maxlen=0;
        Map<Integer,Integer> countmap=new HashMap<>();

        for(int r=0;r<fruits.length;r++){
            int fruit=fruits[r];
            countmap.put(fruit,countmap.getOrDefault(fruit,0)+1);

            while(countmap.size()>2){
                int leftfruit=fruits[l];
                countmap.put(leftfruit,countmap.get(leftfruit)-1);
                if(countmap.get(leftfruit)==0) countmap.remove(leftfruit);
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}