package algorithm.typeD;

public class SSSMethod_Sort_Blogic {
	
	public void SSSMSort(int[] SSSnumlist, int tail){
		//引数の配列をソートするため、全て中身チェック
		for(int flag =0; flag < tail ; ++flag){
			int indexmin = flag;
			
			//①最小値を配列の中から検索 + 変数にインデックスを格納
			for(int k = flag + 1; k < tail ; ++k){
				if(SSSnumlist[k] < SSSnumlist[indexmin]){
					indexmin = k;
				}
			}
			
			//②最小値を配列の左に格納する(入替)
			int tempnum = SSSnumlist[flag];
			SSSnumlist[flag] = SSSnumlist[indexmin];
			SSSnumlist[indexmin] = tempnum;
		}
	}
}
