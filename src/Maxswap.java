import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Maxswap {

    int id = 0;
    int maxid = 0;

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] arr = numStr.toCharArray();


        for(; id < arr.length; id++) {
            //int pre = id;
            findMax(arr.length - 1, id, arr);
            if(id != maxid && arr[id] != arr[maxid]) {
                swap(id, maxid, arr);
                break;
            }
        }

        return Integer.valueOf(String.valueOf(arr));
    }

    private void findMax(int end, int start, char[] arr) {
        char max = Character.MIN_VALUE;
        for(int i = end; i >= start; i--) {

            if(arr[i] > max) {
                max = arr[i];
                maxid = i;
            }
        }
    }
    private void swap(int id, int i, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[id];
        arr[id] = tmp;
    }


    public int maximumSwap2(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            // get the last index for digit from 0 to 9. If the digit is not in num, the index will be 0.
            last[A[i] - '0'] = i;
        }
        // check each digit in num
        for (int i = 0; i < A.length; i++) {
            // compare with digit from 9 to 0
            for (int d = 9; d > A[i] - '0'; d--) {
                // since i>=0, last[d] has to be larger than 0 to make the if condition true
                if (last[d] > i) {
                    swap(A, last[d], i);
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
    private void swap(char[] A, int a, int b) {
        char tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }



        public int maximumSwap3(int num) {
            String s = num + "";
            char[] arr = s.toCharArray();

            int[] bucket = new int[10];
            for(int i = 0; i < arr.length; i++) {
                bucket[arr[i] - '0'] = i; //bucket[7] = 1, bucket[2] = 0
            }// 0 1 2 3 ... 9

            for(int j = 0; j < arr.length; j++) {
                for(int i = 9; i > arr[j] - '0'; i--) {
                    if(bucket[i] > j) {
                        swap(arr, bucket[i], j);
                        break;
                    }
                }
            }
            return Integer.valueOf(new String(arr));
        }




    public static void main(String[] args) {
        Maxswap s = new Maxswap();
        System.out.print(s.maximumSwap3(89368));
        char[] c = {'c', 'a', 'r'};
        String s1 = String.valueOf(c);
        String s2 = c.toString();
        System.out.println(s1 + s2);
    }
}




