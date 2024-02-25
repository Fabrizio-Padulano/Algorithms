package org.padulano.fabrizio.algorithms.binarysearch;

public class BinarySearch2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;

        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = (ROWS * COLS) - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int el = matrix[m / COLS][m % COLS];
            if (el == target) return true;

            if (el > target) {
                r = m - 1;
            } else l = m + 1;

        }

        return false;
    }
}
