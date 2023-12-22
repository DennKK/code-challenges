package easy;

// 121. Best Time to Buy and Sell Stock
public class BestTimeToBnS {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buyPointer = 0, sellPointer = 1;
        while (sellPointer < prices.length) {
            if (prices[sellPointer] - prices[buyPointer] < 0) {
                buyPointer = sellPointer;
            } else {
                maxProfit = Math.max(prices[sellPointer] - prices[buyPointer], maxProfit);
            }
            sellPointer++;
        }
        return maxProfit;
    }
}