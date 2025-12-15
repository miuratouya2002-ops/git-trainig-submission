//何も定義していないクラスでtoString()を呼ぶ
public class Main14_1 {
	public static void main(String[] args) {
		//メモ↓インスタンス生成
		Main14_1_Empty empty = new Main14_1_Empty();
		//メモ↓toStringの呼び出し
		//　　　String sを代入させる
		String  s = empty.toString();
		//メモ↓sを表示させる
		System.out.println(s);
		
		//メモ　extendsで親クラスを指定しないと、java.lang.objectを親クラスとして継承したとみなされる
		//　　　→多態性を利用できるようになるから
		//　　　equals→あるインスタンスと自分自身が同じかを調べる
		//　　　自分自身の内容の文字列表現を返す
		
	}
}