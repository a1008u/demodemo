package algorithm.typeB;

import java.util.ArrayList;
import java.util.List;

public class BSMBlogic {

	public List<Integer> bsearch(int[] numlist, int searchnum, int tail){

		int result = 0;
		int center = 0;
		
		for(int head = 0 ; head <= tail; ++head){
			
			center = (head + tail)/2;
			
			if(numlist[center] == searchnum){
				++center;
				result += 1;
				break;
			}else{
				if(numlist[center] < searchnum){
					head = center + 1;
				}else{
					tail = center + 1;
				}
			}
			
		}
		
		//結果の詰め込み
		List<Integer> List = new ArrayList();
		List.add(result);
		List.add(center);
		return List;
	}
}
