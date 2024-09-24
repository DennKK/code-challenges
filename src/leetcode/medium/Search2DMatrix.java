package leetcode.medium;

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

class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lArrIndx = 0, rArrIndx = matrix.length - 1;
        while (lArrIndx <= rArrIndx) {
            int midArrIndx = lArrIndx + (rArrIndx - lArrIndx) / 2;
            int[] guessArr = matrix[midArrIndx];

            boolean searchOnTheRightSide = false;
            int l = 0, r = guessArr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int guess = guessArr[mid];

                if (target == guess) {
                    return true;
                } else if (guess > target) {
                    r = mid - 1;
                    searchOnTheRightSide = false;
                } else {
                    l = mid + 1;
                    searchOnTheRightSide = true;
                }
            }

            if (searchOnTheRightSide) {
                lArrIndx = midArrIndx + 1;
            } else {
                rArrIndx = midArrIndx - 1;
            }

        }

        return false;
    }
}
