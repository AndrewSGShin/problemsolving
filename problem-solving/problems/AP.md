Task: find the missing term in an Arithmetic Progression. Exactly one term is missing.

Input format: 
- Integer: number of terms
- List of integers: terms of AP

Output format: 
- Integer: the missing term

------------------------------------------

The diameter of a tree is the number of nodes on the longest path between the two leaves in the tree.

Note that the diameter of a tree T is the largest of the following quantities:
- the diameter of left subtree of T
- the diameter of right subtree of T
- the longest path between leaves that goes through the root of T


-----------------------------------------

Complete the function `getNumberOfPrimes` which takes in an integer `N` as its parameter to return the number of prime numbers that are less than `N`.

-------------------------------------


Which of the following sorting algorithms has the best asymptotic runtime complexity:
- Bubble Sort
- Heap Sort
- Selection Sort
- Insertion Sort

------------------------

Frient Circles (Coding) (Graph search algorithms must be used)

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature, i.e. if A is friend of B and B is friend of C then A is friend of C. A friend circle is a group of students who are directly or indirectly friends.

You have to complete a function `int friendCircles(String[] friends)` which returns the number of friend circles in a class. Its argument `friends` is a NxN matrix which consists of characters `Y` or `N`. If `friends[i][j] == 'Y'`, then ith and jth students are friends with each other, otherwise not. You have to return the total number of friend circles in the class. 

Constraints:
- 1 <= N <= 300
- Each element of matrix `friends` will be 'Y' or 'N'
- Number of rows and columns will be equal in `friends`
- `friends[i][i] = 'Y'`, where 0 <= i < N
- `friends[i][j] = friends[j][i]` where 0 <= i < j < N

/*
 * Complete the function below.
 */

    static int friendCircles(String[] friends) {
        boolean[] visited = new boolean[friends.length];
        int count = 0;
        int found = 0;
        for (int i = 0; i < friends.length && found < friends.length; i++, count++) {
            found++;
            found += depthFirstSearch(i, friends, visited);
        }
        return count;
    }

    static int depthFirstSearch(int i, String[] friends, boolean[] visited) {
        visited[i] = true;
        int found = 0;
        String connections = friends[i];
        for (int j = 0; j < connections.length(); j++) {
            if ('Y' == connections.charAt(j) && !visited[j]) {
                found++;
                System.out.println(i + "  " + j);
                found += depthFirstSearch(j, friends, visited);
            }
        }
        return found;
    }

public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _friends_size = Integer.parseInt(in.nextLine());
        String[] _friends = new String[_friends_size];
        String _friends_item;
        for(int _friends_i = 0; _friends_i < _friends_size; _friends_i++) {
            try {
                _friends_item = in.nextLine();
            } catch (Exception e) {
                _friends_item = null;
            }
            _friends[_friends_i] = _friends_item;
        }
        
        res = friendCircles(_friends);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
}

----------------------------------------------------------------------------

List Max (try only keeping track of the start and top points)

You are given a list of size N, initialized with zeroes. You have to perform M operations on the list and output the maximum final values of all the N elements in the list. For every operation you are given three integers a, b and k. The value k need to be added to all the elements ranging from index a through b (both inclusive).

Input format:
The first line will contain two integers N and M separated by a single space.
The next M lines will each contain three integers a, b and k separated spaces.
The numbers in the list are numbered from 1 to N.

Output format: 
A single integer on a separate line containing the maximum value in the list after all operations are completed.

Constraints:
3 <= N <= 10,000,000
1 <= M <= 200,000
1 <= a <= b <= N
0 <= k 	<= 10**9

--------------------------------------

Number of paths in a matrix (remember to modulo at each point than just at the end, try dynamic programming)

You a given a 2-dimensional array with M rows and N columns. You are initially positioned at (0,0) which is the top left cell in the array. You are allowed to move either right or downwards. The array is filled with 1 and 0. A 1 indicates that you can move through that cell, a 0 indicates that you cannot move through that cell. Given a function `numberOfPaths` which takes in the above 2-D array, return the number of paths from the top left corner to the bottom right, i.e. from (0,0) to (M-1,N-1).

Your task is to complete the body of the function and return a single integer denoting number of paths mentioned above. Since the answer can be large, you have to return the number of paths modulo 1,000,000,007

constraints
1 <= N, M <= 1000 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution {

static int numberOfPaths(int [][]a,int M,int N) {
    return step(a, 0, 0, M, N);
}

static int step(int[][] a, int i, int j, int M, int N) {
    if (i == M-1 && j == N-1) {
        return 1;
    }
    
    int count = 0;
    if (i < M-1 && a[i+1][j] != 0) {
        count += step(a, i+1, j, M, N);
    }
    
    if (j < N-1 && a[i][j+1] != 0) {
        count += step(a, i, j+1, M, N);
    }
    return count % 1000000007;
}

public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		int _a_cnt = 0,_b_cnt = 0;
		int [][] _a = new int[1001][1001];
		try {
			_a_cnt = sc.nextInt();
			_b_cnt = sc.nextInt();
		}catch (Exception e) {
			 System.out.println("Here: " + e.getMessage()); 
		} 

		for(int i=0; i < _a_cnt; i++) {
			for( int j = 0;j < _b_cnt;j++ ){
				int _a_tmp = 0;
				try {
					_a_tmp = sc.nextInt();
				}catch (Exception e) { }
				_a[i][j] = _a_tmp;
			}			
		}
		System.out.println(numberOfPaths (_a ,_a_cnt,_b_cnt));

	}
}