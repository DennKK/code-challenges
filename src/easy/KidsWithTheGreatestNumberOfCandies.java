package easy;

import java.util.List;
import java.util.ArrayList;

// Kids With the Greatest Number of Candies
public class KidsWithTheGreatestNumberOfCandies {
    public int maxNumber(int[] array) {
        int result = Integer.MIN_VALUE;
        for (int number : array) {
            result = Math.max(number, result);
        }
        return result;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandiesAmount = maxNumber(candies);
        List<Boolean> result = new ArrayList<>();
        for (int kidCandy : candies) {
            if (kidCandy + extraCandies >= maxCandiesAmount) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}