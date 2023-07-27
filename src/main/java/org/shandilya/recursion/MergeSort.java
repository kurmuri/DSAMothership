package org.shandilya.recursion;

import java.util.Arrays;

public class MergeSort {

    // arr is the input array, low and high are left and right most boundaries
    // Find the mid index, call merge sort on array from low to mid and mid + 1 to high
    // In the last merge the two arrays
    private static void mergeSort(int[] arr, int low, int high) {
        // For positive base case
        /*if(low < high) {
            int mid = low + (high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }*/
        // For negative base case
        if (low >= high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = mid - low + 1; // Left array size
        int right = high - mid; // Right array size

        int[] leftArr = new int[left];
        int[] rightArr = new int[right];

        System.arraycopy(arr, low, leftArr, 0, left); // Copy from low till left array size from src arr
        System.arraycopy(arr, mid+1, rightArr, 0, right); // Copy from mid+1 till right array size from src arr

        int k = low; // low is where the arr reshuffling will start
        int i = 0, j = 0; // i tracks left array, j tracks right array
        while (i < left && j < right) { // While both i and j are within the bounds
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy if anything remaining in the left array
        while (i < left) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy if anything remaining in the right array
        while (j < right) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,9};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}