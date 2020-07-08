package Q5.MergeSort;

public class Basics {

	static int userInputData[] = new int[10];
	static int sortData[] = new int[10];
	static int lastIndex = 10;
	
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
	}
	
	public static void main(String[] args) {
		
		userInputData[0] = 1;
		userInputData[1] = 10;
		userInputData[2] = 9;
		userInputData[3] = 7;
		userInputData[4] = 6;
		userInputData[5] = 4;
		userInputData[6] = 8;
		userInputData[7] = 5;
		userInputData[8] = 2;
		userInputData[9] = 3;
		
		sortData[0] = 1;
		sortData[1] = 10;
		sortData[2] = 9;
		sortData[3] = 7;
		sortData[4] = 6;
		sortData[5] = 4;
		sortData[6] = 8;
		sortData[7] = 5;
		sortData[8] = 2;
		sortData[9] = 3;
		
		divideList(0, lastIndex - 1);
		printing();
	}
}