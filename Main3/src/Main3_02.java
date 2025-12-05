public class Main3_02 {
	// トイレの空きを待つ繰り返し
	public static void main(String[] args) {
		boolean doorClose = true;
		while (doorClose == false) {
			System.out.println("ノックする");
			System.out.println("1分待つ");
		}
	}
}