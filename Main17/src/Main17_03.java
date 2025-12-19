//ザックリと例外を捕捉する

import java.io.FileWriter;

public class Main17_03 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("data.txt");
			fw.write("hello!");
			fw.close();
		} catch (Exception e) {
			//ファイルは閉じる処理が実行されない可能性がある
			System.out.println("何らかの例外が発生しました");
		}
	}
}