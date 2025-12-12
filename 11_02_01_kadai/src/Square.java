//・1つの位置座標と幅を指定することで、正方形を描画するクラス
//・正方形描画メソッド

public class Square extends Rectangle {

	//3つのint型データ
	//xとy...pフィールドに代入するPoint型変数のx,y座標値
	//width...正方形の一辺の長さ

	//スーパークラスRectangleのコンストラクタを明示的に呼び出す。
	//引数は以下の通りとする。
	//第1引数...Point型データのx座標
	//第2引数...Point型データのy座標
	//第3引数...正方形の一辺の長さ
	//第4引数...正方形の一辺の長さ

	//メモ↓メソッドはSquare
	//　　　
	public Square(int x, int y, int width) {
		this.p = new Point(x, y);
		this.width = width;
		super(Rectangle);

	}

	//以下のようなメッセージを表示する。
	//出力例：
	//"[正方形を描画] 点(0,0)を基準として幅・高さ200の正方形"

	//メモ↓
	public void draw() {
		//メモ↓..
		System.out.println("[正方形を描画]点" + p.getX() + p.getY() + "を基準として幅・高さ" + width.getWidth + "の正方形" )
	}
}