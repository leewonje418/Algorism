package Q5.MergeSort;

import java.util.Scanner;

public class Q1 {

	static int userInputData[] = null;
	static int sortData[] = null;
	static int lastIndex;
	static int moveCheck = 0;
	static int nowIndex;
	
	public static void mergeSorting(int startIndex, int middleIndex, int endIndex) {
		int buff[] = new int[endIndex - startIndex + 1];
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
			} else {
				buff[buffIndex++] = sortData[checkRight++];
			}
		}
		for(int i = 0; i < endIndex - startIndex + 1; i++) {
			if(sortData[nowIndex] == buff[i] && nowIndex != i + startIndex) {
				moveCheck++;
				nowIndex = i + startIndex;
				break;
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
		System.out.println();
		for(int i = 0; i < lastIndex; i++) {
			System.out.print(userInputData[i] + " ");
		}
		System.out.print(" -> ");
		for(int i = 0; i < lastIndex; i++) {
			System.out.print(sortData[i] + " ");
		}
		System.out.println("\n" + moveCheck);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		lastIndex = scanner.nextInt();
		userInputData = new int[lastIndex];
		sortData = new int[lastIndex];
		
		for(int i = 0; i < lastIndex; i++) {
			int inputNum = scanner.nextInt();
			for(int j = 0; j < i; j++) {
				if(userInputData[j] == inputNum) {
					i--;
					continue;
				}
			}
			userInputData[i] = inputNum;
			sortData[i] = userInputData[i];
		}
		
		do {
			nowIndex = scanner.nextInt();
		}while(!(0 <= nowIndex && nowIndex < lastIndex));
		
		divideList(0, lastIndex - 1);
		printing();
		
		scanner.close();
	}
}
