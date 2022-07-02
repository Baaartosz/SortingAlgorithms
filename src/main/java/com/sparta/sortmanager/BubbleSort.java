package com.sparta.sortmanager;

public class BubbleSort implements Sorter { /// Implement a Timer interface or extend Timer?

    /**
     * The Simplest sorting algorithm that works by repeatedly
     * swapping the adjacent elements if they are in wrong order.
     *
     * Time Complexity  -> O(n^2)
     * Space Complexity -> O(1)
     *
     * @param   array an array of integers sorted or unsorted.
     * @return        sorted array of integers.
     */
    public int[] sortArray(int[] array){
        if(array == null) return new int[] {};

        for (int outer = 0; outer < array.length - 1; outer++) {
            boolean swapped = false;

            for (int inner = 0; inner < array.length - 1; inner++) {
                if(array[inner + 1] < array[inner]){
                    int swap = array[inner];
                    array[inner] = array[inner + 1];
                    array[inner + 1] = swap;

                    swapped = true;
                }
            }

            // No swapping is occurring, we can break out of the loop.
            if (!swapped)
                break;
        }
        return array;
    }

}
