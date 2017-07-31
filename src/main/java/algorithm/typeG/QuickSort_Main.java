package algorithm.typeG;

import java.util.Scanner;
/*
====クイックソート====
探索する配列の作成：5
====クイックソート前====
【1】1075 【2】1232 【3】458 【4】167 【5】80 
=====クイックソート後=====
【1】 80 【2】 167 【3】 458 【4】 1075 【5】 1232 
*/

public class QuickSort_Main {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====クイックソート====");
		
		System.out.print("探索する配列の作成：");
		int tail = stdIn.nextInt();
		
		//===データ格納===
		QSMakeService QSMakeService = new QSMakeService();
		int[] QSnumlist = QSMakeService.qsmake(tail);
		
		//===昇順===
		QSMethodService QSMethodService = new QSMethodService();
		QSMethodService.qsmethod(QSnumlist, tail);
	}

}
