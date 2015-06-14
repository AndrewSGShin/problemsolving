package matrix;
import java.util.Arrays;

import static matrix.MatrixUtil.*;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */

class MatrixNullifyIntersections {

	public static void main(String... args) {
		int m = 6;
		int n = 7;
		int[][] matrix = new int[m][n];
		fillMatrix(matrix);
		matrix[0][0] = 0;
		matrix[3][2] = 0;
		System.out.println("Original: ");
		printMatrixZeroCross(matrix);

		setZeroes(matrix);
		System.out.println("\nNullified: ");
		printMatrixZeroCross(matrix);
	}

	// Time complexity: O(2M*N)
	// Space complexity: O(M + N)
	static void setZeroes(int[][] matrix) {
		boolean[] zeroRows = new boolean[matrix.length];
		boolean[] zeroCols = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (zeroRows[i] || zeroCols[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}