package algorithm.typeA;
import java.util.Random;

//ランダムで要素を生成する
public class Make {

	public void make(int[] num, int max){
		Random R = new Random();
		
		for(int i=0; i < max; ++i){
			
			//作成
			int n = i+1;
			System.out.print( "【" + n + "】");
			num[i] = R.nextInt(2000);
			
			//作成結果の表示
			if(i>3 && i%4 == 0){
				System.out.println( num[i] +" " );
			}else{
				System.out.print( num[i] +" " );
			}
		}
	}
}
