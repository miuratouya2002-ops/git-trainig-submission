//意図する文字列表現を返すtoString()を定義
public class Main14_5_Hero {
	//String型のnameを定義
	String name;
	//int型のhpを定義
	int hp;
	//メモ↓toStringをオーバーライドしておくとインスタンスの内容を画面に出力できる
	public String toString() {
		//returnで値を返す
		//this.で自分自身のname,hpにする
		return "名前：" + this.name + "/HP：" + this.hp;
	}
}
