package main.solutions;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution2 {
	
	private static Scanner scanner;

    /**
    * @param args
     * @throws IOException 
    */
    public static void main(String[] args) throws IOException {
    	//Output of the program get save in the file testout.txt
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\testout.txt"));
           scanner = new Scanner(System.in);
           int testCases = scanner.nextInt();
           for (int i = 0; i < testCases; i++) {
                   int arraySize = scanner.nextInt();
                   int targetSum = scanner.nextInt();
                   HashSet<Integer> hashSet = new HashSet<Integer>();
                   for (int j = 0; j < arraySize; j++) {
                	   hashSet.add(scanner.nextInt());
                   }
                   //Method to calculate the no of combinations to get sum nearest and equal to target sum
                   int result=getNoOfCombForGivenTarget(hashSet, targetSum);
                   bufferedWriter.write(String.valueOf(result));
                   bufferedWriter.newLine();
           }
           bufferedWriter.close();
           scanner.close();
    }

    static int getNoOfCombForGivenTarget(HashSet<Integer> hashSet, int targetSum) {
           Iterator<Integer> it = hashSet.iterator();
           boolean[] count = new boolean[targetSum + 1];
           Arrays.fill(count, false);
           count[0] = true;
           int a = 0;
           for (int i = 0; i <= targetSum; i++) {
                   if (count[i] == true) {
                           it = hashSet.iterator();
                           while (it.hasNext()) {
                                  a = it.next();
                                  if ((i + a) <= targetSum) {
                                	  count[i + a] = true;
                                  }
                           }
                   }
           }
           for(int i=targetSum;i>=0;i--){
                   if(count[i] == true){
                           return i;
                   }
           }
           return 0;
    }


}
