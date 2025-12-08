// メインメソッド内の呼び出しを修正する
public class Main6_03 {
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		int total = tasu(a, b);
		int delta = hiku(a, b);
		System.out.println("足すと" + total + "、引くと" + delta);
	}
}