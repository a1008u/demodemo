package algorithm.typeE;
import java.util.Scanner;

/*====単純交換法====
探索する配列の作成：5
【1】917 【2】1095 【3】607 【4】707 【5】177 
---単純交換法より昇順に変更----
【1】 177 【2】 607 【3】 707 【4】 917 【5】 1095 
*/

public class BubbleSort_Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====単純交換法====");
		
		System.out.println("探索する配列の作成：");
		int tail = stdIn.nextInt();
		
		//===データ格納===
		BSMakeService BSMakeService = new BSMakeService();
		int[] BSnumlist = BSMakeService.BSmake(tail);
		
		System.out.println("");
		
		//===昇順===
		BSMethodService BSMethodService = new BSMethodService();
		BSMethodService.BSmethod(BSnumlist, tail);
	}
}
