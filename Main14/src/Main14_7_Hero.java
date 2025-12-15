//名前が同じなら同じ勇者とするequals()を定義
public class Main14_7_Hero {
	//name,hpを定義
	String name;
	int hp;
	//yes,noはboolean型
	//equalsは文字列が
	//==は等値で指しているものが完全に同一の存在かどうか
	//equalsは等価で指している2つのものが同じ内容かどうか
	public boolean equals(Object o) {
		//returnでtrueの値を返す
		if (this == o) { return true; }
		if (o instanceof Hero h) {
			//名前が等しければ等価
			if (this.name .equals(h.name)) {
				
			}
		return false;
	}

}

	