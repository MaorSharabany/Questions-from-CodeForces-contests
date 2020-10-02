/*
You are given a non-decreasing array of non-negative integers a1,a2,…,an. Also you are given a positive integer k.

You want to find m non-decreasing arrays of non-negative integers b1,b2,…,bm, such that:

The size of bi is equal to n for all 1<=i<=m.
For all 1<=j<=n, aj=b1,j+b2,j+…+bm,j. In the other word, array a is the sum of arrays bi.
The number of different elements in the array bi is at most k for all 1<=i<=m.
Find the minimum possible value of m, or report that there is no possible m.

Input
The first line contains one integer t (1<=t<=100): the number of test cases.

The first line of each test case contains two integers n, k (1<=n<=100, 1<=k<=n).

The second line contains n integers a1,a2,…,an (0<=a1<=a2<=…<=an<=100, an>0).

Output
For each test case print a single integer: the minimum possible value of m. If there is no such m, print -1.

Example input:
6
4 1
0 0 0 1
3 1
3 3 3
11 3
0 1 2 2 3 3 3 4 4 4 4
5 3
1 2 3 4 5
9 4
2 2 3 5 7 11 13 13 17
10 7
0 1 1 2 3 3 4 5 5 6

Example output:
-1
1
2
2
2
1

time limit per test1 second
memory limit per test256 megabytes
 */

import java.util.*;

public class Arrays {
	
	public static void main(String[]args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			
			int [] nums = new int[n];
			
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt(); //non decreasing
			}
			
			System.out.println(solve(nums,k,n));
			
			t--;
		}
		
		scanner.close();
		
	}
	
	public static int solve(int[] nums, int k, int n) {
		
		if(k == 1) {
			for(int i = 1; i < n; i++) {
				if(nums[i-1] != nums[i]) return -1;
			}
		}
			
		int maxNum = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] != nums[i]) maxNum++;
		}
		
		int count = 0;
		
		
		if(k >= maxNum) return 1;

		int s = k;
		int j = 0;
		
		while(j < nums.length) {
			while(s > 0 && j < nums.length) {
				while(j < nums.length - 1 && nums[j] ==nums[j+1]) {
					nums[j] = 0;
					j++;
				}
				s--;
				nums[j] = 0;
				j++;
			}
			count++;
			s = k-1;
		}				
		return count;
	}
}
