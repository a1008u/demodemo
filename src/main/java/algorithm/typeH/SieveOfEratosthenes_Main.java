package algorithm.typeH;

import java.util.Scanner;
/*
====エラトステネスのふるい====
調べたい素数を記載：100
====素数の入れ物作成====
=====エラクトテネスのふるまい後：素数の数=====
  【2】 0   【3】 0   【5】 0   【7】 0  【11】 0  【13】 0 
 【17】 0  【19】 0  【23】 0  【29】 0  【31】 0  【37】 0 
 【41】 0  【43】 0  【47】 0  【53】 0  【59】 0  【61】 0 
 【67】 0  【71】 0  【73】 0  【79】 0  【83】 0  【89】 0 
 【97】 0 
素数の数【25】
*/

public class SieveOfEratosthenes_Main {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====エラトステネスのふるい====");
		
		System.out.print("調べたい素数を記載：");
		int tail = stdIn.nextInt();
		++tail;
		
		//===データ格納===
		SieveOfEratosthenesService SieveOfEratosthenesService = new SieveOfEratosthenesService();
		int[] SOElist = SieveOfEratosthenesService.listmake(tail);
		
		//===昇順===
		SOEMethodService SOEMethodService = new SOEMethodService();
		SOEMethodService.sqemethod(SOElist, tail);
	}

}
