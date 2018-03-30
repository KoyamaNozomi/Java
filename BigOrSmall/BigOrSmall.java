import java.io.*;
import java.util.*;

public class BigOrSmall{
	int small;

	// input 0 or 1
	public int input01(){
		int input;
		while(true){
			Scanner scanner = new Scanner(System.in);
			try{
				input = scanner.nextInt();
			}catch(java.util.InputMismatchException e){
				System.out.println("0か1(半角)で入力してください");
				continue;
			}
			if(input==0 || input==1){
				return input;
			}else{
				System.out.println("0か1(半角)で入力してください");
				continue;
			}
		}
	}


	// Big or Small の選択
	public int choose() throws IOException {
		System.out.println("");
		System.out.println("***Big or Small 選択***");
		System.out.println("[Big or Small]: 0:Big, 1:Small or same");
		small = this.input01();
		return small;
	}


	public int judge(Card card, int times1, int times2){
		ArrayList<Integer> List;
		List = card.cardList;
		int cardNum1 = List.get(times1-1);
		int cardNum2 = List.get(times2-1);
		int judge;
		if(cardNum1%13 < cardNum2%13)
			judge = 0;	//big
		else
			judge = 1;	//small
		return judge;
	}


	public boolean continueWin(int bet) throws IOException {
		System.out.println("");
		System.out.println("[獲得した"+bet*2+"チップでゲームを続けますか?] 0:yes 1:no");
		int cont;
		cont = this.input01();
		if(cont==0)
			return true;
		else
			return false;
	}


	public boolean askContinue() throws IOException {
		System.out.println("");
		System.out.println("[ゲームを続けますか?] 0:yes 1:no");
		int cont;
		cont = this.input01();
		if(cont==0)
			return true;
		else
			return false;
	}

}
