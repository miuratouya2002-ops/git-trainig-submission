//中心座標と半径を指定することで、円を描画するクラス
//円描画メソッド
//円周の長さを取得するメソッド

//メモ↓クラスはcircle
//　　　Shapeは継承元
//　　　Circleが継承先
//　　　extemdsで継承元を指定
//　　　型がPoint
//　　　フィールドをcenter
//　　　円の中心を表すのがcenter
//　　　型がint
//　　　フィールドをradius
//　　　円の半径を表すのがradius

public class Circle extends Shape {
	private Point center;
	private int radius;

	//引数なしコンストラクタの定義
	//center(x,y座標)、半径全て0で初期化する
	
//メモ↓メソッドはCircle
//　　　引数はなし
//　　　戻り値なし
//　　　newでインスタンスを生成できる
//　　　引数で受け取って1つのインスタンス（実体）生成
//　　　区別するためにthis.をつける
//　　　円の中心がcenter
//　　　centerの2つの値を初期化（0）する
//　　　半径がradius
//　　　radiusの値を初期化（0）する
	public Circle() {
		this.center = new Point(0, 0);
		this.radius = 0;
	}

	/**
	 * 3つのint型データ
	 * @param x
	 * @param y
	 * @param r
	 */
	
	//メモ↓メソッドはCircle
	//　　　戻り値はなし
	//　　　引数としてint x, int y, int rを受け取る
	//　　　centerフィールドを定義
	//　　　newで新しくインスタンスを生成
	//　　　centerフィールドのPoint型に値が(0, 0)のところにx, yを代入
	//　　　radiusフィールドを定義
	//　　　radiusフィールドの値が0のところにrを代入
	public Circle(int x, int y, int r) {
		//引数x,yで受け取ったデータを用いて、1つのPointオブジェクトを生成し、centerフィールドに代入する。
		this.center = new Point(x, y);
		//引数rもradiusフィールドに代入する。
		this.radius = r;
	}
	//メモ↓メソッドはdraw
	//　　　戻り値はなしでvoid
	//　　　引数はなし
	
	public void draw() {
	//メモ↓int型のxの値は0
		int x = 0;
	//メモ↓centerフィールドにgetX()でxフィールドの値を持ってくる
		x = this.center.getX();
	//メモ↓System.out.printlnで(x)を表示
		System.out.println(x);
	//メモ↓yの値は0
		int y = 0;
	//メモ↓centerフィールドにgetY()でyフィールドの値を持ってくる
		y = this.center.getY();
	//メモ↓System.out.printlnで(y)を表示
		System.out.println(y);
	//メモ↓System.out.printlnで()内を表示
	//　　　"[円を描画] 中心点"を表示
	//　　　center.getX
		System.out.println("[円を描画] 中心点(" + this.center.getX() + "," + this.center.getY() + ")から半径" + this.radius);
	}
	
	//　戻り値はdouble
	//　メソッドはgetPerimeter
	//　引数はなし
	//　radius（半径）の値をreturn（返す）する
	//　円周率はMath.PIフィールド
	public double getPerimeter() {
		return radius * 2 * Math.PI;
	}

}