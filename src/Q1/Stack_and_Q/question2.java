package Q1.Stack_and_Q;

import java.util.Scanner;

public class question2 {
	public static void main(String[] args)
    {
        char[] arr = new char[100];
        Scanner sc = new Scanner(System.in);
        arr = sc.nextLine().toCharArray();
        parenthesis(arr);
    }
	private static void parenthesis(char[] arr) {
		int que = 0;
		int stack = arr.length-1;
		int trueCount = 0;
		// TODO Auto-generated method stub
		for(int i = 0; i < arr.length/2; i++ ) {
			if(arr[stack] == arr[stack]) {
				trueCount++;
			}
			else {
				break;
			}
			que++;
			stack--;
		}
		if(trueCount == arr.length/2) 
			System.out.println("True");
		else 
			System.out.println("moon");
	}
}
