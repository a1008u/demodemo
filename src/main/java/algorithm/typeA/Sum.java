package algorithm.typeA;

import java.util.Scanner;

public class Sum {
	public static void main(String args[]){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("====合計値====");
		System.out.print("合計に利用する数値数を記載してください:");
		int tnum = stdIn.nextInt();
		
		int[] num = new int[tnum];
		Make make = new Make();
		make.make(num, tnum);
		
		int sum = 0;
		for(int tempnum: num){
			sum += tempnum;
		}
		System.out.println("合計値："+ sum);
	}

}
