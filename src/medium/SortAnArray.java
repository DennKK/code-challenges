package medium;

import java.util.PriorityQueue;
import java.util.Queue;

// Sort an Array
// Merge sort solution
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, nums.length);
        return nums;
    }

    private void mergeSort(int[] arr, int arrSize) {
        if (arrSize < 2) {
            return;
        }

        int mid = arrSize / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arrSize - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = mid; i < arrSize; i++) {
            rightArr[i - mid] = arr[i];
        }

        mergeSort(leftArr, mid);
        mergeSort(rightArr, arrSize - mid);
        merge(arr, leftArr, rightArr, mid, arrSize - mid);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray, int leftArraySize, int rightArraySize) {
        int i = 0, j = 0, k = 0;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArraySize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArraySize) {
            array[k++] = rightArray[j++];
        }
    }
}

// Priority queue solution
class Solution2 {
    public int[] sortArray(int[] nums) {
        Queue<Integer> pQ = new PriorityQueue<>();

        for (int number : nums) {
            pQ.add(number);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pQ.poll();
        }

        return nums;
    }
}