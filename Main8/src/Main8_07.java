//public class Main8_07 {
//「眠る」操作に含まれる要素を記述
public class Hero {
	String name;
	int hp;

	public void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}
}