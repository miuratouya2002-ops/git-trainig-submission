//抽象表現である「図形」クラスの定義

//メモ　interfaceはFigure
public interface Figure {
	
//図形描画機能の定義

//メモ　戻り値なしのメソッドdraw
	public void draw();
	
//長さ測定機能の定義
	
//メモ　戻り値doubleのメソッドgetPerimeter
	public double getPerimeter();
}
