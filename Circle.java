/*
You are given three sequences: a1,a2,…,an; b1,b2,…,bn; c1,c2,…,cn.

For each i, ai!=bi, ai!=ci, bi!=ci.

Find a sequence p1,p2,…,pn, that satisfy the following conditions:

pi = ai or bi or ci
pi!=p(imodn)+1.
In other words, for each element, you need to choose one of the three possible values, 
such that no two adjacent elements (where we consider elements i,i+1 adjacent for i<n and also 
elements 1 and n) will have equal value.

It can be proved that in the given constraints solution always exists. You don't need to minimize/maximize 
anything, you need to find any proper sequence.

Input
The first line of input contains one integer t (1<=t<=100): the number of test cases.

The first line of each test case contains one integer n (3<=n<=100): the number of elements in the given sequences.

The second line contains n integers a1,a2,…,an (1<=ai<=100).

The third line contains n integers b1,b2,…,bn (1<=bi<=100).

The fourth line contains n integers c1,c2,…,cn (1<=ci<=100).

It is guaranteed that ai!=bi, ai!=ci, bi!=ci for all i.

Output
For each test case, print n integers: p1,p2,…,pn (pi = {ai or bi or ci}, pi != pi%n+1).

If there are several solutions, you can print any.

Example input:
5
3
1 1 1
2 2 2
3 3 3
4
1 2 1 2
2 1 2 1
3 4 3 4
7
1 3 3 1 1 1 1
2 4 4 3 2 2 4
4 2 2 2 4 4 2
3
1 2 1
2 3 3
3 1 2
10
1 1 1 2 2 2 3 3 3 1
2 2 2 3 3 3 1 1 1 2
3 3 3 1 1 1 2 2 2 3

Example output:
1 2 3
1 2 1 2
1 3 4 3 2 4 2
1 3 2
1 2 3 1 2 3 1 2 3 2

time limit per test1 second
memory limit per test256 megabytes
 */

import java.util.*;

public class Circle {
	
	public static void main(String[]args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < n; i++) {
				b[i] = scanner.nextInt();
			}
			for(int i = 0; i < n; i++) {
				c[i] = scanner.nextInt();
			}
			
			solve(a,b,c,n);
			System.out.println();
			
			t--;
		}
		
		scanner.close();
	}
	
	public static void solve(int[] a, int[] b, int[] c, int n) {
		
		int []p = new int[n];
		p[0] = a[0];
		
		for(int i = 1; i < n; i++) {
			if(i < n-1) {
				if(p[i-1] != a[i]) {
					p[i] = a[i];
					continue;
				}else if(p[i-1] != b[i]) {
					p[i] = b[i];
					continue;
				}else {
					p[i] = c[i];	
				}
			}else {
				if(p[i-1] != a[i] && a[i] != p[0]) p[i] = a[i];
				else if(p[i-1] != b[i] && b[i] != p[0]) p[i] = b[i];
				else p[i] = c[i];
			}
		}
		
		for(int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}	
	}
}
