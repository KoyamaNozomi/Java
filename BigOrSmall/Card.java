import java.util.*;

public class Card{
	int num;
	int cardNum;
	String suit;

	// card list
	ArrayList<Integer> cardList = new ArrayList<Integer>();


	// make card list and shuffle
	public void cardList(){
		for(int i=0; i<52; i++)
			cardList.add(i);
		Collections.shuffle(cardList);
	}


	// number and suit of playing cards from cardNum(0~51)
	public void toranpu(){
		num = cardNum % 13 + 1;
		switch( (cardNum-num+1)/13 ){
			case 0:
				suit = "スペード";
				break;
			case 1:
				suit = "クラブ";
				break;
			case 2:
				suit = "ハート";
				break;
			case 3:
				suit = "ダイヤ";
				break;
		}
	}


	public void drawCard(int times){
		cardNum = cardList.get(times-1);
		toranpu();
		System.out.println("");
		System.out.println("************************");
		if(times==1)
			System.out.println("現在のカード : " + suit + num);
		else
			System.out.println("引いたカード : " + suit + num);
		System.out.println("************************");
	}


	public void showCard(){
		System.out.println("");
		System.out.println("************************");
		System.out.println("現在のカード : " + suit + num);
		System.out.println("************************");
	}
}
