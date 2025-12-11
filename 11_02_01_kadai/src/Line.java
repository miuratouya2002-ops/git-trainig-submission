//2つの座標データを指定することで、線を描画するクラス
//線描画メソッド
//線の長さを取得するメソッド

//引数なしコンストラクタの定義
//p1(x,y座標)、p2(x,y座標)全て0で初期化する。
public abstract class Line implements Figure {
	private Point p1;
	private Point p2;
	
	//引数で受け取ったデータを用いて、2つのPointオブジェクトを生成。
	//p1フィールドとp2フィールドにそれぞれを代入する。
	//クラスから実物を作る作業がnew、PointはクラスなのでPointだけではメソッドの実行だからエラーになる
	
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
	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new Point();
		this.p2 = new Point();
	}
	
	//以下のようなメッセージを表示する。なお、始点をp1、終点をp2とする。
	//出力例："[線を描画] 始点(0,0)から終点(100,100)まで"
	public void draw() {
		System.out.println("[線を描画] 始点" + p1.getX() + "から終点" + p2.getY() + "まで");
	}
	
	public double getPerimeter() {
		
	}
	
}