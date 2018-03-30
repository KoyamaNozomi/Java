import java.io.*;
import java.util.*;

public class Game{
	public static void main(String[] args){
		// chip initialize
		Chip chip = new Chip();
		chip.chip10 = 10;
		chip.chip1 = 0;
		chip.chipSum();
		chip.showChip();

		// card list initialize
		Card card = new Card();
		card.cardList();

		// draw the first card
		int times = 1;
		card.drawCard(times);

		BigOrSmall BS = new BigOrSmall();

		// input the number of bet
		try{
			chip.bet();
		}catch(IOException e){
			System.out.println("入力エラー");
		}


		while(true){
			times++;
			int small = 0;

			// choose Big or Small
			try{
				small = BS.choose();
			}catch(IOException e){
				System.out.println("入力エラー");
			}

			// draw a card
			card.drawCard(times);

			// judge Big or Small
			int judge = BS.judge(card, times-1, times);
			if(judge==small)
				System.out.println("WIN!!");
			else
				System.out.println("LOOSE...");

			// calculate chip
			chip.calcChip(judge==small);
			chip.showChip();

			// end game when no chip
			boolean check = chip.check0chip();
			if(!check){
				System.out.println("chipがなくなりました。ゲームを終了します");
				break;
			}


			// ask continue or not after win
			boolean cont = true;
			if(judge==small){
				try{
					cont = BS.continueWin(chip.bet);
				}catch(IOException e){
					System.out.println("入力エラー");
				}
				if(cont){
					chip.bet = chip.bet*2;
					continue;
				}
			}

			// ask continue or not after shuffle
			try{
				cont = BS.askContinue();
			}catch(IOException e){
				System.out.println("入力エラー");
			}
			if(cont){
				// card initilalize
				System.out.println("");
				System.out.println("カードをシャッフルします");
				times = 1;
				card.cardList();
				card.drawCard(times);
				// input the number of bet
				try{
					chip.bet();
				}catch(IOException e){
					System.out.println("入力エラー");
				}
				continue;
			}else{
				System.out.println("");
				System.out.println("GAME END");
				break;
			}

		}
	}
}
