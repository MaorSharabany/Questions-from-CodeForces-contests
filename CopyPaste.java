/*
 * BThero is a powerful magician. He has got n piles of candies, the i-th pile initially contains ai candies. 
 * BThero can cast a copy-paste spell as follows:

He chooses two piles (i,j) such that 1<=i,j<=n and i!=j.
All candies from pile i are copied into pile j. Formally, the operation aj:=aj+ai is performed.
BThero can cast this spell any number of times he wants to — but unfortunately, if some pile contains strictly 
more than k candies, he loses his magic power. What is the maximum number of times BThero can cast the spell 
without losing his power?

Input
The first line contains one integer T (1<=T<=500) — the number of test cases.

Each test case consists of two lines:

the first line contains two integers n and k (2<=n<=1000, 2<=k<=104);
the second line contains n integers a1, a2, ..., an (1<=ai<=k).
It is guaranteed that the sum of n over all test cases does not exceed 1000, and the sum of k over all 
test cases does not exceed 104.

Output
For each test case, print one integer — the maximum number of times BThero can cast the spell without losing 
his magic power.
 
Example input:
3
2 2
1 1
3 5
1 2 3
3 7
3 2 2

Example output:
1
5
4

time limit per test1 second
memory limit per test256 megabytes
 */

import java.util.*;

public class CopyPaste {
	
	public static void main(String[]args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		while(T>0) {
			
			int n = scanner.nextInt(); // 2<=n<=1000
			int k = scanner.nextInt(); // 2<=k<=10^4
			
			int [] pile = new int[n];
			
			for(int i = 0; i < n; i++) {
				pile[i] = scanner.nextInt();
			}
			
			System.out.println(solve(pile, n, k));
			
			T--;
		}
		
		scanner.close();
	}
	
	public static int solve(int[] pile, int n, int k) {
		
		int count = 0;
		
		int max;
		
		Arrays.sort(pile);
		
		for(int i = 0; i < pile.length-1; i++) {
			max = pile[0];
			int j = i+1;
			while(pile[j] + max <= k) {
				pile[j] += max;
				count++;
			}	         
		}
		return count;
	}
}
		
		
		

