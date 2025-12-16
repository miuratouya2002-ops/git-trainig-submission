//HashMapクラスの利用
//java.utilというパッケージに含まれるクラスとインタフェースを、このプログラム内で使えるように準備している
//※ *はすべてを意味するからjava.utilのクラスとインタフェースすべて
import java.util.HashMap;
import java.util.Map;

public class Main16_6 {

	public static void main(String[] args) {
		//メモ↓コレクションはMap
		//　　　String型、Integer型にするという宣言
		//　　　Mapというルールを実装した
		//　　　HashMapインスタンスを生成
		
		Map<String, Integer> prefs = new HashMap<String, Integer>();
		//メモ↓キー（京都府）と値(255)に格納している
		prefs.put("京都府", 255);
		//メモ↓キー（東京都）と値(1261)に格納している
		prefs.put("東京都", 1261);
		//メモ↓キー（熊本県）と値(181)に格納している
		prefs.put("熊本県", 181);
		//メモ↓get()メソッドは、引数で指定されたキー（"東京都"）を探す
		//　　　キーが見つかると、それとペアになっているバリュー（1261）を返す
		//　　　返された値（1261）を、int型の変数tokyoに代入
		//　　　Integerからintへの変換は、Javaが自動的に行う
		int tokyo = prefs.get("東京都");
		
		System.out.println("東京都の人口は、" + tokyo);
	
		//メモ↓prefsというMapから、キー（"京都府"）を指定
		//　　　そのキーとバリューのペアを丸ごと削除（remove）	
		prefs.remove("京都府");
		//メモ↓prefsというMapに、既に存在するキー（"熊本県"）に対して、新しいバリュー（182）を格納
		//　　　put()メソッドは、指定されたキーがまだ存在しない場合は新しいペアを追加
		//　　　既に存在する場合はそのキーに対応するバリューを新しい値で上書き
		//　　　この行により、"熊本県"に対応する値が181から182に更新
		prefs.put("熊本県", 182);
		//メモ↓prefsから、キー（"熊本県"）を使って、現在のバリューを取得
		//　　　技術的意味: get("熊本県")を呼び出すと、先ほど182に上書きされた、最新の値が返される
		//　　　返された182を、int型の変数kumamotoに代入
		int kumamoto = prefs.get("熊本県");
		
		System.out.println("熊本県の人口、" + kumamoto);
	}
}