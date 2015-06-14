package matrix;

import static matrix.MatrixUtil.*;


class MatrixRotation {
	
	public static void main(String... args) {
		int[][] matrix = new int[3][5];
		
		fillMatrixWithZeroedColumn(matrix, 2);
		System.out.println("Original:");
		printMatrixZeroEmpty(matrix); 

		System.out.println();
		int[][] rotated90 = rotateMatrix(matrix);
		System.out.println("Rotated 90 degrees:");
		printMatrix(rotated90);

		System.out.println();
		int[][] rotated180 = rotateMatrix(rotated90);
		System.out.println("Rotated 180 degrees:");
		printMatrix(rotated180);

		System.out.println();
		int[][] rotated270 = rotateMatrix(rotated180);
		System.out.println("Rotated 270 degrees:");
		printMatrix(rotated270);

	}
}