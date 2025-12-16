//ラッパークラスをArrayListに格納する
//
import java.util.ArrayList;

public class Main16_1 {
	public static void main(String[] args) {
		//メモ↓ArrayListは<Integer>で格納できる
		//　　　インスタンス化する場合はnew ArrayList<String>()と書く
		//　　　コレクションには基本データ型の情報を格納できない
		//　　　※ArrayListをIntではなく、Integerにするなど
		ArrayList<Integer> points = new ArrayList<Integer>();
		//メモ↓ArrayListでは[]の代わりにadd.()を使う
		points.add(10);
		points.add(80);
		points.add(75);
		for (int i; points) {
			System.out.println(i);
		}
	}
}