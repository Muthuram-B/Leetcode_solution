class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int price:prices){
            if(price<minPrice){
                minPrice=price;

            }else if(price-minPrice>maxProfit){
                maxProfit=price-minPrice;

            }
        }
        return maxProfit;
    }
}

/*Initialization
minPrice = Integer.MAX_VALUE (a very large number, so any real price will be smaller).

maxProfit = 0.

Iterating through prices
1. Price = 7
Compare with minPrice: 7 < MAX_VALUE → update minPrice = 7.

Profit check skipped (since we just updated minPrice).

State: minPrice = 7, maxProfit = 0.

2. Price = 1
Compare with minPrice: 1 < 7 → update minPrice = 1.

State: minPrice = 1, maxProfit = 0.

3. Price = 5
Compare with minPrice: 5 < 1? ❌ (no update).

Profit = 5 - 1 = 4.

Compare with maxProfit: 4 > 0 → update maxProfit = 4.

State: minPrice = 1, maxProfit = 4.

4. Price = 3
Compare with minPrice: 3 < 1? ❌ (no update).

Profit = 3 - 1 = 2.

Compare with maxProfit: 2 > 4? ❌ (no update).

State: minPrice = 1, maxProfit = 4.

5. Price = 6
Compare with minPrice: 6 < 1? ❌ (no update).

Profit = 6 - 1 = 5.

Compare with maxProfit: 5 > 4 → update maxProfit = 5.

State: minPrice = 1, maxProfit = 5.

6. Price = 4
Compare with minPrice: 4 < 1? ❌ (no update).

Profit = 4 - 1 = 3.

Compare with maxProfit: 3 > 5? ❌ (no update).

State: minPrice = 1, maxProfit = 5.

Final Result
Loop ends.

maxProfit = 5. ✅

🎯 Intuition
Buy at the lowest price (1).

Sell at the highest price after that (6).

Profit = 6 - 1 = 5.

That’s why the output is 5.*/