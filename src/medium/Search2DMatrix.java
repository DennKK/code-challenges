package medium;

// 74. Search a 2D Matrix
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (binSearch(ints, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binSearch(int[] array, int target) {
        int start = 0, end = array.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}