package algorithm.typeE;

public class BSort_Blogic {

	public void BSort(int[] BSnumlist, int tail){
		//配列の要素-1分だけ単純交換法を行う
		//最後の値は自動的に一番大きな値となるため
		for(int k = 0; k<tail-1 ;++k){
			
			//各要素を並び替えていく
			for(int temptail = tail-1 ; temptail> k; temptail--){
				
				if( BSnumlist[temptail] < BSnumlist[temptail-1]){
					int tempnum = BSnumlist[temptail];
					BSnumlist[temptail] = BSnumlist[temptail - 1];
					BSnumlist[temptail - 1] = tempnum; 
				}
			}
		}
	}
}
