//newしなくても静的メソッドは呼び出せる
public class Main14_14 {
	public static void main(String[] args) {
		//金額をランダムに設定する
		Hero.setRandomMoney();
		//ランダムな金額を表示する
		System.out.println(Hero.money);
		Hero h1 = new Hero();
		//同じ額を表示
		System.out.println(h1.money);
	}
}