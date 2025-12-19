//tryブロック内でnewすると…（エラー）
import java.io.FileWriter;
public class Main17_07 {

	public static void main(String[] args) {
		FileWriter fw;
		//mainメソッドブロックはスコープのまま
		try {
			//tryブロック内でコンストラクタが動作する
			fw = new FileWriter("data.txt");
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			fw.close();
		}
	}

}
