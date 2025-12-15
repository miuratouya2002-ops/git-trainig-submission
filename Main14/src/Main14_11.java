//インスタンスから静的フィールドを利用する
public class Main14_11 {
	public static void main(String[] args) {
		//メモ↓インスタンスh1の箱hpを表示
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		Hero.money = 100;
		//メモ↓100と表示
		System.out.println(Hero.money);
		//メモ↓100と表示
		System.out.println(h1.money);
		h1.money = 300;
		System.out.println(h2.money);

	}

}
