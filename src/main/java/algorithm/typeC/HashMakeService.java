package algorithm.typeC;

import java.util.Scanner;

import typeA.Make;

public class HashMakeService {

	public int[] hashmake(int tail) {
		
		Scanner stdIn = new Scanner(System.in);
		
		//準備
		int[] numlist = new int[tail];
		
		//ハッシュ値を利用する前の段階
		System.out.println("====ハッシュ前の格納====");
		Make make = new Make();
		make.make(numlist, tail);
		
		System.out.println("");
		
		//ハッシュ値を利用時の段階(オープンアドレス法)
		int[] hashnumlist = new int[tail*2];
		HashNumBlogic HashNumL = new HashNumBlogic();
		HashNumL.hashnumlistmake(hashnumlist, numlist, tail);
		
		return hashnumlist;
		
	}
}
