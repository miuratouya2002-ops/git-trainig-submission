//静的メソッドから非静的メンバを利用（エラー）
public class Main14_15_Hero {
	String name;
	int hp;
	static int money;
	public static void setRandomMoney() {
		//(int)はキャスト演算子でdouble型の値を強制的にint（整数）に変える
		Hero.money = (int)(Math.random() * 1000);
		System.out.println(this.name + "たちの所持金を初期化しました");
	}
}