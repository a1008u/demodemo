package algorithm.typeD;
import java.util.Scanner;

/*====単純選択法====
探索する配列の作成：５
【1】76 【2】795 【3】1645 【4】1064 【5】804 
要素を昇順に並び替えます。
【1】 76 【2】 795 【3】 804 【4】 1064 【5】 1645 
 */

public class SimpleSelectSort_Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====単純選択法====");
		
		System.out.println("探索する配列の作成：");
		int tail = stdIn.nextInt();
		
		//===データ格納===
		SSSMakeService SSSMakeService = new SSSMakeService();
		int[] SSSnumlist = SSSMakeService.SSSmake(tail);
		
		System.out.println("");
		
		//===昇順===
		SSSMethodService SSSMethodService = new SSSMethodService();
		SSSMethodService.SSSmethod(SSSnumlist, tail);
	}
}
