//2人の勇者を比較する
public class Main14_6 {
	public static void main(String[] args) {
		//メモ↓インスタンス生成
		Hero h1 = new Hero();
		//h1のnameに"ミナト"
		h1.name = "ミナト";
		//h1のhpに100
		h1.hp = 100;
		//インスタンス生成
		Hero h2 = new Hero();
		//h2のnameにミナト
		h2.name = "ミナト";
		//h2のhpに100
		h2.hp = 100;
		//equals()はあるインスタンスと自分自身が同じか調べる
		//調べて等しければtrue
		if(h1.equals(h2) == true) {
			System.out.println("同じ内容です");
		//もし違う場合はelse
		} else {
			System.out.println("違う内容です");
		}
	}
}