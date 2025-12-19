
//後片付け処理もtry-catchする
import java.io.FileWriter;
import java.io.IOException;

public class Main17_08 {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("data.txt");
			fw.write("hello!");
		} catch (Exception e) {
			System.out.println("何らかの例外が発生しました");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				//空文でclose失敗時には特に何もしない
				;
			}
		}
	}

}
