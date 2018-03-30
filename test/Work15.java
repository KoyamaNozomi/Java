import java.util.*;

public class Work15{

	public static void main(String[] args){
		int num = 0;
		System.out.println("0~9の整数を入力してください");
		while(true){
			try{
				Scanner scanner = new Scanner(System.in);
				num = scanner.nextInt();
				UpperCheck(num);
				LowerCheck(num);
			}catch(java.util.InputMismatchException e){
				System.out.println("半角数字１桁を入力してください");
				continue;
			}catch(UpperException ne){
				System.out.println("入力された数値が上限を上回っています");
				continue;
			}catch(LowerException ne){
				System.out.println("入力された数値が下限を下回っています");
				continue;
			}
			break;
		}
	}


	public static void UpperCheck(int num) throws UpperException {
		if(num>9){
			UpperException ne = new UpperException();
			throw ne;
		}
	}

	public static void LowerCheck(int num) throws LowerException {
		if(num<0){
			LowerException ne = new LowerException();
			throw ne;
		}
	}
}


class UpperException extends Exception{
}
class LowerException extends Exception{
}
