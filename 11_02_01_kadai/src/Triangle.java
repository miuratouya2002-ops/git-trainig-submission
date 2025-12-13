// 3つの座標データを指定することで、三角形を描画するクラス
//三角形描画メソッド
//三角形の周囲の長さを取得するメソッド
//メモ↓classはTriangle
//      継承元がPolygon
//　　　継承先がTriangle
//　　　extendsを使って継承させる

public class Triangle extends Polygon {

	//三角形の点1を表すPoint型privateフィールド
	//三角形の点2を表すPoint型privateフィールド
	//三角形の点3を表すPoint型privateフィールド

	//メモ↓型はPoint
	//　　　フィールドはp1
	//　　　フィールドはp2
	//　　　フィールドはp3

	private Point p1;
	private Point p2;
	private Point p3;

	//引数で受け取ったデータを用いて、3つのPointオブジェクトを生成。
	//p1フィールドとp2フィールド、p3フィールドにそれぞれを代入する。
	//スーパークラス内で定義されているangleフィールドに3を代入する。

	//メモ↓メソッドはTriangle
	//　　　型はint
	//　　　引数でx1, y1, x2, y2, x3, y3というデータを受け取る
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		//メモ↓newで3つのPointインスタンスを生成
		//　　　生成した3つのインスタンスにx1,y1,x2,y2,x3,y3をそれぞれ代入
		//　　　p1フィールドにはx1,y1を代入
		//　　　p2フィールドにはx2,y2を代入
		//　　　p3フィールドにはx3,y3を代入
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		this.p3 = new Point(x3, y3);

		//スーパークラスでangleを定義
		//angleに3を代入
		super.angle = 3;
	}

	//以下のようなメッセージを表示する。
	//出力例：
	//"[三角形を描画] 点1(0,0)から点2(100,100)、点3(0, 200)の三角形"

	//メモ↓戻り値なし
	//　　　メソッドはdraw
	//　　　引数はなし
	public void draw() {
		//メモ↓System.out.printlnで表示
		//　　　"[三角形を描画] 点1"を表示
		//　　　getを使ってp1フィールドのXにアクセス
		//　　　getを使ってp1フィールドのYにアクセス
		//　　　"から点2"を表示
		//　　　getを使ってp2フィールドのXにアクセス
		//　　　getを使ってp2フィールドのYにアクセス
		//　　　"点3"を表示
		//　　　getを使ってp3フィールドのXにアクセス
		//　　　getを使ってp3フィールドのYにアクセス
		//　　　"の三角形"を表示
		//　　　それぞれ+
		System.out.println("[三角形を描画] 点1(" + p1.getX() + "," + p1.getY() + ")から点2(" + (p2.getX()) + "," + (p2.getY()) + ")点3("  + (p3.getX())
				+ "," + (p3.getY()) + ")の三角形");
	}
	
	//3つの座標を使い、以下の計算式で算出した結果を返す。
    //p1からp2までの長さ + p2からp3までの長さ + p3からp1までの長さ
	public double getPerimeter() {
		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + (Math.pow(p2.getY() - p2.getY(), 2)));
	}
}