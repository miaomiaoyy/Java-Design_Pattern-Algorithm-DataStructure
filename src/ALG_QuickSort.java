import java.util.Arrays;

public class ALG_QuickSort {
    public static void main(String[] args){
        int[] input = {13,19,9,5,12,8,7,4,11,2,6,21};
        quickSort(input, 0, input.length-1);
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int high = right;

        while(left < high){
            while(left < high && arr[left] < pivot){
                left++;
            }
            while(left < high && arr[high] >= pivot){
                high--;
            }
            swap(arr,left, high);
        }
        swap(arr, left, right);
        System.out.println( Arrays.toString(arr));
        return left;
    }

    public static void quickSort(int arr[], int left, int right) {
        if( left < right)
        {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index, right);
        }
    }




}
