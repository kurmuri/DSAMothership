package org.shandilya.recursion;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = findPivot(arr, low, high); // Find pivot
            quickSort(arr, low, pivot-1); // Call qs from low to pivot - 1
            quickSort(arr, pivot+1, high); // Call qs from pivot + 1 to high
        }
    }

    // Returns pivot position and arranges the array internally by swapping
    private static int findPivot(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        // While low is less than high
        while (i < j) {
            // While element at index is less than equal to the pivot element, keep on increasing the index
            while (arr[i] <= pivot && i < high) {
                i++;
            }

            // While the element at index is more than the pivot element, keep on decreasing the index
            while (arr[j] > pivot && j > low) {
                j--;
            }
            // If i is less than j, swap the elements at the position
            if (i < j)
                swap(arr, i, j);
        }
        // Swap the element at low with element at J
        // Essentially, find the exact position where chosen pivot element needs to be placed
        swap(arr, low, j);
        return j; // This is the position where chosen pivot has been placed, rightfully, and this position is returned as position for further split
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,1,9};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
