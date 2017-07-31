package algorithm.typeC;

import java.util.Scanner;

public class HashSearchService {
	
	public void hashsearch(int[] hashnumlist,int tail){
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("探索する数値：");
		int searchnum = stdIn.nextInt();
		int searchhashnum = searchnum % tail;
		
		HashSearchBlogic HashSearchBlogic = new HashSearchBlogic();
		boolean result = HashSearchBlogic.hashsearch(hashnumlist, 
													searchhashnum, 
													searchnum);
		
		//結果
		System.out.println("--ハッシュ法を用いた検索結果--");
		if(result){
			searchhashnum = searchhashnum +1;
			System.out.println(searchnum 
					+"は【"+ searchhashnum +"】番目に数値があります。");
		}else{
			System.out.println(searchnum +"は格納されていません。");
		}
	}
}
