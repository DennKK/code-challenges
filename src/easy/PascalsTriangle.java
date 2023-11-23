package easy;

import java.util.ArrayList;
import java.util.List;

// Pascal's Triangle
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < result.get(i - 1).size(); j ++) {
                if (j == 0) {
                    temp.add(1);
                }
                else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}