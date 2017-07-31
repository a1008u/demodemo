package algorithm.typeB;

import java.util.List;

public class BinarySearchMethodService {
	
	public void bsmethod(int[] numlist, int searchnum, int tail){
		
		BSMBlogic BSMBlogic = new BSMBlogic();
		List<Integer> List = BSMBlogic.bsearch(numlist, searchnum, tail);
		
		if(List.get(0) == 1){
			System.out.println("お探しの数値は"+ List.get(1) +"番目にあります");
		}else{
			System.out.println("お探しの数値はありません");
		}
		
	}
}
