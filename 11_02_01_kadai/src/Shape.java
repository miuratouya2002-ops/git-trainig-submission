//図形描画アプリケーションの共通機能2つを定義する。

//メモ　abstractで抽象メソッドを宣言
public abstract class Shape implements Figure {

	//図形描画機能の定義

	//メモ　戻り値なしでvoid
	//　　　引数なしのメソッドdrawを定義
	public abstract void draw();

	//長さ測定機能の定義

	//メモ　戻り値がdouble
	//　　　引数なしのメソッドgetPerimeterを定義
	public abstract double getPerimeter();
}