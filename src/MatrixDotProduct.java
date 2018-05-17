public class MatrixDotProduct {
    public static int[][] dotProduct(int[][] A, int[][]B) {


        int m = A.length;
        int n = A[0].length;
        int t = B[0].length;
        int[][] C = new int[m][t];
        for(int i = 0; i < m; i++) {
            for (int k = 0; k < t; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
    return C;
    }

    public static void main(String[] args) {
        int[][] A = {{1,2},{3,4}};
        int[][] B = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] b : B) {
            System.out.println(b[0]);
            System.out.println(b[1]);
        }
//        for(int[] arr : dotProduct(A, B)) {
//            System.out.println("next line");
//            for(int i : arr) {
//                System.out.println(i);
//            }
//        }
    }


}
