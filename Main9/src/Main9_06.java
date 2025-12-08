public class Main9_06 {
	//勇者と魔法使いを生み出す
	public static void main(String[] args) {
		Hero h1 = new Hero();
		h1.name = "ミナト";
		h1.name = 100;
		Hero h2 = new Hero();
		h2.name = "アサカ";
		h2.hp = 100;
		Wizard w = new Wizard();
		w.name = "スガワラ";
		w.hp = 50;
		w.heal(h1); //ミナトを回復させる(HP: 100 → 110)
		w.heal(h2); //アサカを回復させる(HP: 100 → 110)
		w.heal(h2); //アサカを回復させる(HP: 110 → 120)
	}
}