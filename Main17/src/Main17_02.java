//try-catch文でException系例外の発生に備える
import java.io.FileWriter;
import java.io.IOException;
public class Main17_02 {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("data.txt");
		} catch (IOException e) {
			System.out.println("エラーが発生しました。");
		}
	}

}
