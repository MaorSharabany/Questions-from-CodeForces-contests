/*
This is the easy version of the problem. The difference between the versions is that the easy version 
has no swap operations. You can make hacks only if all versions of the problem are solved.

Pikachu is a cute and friendly pokemon living in the wild pikachu herd.

But it has become known recently that infamous team R wanted to steal all these pokemon! 
Pokemon trainer Andrew decided to help Pikachu to build a pokemon army to resist.

First, Andrew counted all the pokemon — there were exactly n pikachu. The strength of the i-th pokemon 
is equal to ai, and all these numbers are distinct.

As an army, Andrew can choose any non-empty subsequence of pokemons. In other words, Andrew chooses some 
array b from k indices such that 1<=b1<b2<...<bk<=n, and his army will consist of pokemons with forces ab1,ab2,…,abk.

The strength of the army is equal to the alternating sum of elements of the subsequence; 
that is, ab1-ab2+ab3-ab4+….

Andrew is experimenting with pokemon order. He performs q operations. In i-th operation 
Andrew swaps li-th and ri-th pokemon.

Note: q=0 in this version of the task.

Andrew wants to know the maximal stregth of the army he can achieve with the initial pokemon placement. 
He also needs to know the maximal strength after each operation.

Help Andrew and the pokemon, or team R will realize their tricky plan!

Input
Each test contains multiple test cases.

The first line contains one positive integer t (1<=t<=103) denoting the number of test cases. 
Description of the test cases follows.

The first line of each test case contains two integers n and q (1<=n<=3*10^5,q=0) denoting the number 
of pokemon and number of operations respectively.

The second line contains n distinct positive integers a1,a2,…,an (1<=ai<=n) denoting the strengths of the pokemon.

i-th of the last q lines contains two positive integers li and ri (1<=li<=ri<=n) denoting the indices of 
pokemon that were swapped in the i-th operation.

It is guaranteed that the sum of n over all test cases does not exceed 3*10^5, and the sum of q over 
all test cases does not exceed 3*105.

Output
For each test case, print q+1 integers: the maximal strength of army before the swaps and after each swap.

Example input:
3
3 0
1 3 2
2 0
1 2
7 0
1 2 5 4 3 6 7

Example output:
3
2
9

time limit per test2 seconds
memory limit per test256 megabytes
 */

import java.util.*;

public class Pokemon1 {
	
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			int q = scanner.nextInt();  //Not in use for this Question
			
			int [] s = new int[n];
			
			for(int i = 0; i < n; i++) {
				s[i] = scanner.nextInt();
			}
			solve(s, n);
			t--;
		}
		
		scanner.close();
	}
	
	public static void solve(int[] s, int n) {
		
		long[] even = new long[n];
		long[] odd = new long[n];
		
		even[0] = 0;
		odd[0] = s[0];
		for(int i = 1; i < n; i++) {
			even[i] = Math.max(even[i-1], odd[i-1] - s[i]);
			odd[i] = Math.max(odd[i-1], even[i-1] + s[i]);
		}
		
		long maxVal = 0;
		for(int i = 0; i < n; i++) {
			long temp = Math.max(even[i], odd[i]);
			maxVal = Math.max(temp, maxVal);
		}
		System.out.println(maxVal);	
	}
}
