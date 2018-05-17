import java.io.*;
import java.util.*;

class pancakeSort {

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        // https://www.youtube.com/watch?v=kk-_DDgoXfk
        for(int i = arr.length ; i > 0; i--) {
            int target = findMax(arr, i);
            flip(arr, target);
            flip(arr, i - 1);
        }
        return arr;
    }

    static int findMax(int[] arr, int k) {
        //int max = arr[0];
        int pos = 0;
        for(int i = 0; i < k; i++){
            if(arr[pos] < arr[i]) {
                //max = arr[i];
                pos = i;
                //System.out.println(pos);
            }
        }
        return pos;
    }
    //[1,5,4,3,2] => [5,1,4,3,2] => [2,3,4,1,5] => [4,3,2,1,5] =>
    static private int[] flip(int[] arr, int k) {
        if(k > arr.length) {
            return arr;
        } else {
            int start = 0, end = k;
            while(start < end) {
                swap(arr, start++, end--);
            }
            return arr;
        }
    }
    static private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2};
        //arr = flip(arr, 3); // 4, 5, 1, 3, 2
        //System.out.println(Arrays.toString(arr));

        int[] res = pancakeSort(arr);
        System.out.println(Arrays.toString(res));
    }

}