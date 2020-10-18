/*Pink Floyd are pulling a prank on Roger Waters. They know he doesn't like walls, he wants to 
be able to walk freely, so they are blocking him from exiting his room which can be seen as a grid.

Roger Waters has a square grid of size nªn and he wants to traverse his grid from the upper left (1,1) 
corner to the lower right corner (n,n). Waters can move from a square to any other square adjacent by a side, 
as long as he is still in the grid. Also except for the cells (1,1) and (n,n) every cell has a value 0 or 1 in it.

Before starting his traversal he will pick either a 0 or a 1 and will be able to only go to cells values in which 
are equal to the digit he chose. The starting and finishing cells (1,1) and (n,n) are exempt from this rule, 
he may go through them regardless of picked digit. Because of this the cell (1,1) takes value the letter 'S' 
and the cell (n,n) takes value the letter 'F'.

For example, in the first example test case, he can go from (1,1) to (n,n) by using the zeroes on this path: 
	(1,1), (2,1), (2,2), (2,3), (3,3), (3,4), (4,4)

The rest of the band (Pink Floyd) wants Waters to not be able to do his traversal, so while he is not looking 
they will invert at most two cells in the grid (from 0 to 1 or vice versa). They are afraid they will not be 
quick enough and asked for your help in choosing the cells. Note that you cannot invert cells (1,1) and (n,n).

We can show that there always exists a solution for the given constraints.

Also note that Waters will pick his digit of the traversal after the band has changed his grid, so he must not 
be able to reach (n,n) no matter what digit he picks.

Input
Each test contains multiple test cases. The first line contains the number of test cases t (1<=t<=50). 
Description of the test cases follows.

The first line of each test case contains one integers n (3<=n<=200).

The following n lines of each test case contain the binary grid, square (1,1) being colored in 'S' and 
square (n,n) being colored in 'F'.

The sum of values of n doesn't exceed 200.

Output
For each test case output on the first line an integer c (0<=c<=2)  — the number of inverted cells.

In i-th of the following c lines, print the coordinates of the i-th cell you inverted. You may not invert 
the same cell twice. Note that you cannot invert cells (1,1) and (n,n).

Example input:
3
4
S010
0001
1000
111F
3
S10
101
01F
5
S0101
00000
01111
11111
0001F

Example putput:
3
4
S010
0001
1000
111F
3
S10
101
01F
5
S0101
00000
01111
11111
0001F

time limit per test1 second
memory limit per test256 megabytes*/


import java.util.*;

public class PuttingBricksInTheWall {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while(t>0) {
			
			int n = scanner.nextInt();
			
			char [][] grid = new char [n+1][n+1];
			
			String s;
			int k = 0;
			
			for(int i = 1; i <= n; i++) {	
				s = scanner.next();			
				for(int j = 1; j <= n; j++) {
					grid[i][j] = s.charAt(k);
					k++;
				}
				k = 0;		
			}
			
			solve(grid, n);
			
			t--;		
		}
		scanner.close();
	}
	
	public static void solve(char[][] grid, int n) {
		
		int c = 0;
		
		String s1 = "";
		String s2 = "";
		
		char a = grid[1][2];
		char b = grid[2][1];
		char d = grid[n-1][n];
		char e = grid[n][n-1];
		
		if(a == b) {
			if (a == '0') {
				if(d != '1') {
					d = '1'; 
					c++;
					s1 += (n-1) + " " + n; 
				}
				if(e != '1') {
					e = '1';
					c++;
					s2 += n + " " + (n-1);
				}			
			}else {				
				if(d != '0') {
					d = '0'; 
					c++;
					s1 += (n-1) + " " + n; 
				}
				if(e != '0') {
					e = '0';
					c++;
					s2 += n + " " + (n-1);					
				}		
			}
		}else {
			if(a == d && d == '1') { // b= 0
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if (e != d) {
					e = d;
					c++;
					s2 += n + " " + (n-1);	
				}	
			}else if(a == d && d == '0') { // b =1
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					e = d;
					c++;
					s2 += n + " " + (n-1);	
				}		
			}else if(a == e && e == '1') { // b = 0
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}					
			}else if(a == e && e == '0') { // b = 1
				a = b;
				c++;
				s1 += 1 + " " + 2;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}
				
			}else if(b == e && e == '0') { // a = 1
				b = a;
				c++;
				s1 += 2 + " " + 1;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}
			
			}else if(b == e && e == '1') { // a = 0
				b = a;
				c++;
				s1 += 2 + " " + 1;
				
				if(e != d) {
					d = e;
					c++;
					s2 += (n-1) + " " + n;
				}				
			}						
		}		
		System.out.println(c);
		if(s1 != null) System.out.println(s1);
		if(s2 != null) System.out.println(s2);
		System.out.println();		
	}
}
