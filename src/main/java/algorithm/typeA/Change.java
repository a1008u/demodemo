package algorithm.typeA;

public class Change {

	public static void main(String args[]){
		
		int tempnum;
		
		System.out.println("====2つの数字の入れ替え====");
		int tnum = 2;
		int[] num = new int[tnum];
		String[] text = new String[tnum];
		
		Make make = new Make();
		make.make(num, tnum);
		
		for(int i=0; i<tnum-1 ; ++i){
			tempnum = num[i];
			num[i] = num[i+1];
			num[i+1] = tempnum;
		}
		
		System.out.println("---入替結果---");
		
		for(int i : num){
			System.out.println("要素：" + i);
		}
		
	}
}
