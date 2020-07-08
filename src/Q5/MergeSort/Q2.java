package Q5.MergeSort;

import java.util.Scanner;

public class Q2 {

	static char userInputData[] = null;
	static char sortData[] = null;
	static int lastIndex;
	
	public static void mergeSorting(int startIndex, int middleIndex, int endIndex) {
		char buff[] = new char[endIndex - startIndex + 1];
		int checkLeft = startIndex;
		int checkRight = middleIndex + 1;
		int buffIndex = 0;
		for (int i = 0; i <endIndex - startIndex + 1; i++) {
			if (checkLeft > middleIndex) {
				for(int j = checkRight; j < endIndex + 1; j++) {
					buff[buffIndex++] = sortData[j];
				}
				break;
			}else if (checkRight > endIndex){
				for(int j = checkLeft; j < middleIndex + 1; j++) {
					buff[buffIndex++] = sortData[j];
				}
				break;
			}
			int right = sortData[checkRight];
			int left = sortData[checkLeft];
			if(left < right) {
				buff[buffIndex++] = sortData[checkLeft++];
			} else if (left == right) {
				buff[buffIndex++] = sortData[checkLeft++];
				buff[buffIndex++] = sortData[checkRight++];
				if(checkLeft > middleIndex && checkRight > endIndex) {
					break;
				}
			} else {
				buff[buffIndex++] = sortData[checkRight++];
			}
		}
		for(int i = startIndex, j = 0; i < endIndex + 1; i++, j++) {
			sortData[i] = buff[j];
		}
		return;
	}
	
	public static void divideList(int startIndex, int endIndex) {
		if(startIndex == endIndex) {
			return;
		} else {
			int middleIndex = (startIndex + endIndex) / 2;
			divideList(startIndex, middleIndex);
			divideList(middleIndex + 1, endIndex);
			mergeSorting(startIndex, middleIndex, endIndex);
			return;
		}
	}
	
	public static void printing() {
		for(int i = 0; i < lastIndex; i++) {
			System.out.print(userInputData[i]);
		}
		System.out.print(" -> ");
		for(int i = 0; i < lastIndex; i++) {
			System.out.print(sortData[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		lastIndex = scanner.nextInt();
		userInputData = new char[lastIndex];
		sortData = new char[lastIndex];
		
		for(int i = 0; i < lastIndex; i++) {
			userInputData[i] = scanner.next().charAt(0);
			sortData[i] = userInputData[i];
		}
		
		divideList(0, lastIndex - 1);
		printing();
		
		scanner.close();
	}
}
