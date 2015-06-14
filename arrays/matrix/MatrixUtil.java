package matrix;

class MatrixUtil {

	/*
	 * @param {int[][]} rect
	 */
	public static void fillMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = i * matrix[i].length + j + 1;
			}
		}
	}

	/*
	 * @param {int[][]} rect
	 * @param {int} column to nullify
	 */
	static void fillMatrixWithZeroedColumn(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == column) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = i * matrix[i].length + j + 1;
				}
			}
		}
	}

	/*
	 * Prints matrix with zeroes replace by whitespace.
	 * 
	 * @param {int[][]} rect
	 */
	public static void printMatrixZeroEmpty(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					System.out.printf("%3s", " ");
				} else {
					System.out.printf("%3d", matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	/*
	 * Prints matrix with zeroes replace by crosses.
	 * 
	 * @param {int[][]} rect
	 */
	public static void printMatrixZeroCross(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					System.out.printf("%3s", "x");
				} else {
					System.out.printf("%3d", matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	/*
	 * Prints matrix.
	 * 
	 * @param {int[][]} rect
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @param {int[][]} rect
	 * 
	 * Returns new rotated matrix without touching passed in.
	 */
	public static int[][] rotateMatrix(int[][] matrix) {
		int[][] rotated = newRotatedMatrixWithDimensionsAs(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				rotated[j][matrix.length - 1 - i] = matrix[i][j];
			}
		}
		return rotated;
	}

	static int[][] newMatrixWithDimensionsAs(int[][] matrix) {
		int[][] clone = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			clone[i] = new int[matrix[i].length];
		}
		return clone;
	}

	static int[][] newRotatedMatrixWithDimensionsAs(int[][] matrix) {
		int[][] clone = new int[matrix[0].length][];
		for (int i = 0; i < matrix[0].length; i++) {
			clone[i] = new int[matrix.length];
		}
		return clone;
	}

	/*
	 * @param {int[][]} matrix Square
	 */
	static void rotateInPlaceCounterClockWise(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = tmp;
			}
		}
	}

	/*
	 * Time complexity: O(n^2)
	 *
	 * @param {int[][]} matrix Square
	 */
	static void rotateInPlaceClockWise(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
	}

	/*
	 * @param {int[][]} matrix Square
	 */
	static void rotateAxisStepInPlace(int[][] matrix) {
		int i, j;

		j = 0;
		int tmp = matrix[0][j];
		for (i = 1; i < matrix.length; i++) {
			matrix[i - 1][j] = matrix[i][j];
		}	

		i = matrix.length - 1;
		for (j = 1; j < matrix.length; j++) {
			matrix[i][j - 1] = matrix[i][j];
		}

		j = matrix.length - 1;
		for (i = matrix.length - 1; i > 0; i--) {
			matrix[i][j] = matrix[i - 1][j];
		}

		i = 0;
		for (j = matrix.length - 1; j > 0; j--) {
			matrix[i][j] = matrix[i][j - 1];
		}

		matrix[0][1] = tmp;
	}
}