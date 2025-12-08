//public class Main9_03 {
	// Sword型フィールドを持つHeroクラス
	public class Sword {
		String name;
		int damage;
	}	
	
}

//次にHeroクラスを定義する
public class Hero {
	String name;
	int hp;
	Sword sword;
	public void attack() {
		System.out.println(this.name + "は攻撃した！");
		System.out.println("敵に5ポイントのダメージをあたえた！");
	}
}