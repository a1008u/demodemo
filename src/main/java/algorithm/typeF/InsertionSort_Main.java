package algorithm.typeF;
import java.util.Scanner;

/*
====単純挿入法====
探索する配列の作成：5
【1】1229 【2】39 【3】1115 【4】1552 【5】1507 

【1】 39 【2】 1115 【3】 1229 【4】 1507 【5】 1552 
*/
public class InsertionSort_Main {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====単純挿入法====");
		
		System.out.println("探索する配列の作成：");
		int tail = stdIn.nextInt();
		
		//===データ格納===
		ISMakeService ISMakeService = new ISMakeService();
		int[] ISnumlist = ISMakeService.ismake(tail);
		
		System.out.println("");
		
		//===昇順===
		ISMethodService ISMethodService = new ISMethodService();
		ISMethodService.ismethod(ISnumlist, tail);
	}

}
