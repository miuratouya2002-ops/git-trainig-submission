//静的フィールドmoneyへのアクセス
public class Main14_10 {

	public static void main(String[] args) {
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		//メモ↓インスタンス生成
		System.out.println(h1.hp);
		System.out.println(Hero.money);
	}
}	