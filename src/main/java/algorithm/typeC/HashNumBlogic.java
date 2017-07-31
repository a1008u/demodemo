package algorithm.typeC;

public class HashNumBlogic {
	public void hashnumlistmake(int[] hashnumlist, 
								int[] numlist, 
								int tail){
		
		//オープンハッシュ法による格納
		for(int i = 0; i< tail ; ++i){
			int hashnum = numlist[i] % tail;
			
			while(true){
				if(hashnumlist[hashnum] == 0){
					hashnumlist[hashnum] = numlist[i];
					break;
				}else{
					hashnum = (hashnum+1) % tail;
				}
			}
		}
		
		//ハッシュ値利用後の結果
		System.out.println("====ハッシュ値利用後の格納====");
		for(int i = 0; i < hashnumlist.length ; ++i){
			int num = i+1;
			if(i>8 && i%9 == 0){
				System.out.println("【" + num + "】" 
						+ hashnumlist[i] +" " );
			}else{
				System.out.print("【" + num + "】" 
						+ hashnumlist[i] +" " );
			}
		}
	}
}
