package easy;

// 2706. Buy Two Chocolates
public class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int fMin = 101, sMin = 101;
        for (int price : prices) {
            if (price < fMin) {
                sMin = fMin;
                fMin = price;
            } else if (price < sMin) {
                sMin = price;
            }
        }

        return (fMin + sMin) <= money ? money - (fMin + sMin) : money;
    }
}