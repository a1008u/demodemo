package algorithm.typeC;
import java.util.Scanner;
import typeA.Make;

/*
====ハッシュ(オープンアドレス法)====
探索する配列の作成：3
====ハッシュ前の格納====
【1】923 【2】877 【3】1191 
====ハッシュ値利用後の格納====
【1】1191 【2】877 【3】923 【4】0 【5】0 【6】0 
探索する数値：877
--ハッシュ法を用いた検索結果--
877は【2】番目に数値があります。
*/

public class HashMain {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("====ハッシュ(オープンアドレス法)====");
		
		System.out.print("探索する配列の作成：");
		int tail = stdIn.nextInt();
		
		//===オープンアドレス法の格納===
		HashMakeService HashMakeService = new HashMakeService();
		int[] hashnumlist =HashMakeService.hashmake(tail);
		
		System.out.println("");
		
		//===オープンアドレス法の検索と結果===
		//検索
		HashSearchService HashSearchService = new HashSearchService();
		HashSearchService.hashsearch(hashnumlist,tail);
	}
}
