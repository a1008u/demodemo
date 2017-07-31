package algorithm.typeB;

import java.util.Scanner;

import typeA.Make;

//二分探索法

public class BinarySearch {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====二分探索法====");
		
		//配列を生成
		System.out.println("探索する配列の作成：");
		int tail = stdIn.nextInt();
		BinarySearchService BinarySearchService = new BinarySearchService ();
		int[] numlist = BinarySearchService.bsmake(tail);
		
		System.out.println("");
		
		//二分探索
		System.out.println("探索する数値：");
		int searchnum = stdIn.nextInt();
		BinarySearchMethodService BinarySearchMethodService= new BinarySearchMethodService();
		BinarySearchMethodService.bsmethod(numlist, searchnum, tail);
	}
}
