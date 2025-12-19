//変数fwのスコープを広げると…（エラー）
import java.io.FileWriter;

public class Main17_06 {

	public static void main(String[] args) {
		//mainメソッドブロックをfwのスコープにする
		FileWriter fw = new FileWriter("data.txt");
		//スコープ内だからfwを利用可能
		try {
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			fw.close();
			//例外IOExceptionをキャッチしていないというエラーがでる
			//スコープ内だからfwを利用可能
		}
	}

}
