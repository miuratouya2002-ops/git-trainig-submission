//Heroクラスの文字情報を表示する
public class Main14_4 {
	public static void main(String[] args) {
		//メモ↓Hero型のhにインスタンス生成する
		//　　　newでインスタンスを生成
		Hero h = new Hero();
		//メモ↓h.nameに"ミナト"を代入
		h.name = "ミナト";
		//メモ↓h.hpに100を代入
		h.hp = 100;
		//メモ↓toString()はオブジェクトの中身の情報を文字列にしてくれる
		System.out.println(h.toString());
	}
}
