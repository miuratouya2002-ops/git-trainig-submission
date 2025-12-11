//中心座標と半径を指定することで、円を描画するクラス
public class Circle extends Shape {
	//円描画メソッド
	private Point center;
	//円周の長さを取得するメソッド
	private int radius;

	//引数なしコンストラクタの定義
	//center(x,y座標)、半径全て0で初期化する
	public Circle() {
		this.center = new Point();
		this.radius = 0;
	}

	/**
	 * 3つのint型データ
	 * @param x
	 * @param y
	 * @param r
	 */
	public Circle(int x, int y, int r) {
		//引数x,yで受け取ったデータを用いて、1つのPointオブジェクトを生成し、centerフィールドに代入する。
		this.center = new Point(x, y);
		//引数rもradiusフィールドに代入する。
		this.radius = r;
	}

	public void draw() {
		int x = 0;
		x = this.center.getX();
		System.out.println(x);
		int y = 0;
		y = this.center.getY();
		System.out.println(x);
		System.out.println("[円を描画] 中心点"(x + "," + y) "から半径" ∔ this.radius);
		
	}

	public double getPerimeter() {
		return radius * 2 * Math.PI;

	}

}