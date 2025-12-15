//どんなインスタンスでも受け取れるメソッド
public class Main14_3_Printer {
	//メモ↓printAnythingメソッド
	//　　　Object oを受け取る
	public void printAnything(Object o) {
		//どんな型のインスタンスでも受け取って画面に表示
		System.out.println(o.toString());
	}
}
//参照型のインスタンスを格納できる
//intやlongなどの基本データ型の情報は格納できない

//printAnything()と同じ内容を持つのがSystem.out.println()
//→引数としてObject型を受け取れる
