package test;
import java.util.Arrays;
import java.util.Comparator;

public class work6{

	public static void main(String[] args){
		String[] fruit = {"appale", "orange", "peach", "grape", "melon", "pineapple"};

		System.out.println("***並び替え前***");
		System.out.println(Arrays.toString(fruit));
		
		java.util.Arrays.sort(fruit);
		System.out.println("***並び替え後***");
		System.out.println(Arrays.toString(fruit));

		java.util.Arrays.sort(fruit, java.util.Comparator.reverseOrder());
		System.out.println("***並び替え後***");
		System.out.println(Arrays.toString(fruit));

	}

}
