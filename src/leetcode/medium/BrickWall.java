package leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 554. Brick Wall
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gapPosCounter = new HashMap<>();

        for (List<Integer> row : wall) {
            int gapPos = 0;

            if (row.size() != 1) {
                for (int j = 0; j < row.size() - 1; j++) {
                    gapPos += row.get(j);

                    if (gapPosCounter.containsKey(gapPos)) {
                        gapPosCounter.put(gapPos, gapPosCounter.get(gapPos) + 1);
                    } else {
                        gapPosCounter.put(gapPos, 1);
                    }
                }
            }
        }

        int maxGaps = 0;
        for (int key : gapPosCounter.keySet()) {
            maxGaps = Math.max(gapPosCounter.get(key), maxGaps);
        }

        return wall.size() - maxGaps;
    }
}