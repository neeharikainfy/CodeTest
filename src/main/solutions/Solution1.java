package main.solutions;

import java.util.Scanner;

public class Solution1 {
	private int[] countArray;

	public Solution1() {}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Solution1 solution = new Solution1();

		int testCases = scanner.nextInt();

		for (int testCase = 0; testCase < testCases; ++testCase) {

			int arraySize = scanner.nextInt();
			solution.initCountArray(2001);

			int target = scanner.nextInt();
			int[] inputArray = new int[arraySize];

			for (int i = 0; i < arraySize; ++i) {
				inputArray[i] = scanner.nextInt();
			}
			//Method to calculate the no of combinations to get sum nearest and equal to target sum
			solution.getNoOfCombForGivenTarget(inputArray, target);
		}
	}

	public void getNoOfCombForGivenTarget(int[] inputArray, int target) {

		for (int k = 1; k <= target; ++k) {
			for (int i = 0; i < inputArray.length; ++i) {
				calculateNoOfWays(inputArray[i], k);
			}
		}
		print(countArray[target]);
	}
	
	private void calculateNoOfWays(int element, int k) {
		if (element <= k) {		
			countArray[k] = Math.max(
					countArray[k],
				(element + countArray[k - element])
			);
		}
	}

	private void print(int element) {
		System.out.println("Output==="+Integer.toString(element));
	}
	
	public void initCountArray(int size) {
		countArray = new int[size];
		for (int i = 0; i < size; ++i) {
			countArray[i] = 0;
		}
	}
}
