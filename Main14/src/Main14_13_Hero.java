//所持金をランダムに設定する
public class Main14_13_Hero {
	String name;
	int hp;
	//メモ↓静的フィールド
	static int money;
	//メモ↓勇者たちの所持金をランダムに設定する
	public static void setRandomMoney() {
		Hero.money = (int)(Math.random() * 1000);
	}
}