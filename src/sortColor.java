public class sortColor {

    public static void sortColor(int[] colors) {
        int left = 0, right = colors.length - 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (left < right) {
            for (int i = 0; i < colors.length; i++) {

                min = Math.min(min, colors[i]);
                max = Math.max(max, colors[i]);
            }

            sortColorHelper(colors, left, right);
        }
    }

    private static void sortColorHelper(int[] nums, int start, int end) {
        int firstIndexNonZero = start, firstIndexNonTwo = end;
        for (int i = 0; i <= firstIndexNonTwo; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[firstIndexNonZero];
                nums[firstIndexNonZero] = 0;
                firstIndexNonZero++;
            } else if (nums[i] == 2) {
                nums[i] = nums[firstIndexNonTwo];
                nums[firstIndexNonTwo] = 2;
                firstIndexNonTwo--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] color = new int[]{1, 2, 3, 2, 3, 5, 4, 2, 1, 3, 6, 4, 3, 5, 2, 4, 3};
        sortColor(color);
    }
}


