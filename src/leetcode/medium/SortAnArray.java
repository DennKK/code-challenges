package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

// 912. Sort an Array
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

        System.arraycopy(arr, 0, leftArr, 0, mid);

        if (arrSize - mid >= 0) System.arraycopy(arr, mid, rightArr, 0, arrSize - mid);

        mergeSort(leftArr, mid);
        mergeSort(rightArr, arrSize - mid);
        merge(arr, leftArr, rightArr, mid, arrSize - mid);
    }

    private void merge(int[] array, int[] leftArray, int[] rightArray, int leftArraySize, int rightArraySize) {
        int i = 0, j = 0, k = 0;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
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