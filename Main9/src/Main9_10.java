//public class Main9_10 {
// コンストラクタで引数を追加情報として受け取る
public class Hero {
	String name;
	int hp;
	Sword sword;

	public void attack() {
		System.out.println(this.name + "は攻撃した！");
	}

	public Hero() {
		this.hp = 100; //引数の値でnameフィールドを初期化
	}
}