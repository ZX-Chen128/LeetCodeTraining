package Algorithms.BasicAlgorithms.Sorts;

import java.util.Arrays;

/**
 * 平均时间复杂度：O(N^2)
 * 最好时间复杂度：O(N^2)
 * 最坏时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 */

public class SelectSort {
    public int[] selectSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            if(index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectSort s = new SelectSort();
        int[] result = s.selectSort(new int[]{2,14,44,8,5});
        System.out.println(Arrays.toString(result));
    }
}
