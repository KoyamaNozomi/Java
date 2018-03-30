import java.io.*;

public class Chip{
	int chip10;
	int chip1;
	public int chipSum;
	int bet;


	public void chipSum(){
		chipSum = 10*chip10 + chip1;
	}


	public void calcChip(boolean win){
		if(win)
			chipSum = chipSum + bet;
		else
			chipSum = chipSum - bet;
		chip1 = chipSum%10;
		chip10 = (chipSum-chip1)/10;
	}


	public void showChip(){
		System.out.println("");
		System.out.println("*****チップ枚数*****");
		System.out.println("チップ : "+chipSum+" ([10]:"+chip10+"枚, [1]:"+chip1+"枚)");
	}


	// bet数の入力
	public void bet() throws IOException {
		System.out.println("");
		System.out.println("***bet数選択***");
		// BET数の最大値
		int maxBet = 20;
		if( chipSum < maxBet ){
			maxBet = chipSum;
		}
		System.out.println("betするchip数を選択してください(1~"+maxBet+")");
		while(true){
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			String input = b.readLine();
			try{
				bet = Integer.parseInt(input);	// intに変換
			}
			// 整数以外が入力された場合の例外処理
			catch(NumberFormatException e){
				System.out.println("整数値を入力してください");
				continue;
			}

			// BET数が適切かの判定
			if(bet>0 && bet<=maxBet){
				break;
			}else{
				System.out.println("1~"+maxBet+"の間で入力してください");
			}
		}
	}


	// check 0 chip
	public boolean check0chip(){
		if(chipSum<1)
			return false;
		else
			return true;
	}

}
