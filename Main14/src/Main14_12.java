//newしなくても静的フィールドは利用できる
public class Main14_12 {
	public static void main(String[] args) {
		//1人も勇者を生み出していない状況で…
		Hero.money = 100;
		System.out.println(Hero.money);
	}
}
