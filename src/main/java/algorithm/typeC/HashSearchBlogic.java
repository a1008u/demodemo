package algorithm.typeC;

public class HashSearchBlogic {

	public boolean hashsearch(int[] hashnumlist, 
							  int searchhashnum,
							  int searchnum){
		
		//結果変数
		boolean result = false;
		
		//結果の条件判定
		while(hashnumlist[searchhashnum] != 0){
			if(hashnumlist[searchhashnum] == searchnum){
				result = true;
				break;
			}else{
				searchhashnum = (searchhashnum+1) % 11;
			}
			
		}
		
		return result;
	}
}
