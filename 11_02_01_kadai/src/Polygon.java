//図形描画アプリケーションの共通機能3つを定義する。
//図形描画機能
//長さ測定機能
//内角の和測定機能
public abstract class Polygon extends Shape {
	protected int angle;

	//図形描画機能の定義

	//メモ↓引数なし
	//　　　戻り値なし
	//　　　メソッドはdraw
	public abstract void draw();

	//長さ測定機能の定義

	//メモ↓引数なし
	//　　　戻り値はdouble
	//      メソッドはgetPerimeter()
	public abstract double getPerimeter();

	//angleフィールドを使い、内角の和を算出する
	//例）n角形の場合　　(n - 2) * 180

	//メモ↓引数はなし
	//　　　戻り値はint
	//　　　メソッドはgetInternalAngle
	public int getInternalAngle() {
		//メモ↓内角(辺)の数を表すのはangle
		//　　　returnで値をangleフィールドの値を返す		
		return (this.angle - 2) * 180;
	}
}