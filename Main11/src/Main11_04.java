//public class Main11_04 {
//オーバーライドを忘れたHeroクラス
public class Hero extends Character {
}

public class Main {
	public static void main(String[] args) {
		Hero h = new Hero();
		Matango m = new Matango();
		h.attack(m);
	}
}