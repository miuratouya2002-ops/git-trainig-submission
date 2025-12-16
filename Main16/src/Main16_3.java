//Setに重複した値を追加しようとすると

//メモ↓java.utilというパッケージ
//　　　HashSetクラスとSetインタフェースを、このプログラム内で使えるようにインポートしている。
import java.util.HashSet;
import java.util.Set;

public class Main16_3 {
	
	public static void main(String[] args) {
		//メモ↓Setは順序関係がなく、重複が許されない
		//　　　文字列（String）を格納するための、Setという種類のコレクションを作成
		Set<String> colors = new HashSet<String>();
		//メモ↓colorsという名前のSetに、文字列「赤」を要素として追加
		colors.add("赤");
		//メモ↓colorsに、文字列「青」を要素として追加
		colors.add("青");
		//メモ↓colorsに、文字列「黄」を要素として追加
		colors.add("黄");
		//メモ↓add()メソッドが呼ばれると、HashSetは「赤」という要素が既に集合の中に存在するかをチェック。
		//　　　今回は、既に存在しています。
		//　　　Setのルールでこのadd()の呼び出しは無視される。
		//　　　現在の要素は{"赤", "青", "黄"}のままとなる
		colors.add("赤");
		System.out.println("色は" + colors.size() + "種類");
	}
}