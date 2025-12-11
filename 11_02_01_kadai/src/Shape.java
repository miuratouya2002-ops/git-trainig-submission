//図形描画アプリケーションの共通機能2つを定義する。

public abstract class Shape implements Figure {

//図形描画機能の定義
	public abstract void draw();
	
//長さ測定機能の定義
	public abstract void getperimeter();
}