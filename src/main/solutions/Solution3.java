package main.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st;
		int testCases=Integer.parseInt(br.readLine());
		while(testCases-->0)
		{
			
			if((str=br.readLine())!=null)
			{
				st=new StringTokenizer(str);
				int arraySize=Integer.parseInt(st.nextToken());
				int targetSum=Integer.parseInt(st.nextToken());
				str=br.readLine();
				st=new StringTokenizer(str);
				int  array[]=new int[arraySize];			
				for(int i=0;i<arraySize;i++)
				{
					array[i]=Integer.parseInt(st.nextToken());					
				}
				int[] count=new int[targetSum+1];
				for(int i=1;i<=targetSum;i++)
				{
					for(int j=0;j<arraySize;j++)
					{
						if(array[j]<=i)
						{
							count[i]=Math.max(count[i],array[j]+count[i-array[j]]);
						}
					}
				}
				int result=count[targetSum];
				System.out.println("\n");
				System.out.println("Output***"+result);
				
				
			}
		}
	}
}
