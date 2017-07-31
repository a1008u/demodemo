package algorithm.typeA;

public class Comparison {

	public static void main(String args[]){
		
		System.out.println("====2つの数字の比較をします====");
		int tnum = 2;
		int[] num = new int[tnum];

		Make make = new Make();
		make.make(num, tnum);
		
		System.out.println("数値の比較：");
		
		for(int i=0; i<1 ; ++i ){
			if(num[i] > num[i+1]){
				System.out.println(num[i] + " 【1番目の数値の方が大きい】");
			}else if(num[i] == num[i+1]){
				System.out.println("1番目と2番目は同じ数値です");
			}else{
				System.out.print(num[i+1] + " 【2番目の数値の方が大きい】");
			}
		}
	}
}
