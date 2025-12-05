public class Main5_03 {
	//mainメソッド以外からメソッドを呼び出す
	public static void methodA() {
		System.out.println("methodA");
		methodB();
	}

	public static void methodB() {
		System.out.println("methodB");
	}

	public static void main(String[] args) {
		methodA();
	}
}