class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1 ;i<prices.length;i++){
            if(prices[i]>prices[i-1]){/*this condition checks if the upcoming value greater than the prev, so in this case there is profit  so we add the diff that gives the change or the profit and then add it with the maxprofit of other changes and go on*/
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
/*Initialization
Prices: [7, 1, 5, 3, 6, 4]

Start profit: 0

Day-by-day calculation
Day 1 → Day 2: 7 → 1

Change: 1 - 7 = -6 (no profit added)

Day 2 → Day 3: 1 → 5

Change: 5 - 1 = +4

Action: buy at 1, sell at 5

Profit: 0 + 4 = 4

Day 3 → Day 4: 5 → 3

Change: 3 - 5 = -2 (no profit added)

Day 4 → Day 5: 3 → 6

Change: 6 - 3 = +3

Action: buy at 3, sell at 6

Profit: 4 + 3 = 7

Day 5 → Day 6: 6 → 4

Change: 4 - 6 = -2 (no profit added)

Final result
Total profit: 7

Explanation: You take two profitable rises: 1 → 5 (profit 4) and 3 → 6 (profit 3). Sum = 4 + 3 = 7.*/