//例外処理を用意していないと…（エラー）

//メモ↓java.io.*はファイル予期書きなど、データを逐次処理するためのクラス群をすべて(.*)使えるようにしている
import java.io.FileWriter;

public class Main17_01 {

	public static void main(String[] args) {
		//FileWriterはファイルに文字を書き込むもの
		//コンストラクタ
		FileWriter fw = new FileWriter("data.txt");
		//エラーでIOEException(Exception系例外)というものがでているからcatchする
		//※ConnectExceptionもException系例外だからcatchをする
	}
}
