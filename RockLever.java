/*
Danik urgently needs rock and lever! Obviously, the easiest way to get these things is to ask Hermit Lizard 
for them.

Hermit Lizard agreed to give Danik the lever. But to get a stone, Danik needs to solve the following task.

You are given a positive integer n, and an array a of positive integers. The task is to calculate the number
of such pairs (i,j) that i<j and ai&aj >= ai^aj, where & denotes the bitwise AND operation, and
 ^ denotes the bitwise XOR operation.

Danik has solved this task. But can you solve it?

Input
Each test contains multiple test cases.

The first line contains one positive integer t (1<=t<=10) denoting the number of test cases. 
Description of the test cases follows.

The first line of each test case contains one positive integer n (1<=n<=105) — length of the array.

The second line contains n positive integers ai (1<=ai<=109) — elements of the array.

It is guaranteed that the sum of n over all test cases does not exceed 105.

Output
For every test case print one non-negative integer — the answer to the problem

Example input:
5
5
1 4 3 7 10
3
1 1 1
4
6 2 5 3
2
2 4
1
1

Example output:
1
3
2
0
0

time limit per test1 second
memory limit per test256 megabytes
 */

import java.util.*;

public class RockLever {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			int[] arr = new int[n];
			
			for(int i = 0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			
			System.out.println(solve(arr, n));
			
			t--;
		}
		
		scanner.close();
	}
	
	public static long solve(int[] arr, int n) {
		
		long countE = 0, m = 1;
		long [] count = new long [n];
		
		for(int i = 0; i < n; i++) {
			while(arr[i] > 0) {
				arr[i] /= 2;
				count[i]++;
			}
		}
		
		Arrays.sort(count); 
		
		for(int i = 1; i < n; i++) { 
			if(count[i] == count[i-1]) m++;
			else {
				countE += m*(m-1)/2;
				m = 1;
			}
		}
		
		if(m>1) countE += m*(m-1)/2;

		return countE;
	}

}
