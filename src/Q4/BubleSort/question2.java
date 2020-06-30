package Q4.BubleSort;

import java.util.Scanner;
public class question2 {
	static int why = 0;
	public static void ascending(int[] arr) {
		int num;
		for(int i = 0; i< arr.length-1; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					num = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = num;
					why++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		ascending(arr);
		if(why == 0) {
			System.out.println("정렬이 필요하지 않습니다.");
		} else {
			for(int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
		}
	}
}
