package matrix;

import static matrix.MatrixUtil.*;

/*

Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees in place.

*/

class SquareMatrixRotation {
	
	public static void main(String... args) {
		int[][] matrix = new int[5][5];
		
		fillMatrix(matrix);
		System.out.println("Original:");
		printMatrix(matrix); 

		// System.out.println();
		// rotateAxisStepInPlace(matrix);
		// System.out.println("Outer axis rotated 1 step:");
		// printMatrix(matrix);

		fillMatrix(matrix);
		System.out.println();
		rotateInPlaceCounterClockWise(matrix);
		System.out.println("Matrix is rotated in place counter clock:");
		printMatrix(matrix);

		fillMatrix(matrix);
		System.out.println();
		rotateInPlaceClockWise(matrix);
		System.out.println("Matrix is rotated in place clock wise:");
		printMatrix(matrix);
	}

}