package test;

public class work5{
	public static void main(String[] args){
		int[] array = {96, 45, 31, 29, 84, 77};
		display(array, false);
		// 昇順
		arraySort(array, true);
		display(array, true);
		// 降順
		arraySort(array, false);
		display(array, true);
	}


	public static void arraySort(int[] array, boolean order){
		for( int i=0; i<array.length; i++ ){
			for( int j=i+1; j<array.length; j++ ){
				if(order && array[i]>array[j]){
					change(array, i, j);
				} else if(!order && array[i]<array[j]){
					change(array, i, j);
				}
			}
		}
	}


	public static void change(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}


	public static void display(int[] array, boolean isSorted){
		if(isSorted){
			System.out.println("***並び替え後***");
		} else{
			System.out.println("***並び替え前***");
		}
		for( int num : array ){
			System.out.print(num);
			System.out.print(',');
		}
		System.out.print('\n');
	}

}
