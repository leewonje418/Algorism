package Q2.BFS_DFS;

import java.util.Scanner;
import java.util.Stack;

public class question1 {
	static int[][] map;
	static boolean[] visit;
	static int n, m, v;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ ���� / ������ ���� / Ž���� ������ ������ ��ȣ");
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		
		int num1, num2;
		
		for (int i = 1; i <= m; i++) {
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			map[num1][num2] = map[num2][num1] = 1;
		}
		
		dfs(v);
	}
	public static void dfs(int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		int p;
		boolean flag;
		
		visit[v] = true;
		System.out.print(v + " ");
		
		while(!stack.isEmpty()) {
			p = stack.peek();
			flag = false;
			
			for(int i = 1; i < n + 1; i++) {
				if(map[p][i] == 1 && !visit[i]) {
					stack.push(i);
					visit[i] = true;
					System.out.print(i + " ");
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
			}
		}
	}
}