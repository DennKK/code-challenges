package leetcode.easy;

// Maximum Number of Balloons
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[][] cache = new int[2][5];
        cache[0][0] = 'b';
        cache[0][1] = 'a';
        cache[0][2] = 'l';
        cache[0][3] = 'o';
        cache[0][4] = 'n';

        for (char letter : text.toCharArray()) {
            for (int i = 0; i < 5; i++) {
                if (cache[0][i] == letter) {
                    cache[1][i] += 1;
                    break;

                }
            }
        }

        cache[1][2] /= 2;
        cache[1][3] /= 2;

        int res = Integer.MAX_VALUE;
        for (int frequency: cache[1]) {
            res = Math.min(res, frequency);
        }
        return res;
    }
}