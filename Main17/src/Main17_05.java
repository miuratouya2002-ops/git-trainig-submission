//finallyブロックでcloseすると…（エラー）
import java.io.FileWriter;

public class Main17_05 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("data.txt");
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			fw.close();
			//シンボルを見つけられませんというエラーがでる
		}
	}
}