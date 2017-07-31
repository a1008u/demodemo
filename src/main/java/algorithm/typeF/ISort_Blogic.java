package algorithm.typeF;

public class ISort_Blogic {
	
	public void iSort(int[] iSnumlist, int tail){
		//配列の要素数(先頭は基軸となる)
		for(int i=1; i<tail ; ++i){
			int tempnum = iSnumlist[i];
			int nullindex = i ;
			
			//挿入法
			while(nullindex > 0 && iSnumlist[nullindex-1]>tempnum){
				iSnumlist[nullindex] = iSnumlist[nullindex-1];
				nullindex -= 1;
			}
			iSnumlist[nullindex] = tempnum;
		}
	}
}
