package algorithm.typeI;

import java.util.Scanner;
/*
====ユークリッド法====
ユークリッドを行う数①：32
ユークリッドを行う数②：5432
====①数の大きさチェック====
大【5432】
小【32】
=====②ユークリッドの互除法=====
最大公約数は【8】
*/

public class Euclid_Main {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====ユークリッド法====");
		
		System.out.print("ユークリッドを行う数①：");
		int bignum = stdIn.nextInt();
		
		System.out.print("ユークリッドを行う数②：");
		int smallnum = stdIn.nextInt();
		
		//===データ格納===
		EuclidService EuclidService = new EuclidService();
		EuclidService.numcheck(bignum, smallnum);
		
		//===ユークリッドの互除法===
		EuclidMethodService EuclidMethodService = new EuclidMethodService();
		EuclidMethodService.emethod(bignum, smallnum);
	}

}
