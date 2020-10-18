/*In order to celebrate Twice's 5th anniversary, Tzuyu and Sana decided to play a game.

Tzuyu gave Sana two integers a and b and a really important quest.

In order to complete the quest, Sana has to output the smallest possible value of (a^x) + (b^x) for any given x, 
where ^ denotes the bitwise XOR operation.

Input
Each test contains multiple test cases. The first line contains the number of test cases t (1<=t<=104). 
Description of the test cases follows.

The only line of each test case contains two integers a and b (1<=a,b<=109).

Output
For each testcase, output the smallest possible value of the given expression.

Example input:
6
6 12
4 9
59 832
28 14
4925 2912
1 1

Example output:
10
13
891
18
6237
0



time limit per test1 second
memory limit per test256 megabytes */

import java.util.*;

public class XOR {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(solve(a,b));
			
			t--;
		}
		scanner.close();		
	}
	
	public static int solve(int a, int b) {
		
		if((a&b) == 0) return a+b;
		
		if((a&b) > 0) return (a^b);
		
		return 0;
	}		
}