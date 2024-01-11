package medium;

// 122. Best Time to Buy and Sell Stock II
public class BuyNSell2 {
    public int maxProfit(int[] prices) {
        int buyPointer = 0, sellPointer = 1, profit = 0;
        while (sellPointer <= prices.length - 1) {
            if (prices[buyPointer] < prices[sellPointer]) {
                profit += prices[sellPointer] - prices[buyPointer];
            }
            buyPointer++;
            sellPointer++;
        }
        return profit;
    }
}