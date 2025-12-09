//public class Main11_08 {
//Characterを抽象表現として宣言する
public abstract class Character {
	String name;
	int hp;
	public void run() {
		System.out.println(this.name + "は逃げ出した");
	}
	public abstract void attack(Matango m);
}