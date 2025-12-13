//2つの座標データを指定することで、線を描画するクラス
//線描画メソッド
//線の長さを取得するメソッド

//引数なしコンストラクタの定義
//p1(x,y座標)、p2(x,y座標)全て0で初期化する。

//メモ↓クラスがLineでインターフェースのFigureを実装
//　　　引数なしで定義
//　　　型がPointのprivateフィールドで属性がp1
//　　　型がPointのprivateフィールドで属性がp2

public class Line implements Figure {
	private Point p1;
	private Point p2;

	//引数で受け取ったデータを用いて、2つのPointオブジェクトを生成。
	//p1フィールドとp2フィールドにそれぞれを代入する。

	//メモ↓引数なし
	//　　　戻り値なし
	//　　　区別をするためにthis.をつける
	//　　　引数で受け取って2つのインスタンス（実体）を作る
	//　　　クラスから実物を作る作業がnew
	//　　　p1フィールドに代入する
	//　　　p2フィールドに代入する
	//　　　生成したp1のx,yはすべて0で初期化する
	//　　　生成したp2のx,yはすべて0で初期化する
	//　　　※PointはクラスなのでPointだけではメソッドの実行だからエラーになる

	public Line() {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(0, 0);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */

	//メモ↓引数がint型 x1
	//      引数がint型 y1
	//　　　引数がint型 x2
	//　　　引数がint型 y2のそれぞれが入っている
	//　　　this.でp1を区別する
	//　　　this.でp2を区別する
	//　　　生成したp1のnew Pointの初期化した0にint型 x1を代入
	//　　　生成したp1のnew Pointの初期化した0にint型 y1を代入
	//　　　生成したp2のnew Pointの初期化した0にint型 x2を代入
	//　　　生成したp2のnew Pointの初期化した0にint型 y2を代入

	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}

	//以下のようなメッセージを表示する。なお、始点をp1、終点をp2とする。
	//出力例："[線を描画] 始点(0,0)から終点(100,100)まで"

	//メモ↓戻り値なし
	//　　　メソッドはdraw
	//　　　引数はなし
	//　　　System.out.printlnで()の中身を表示
	//　　　"[線を描画] 始点"をそのまま表示
	//　　　getX()でp1のフィールドを持ってくる（.は～の）
	//　　　getY()でp1のフィールドを持ってくる（.は～の）
	//　　　"から終点"をそのまま表示
	//　　　getX()でp2のフィールドを持ってくる（.は～の）
	//　　　getY()でp2のフィールドを持ってくる（.は～の）
	//　　　"まで"を表示

	public void draw() {
		System.out.println("[線を描画] 始点(" + p1.getX() + "," + p1.getY() + ")から終点(" + p2.getX() + "," + p2.getY() + ")まで");
	}

	/**
	 * 始点データと終点データを使い、以下の計算式で算出した結果を返す。
	　　　　(( 終点のx座標 - 始点のx座標 ) ^2
	　　　　　　+ ( 終点のy座標 - 始点のy座標 ) ^2 ) の平方根
	
	　　　　累　乗...Math.powメソッド
	　　　　平方根...Math.sqrtメソッド
	 */

	//メモ↓戻り値はdouble
	//　　　メソッドはgetPerimeter
	//　　　引数はなし
	public double getPerimeter() {
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + (Math.pow(p2.getY() - p2.getY(), 2)));
	}

}