package calcapp.main;
public class Calc {
	// 計算機プログラム
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
		int total = CalcLogic.tasu(a, b);
		int delta = CalcLogic.hiku(a, b);
		System.out.println("足すと" + total + "、引くと" + delta);
	}
	/*	public static int tasu(int a, int b) {
			return (a + b);
		}
		public static int hiku(int a, int b) {
			return (a - b);
		}*/
}