//オリジナル例外を利用する
public class Main17_13 {

	public static void main(String[] args) {
		try {
			//試験的に例外を発生させる
			throw new Main17_12_UnsupportedMusicFileException
			("未対応のファイルです");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
