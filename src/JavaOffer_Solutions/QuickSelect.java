package JavaOffer_Solutions;

import com.sun.tools.internal.xjc.reader.gbind.Graph;
public class QuickSelect{






//    [2,4,1,5,3]. 3
//    [1,4,2]
//    [1,2,3, 4, 5]

        public static int[] quickselect(int[] arr, int start, int end) {
            if(start < end) return new int[] {};
            int pivot = partition(arr, start ,end );
            //int mid = (0 + arr.length)/2;
            quickselect(arr, start, pivot);
            quickselect(arr, pivot + 1, end);
            return arr;
        }
        public static int partition(int[] arr, int start, int end) {
            int pivot = arr[arr.length - 1];
            int id = start - 1;
            for(int i = start; i < end; i++) {
                if(arr[i] < pivot) {
                    swap(arr, id + 1, i);
                }
                id++;
                swap(arr, id + 1, arr.length - 1);
            }
            return id + 1;
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            // write your code here
            //System.out.println("Hello World!");
            int[] arr = new int[] {2,3,1,4,6};
            partition(arr, 0, arr.length - 1);
            for(int i : quickselect(arr, 0, arr.length - 1)) {
                System.out.print(i);
            }
        }
    }



