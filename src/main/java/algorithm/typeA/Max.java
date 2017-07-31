package algorithm.typeA;

import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		
		System.out.println("====最大値を求める====");
		Scanner stdIn = new Scanner(System.in);
		int tnum = stdIn.nextInt();
		
		int[] num = new int[tnum];
		Make make = new Make();
		make.make(num, tnum);

		int max = num[0];
		for(int i=1; i < tnum ; ++i){
			if(num[i] > max){
				max = num[i];
			}
		}
		
		System.out.println("最大値：" + max);
	}
}
