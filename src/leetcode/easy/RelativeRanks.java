package leetcode.easy;

// 506. Relative Ranks
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int bestScore = findMax(score);
        int[] scoreToIndex = new int[bestScore + 1];

        for (int i = 0; i < score.length; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        int place = 1;
        String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] result = new String[score.length];
        for (int i = bestScore; i >= 0; i--) {
            if (scoreToIndex[i] == 0) {
                continue;
            }
            int realIndex = scoreToIndex[i] - 1;

            if (place < 4) {
                result[realIndex] = MEDALS[place - 1];
            } else {
                result[realIndex] = String.valueOf(place);
            }
            place++;
        }
        return result;
    }

    private int findMax(int[] scores) {
        int res = Integer.MIN_VALUE;
        for (int score : scores) {
            res = Math.max(score, res);
        }
        return res;
    }
}
