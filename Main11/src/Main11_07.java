//public class Main11_07 {
//attack()を抽象メソッドとして宣言する
public class Character {
	String name;
	int hp;

	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}

	public abstract void attack(Matango m);
}