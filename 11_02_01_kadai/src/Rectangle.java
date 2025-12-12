//・1つの位置座標と幅、長さを指定することで、長方形(矩形)を描画するクラス
//長方形描画メソッド
//長方形の周囲の長さを取得するメソッド

//メモ↓クラスはRectangle
//　　　継承元はPolygon
//　　　継承先はRectangle
//　　　extendsで継承させる
public class Rectangle extends Polygon {
	
	//・長方形の基準の位置を表すPoint型protectedフィールド
	//・長方形の横幅を表すprotectedフィールド
	//・長方形の縦幅を表すprotectedフィールド
	
	//メモ↓protectedは自分と同じパッケージに属するか、自分を継承した子クラス
	//　　　pフィールドのPoint型
	//　　　widthフィールドのint型
	//　　　heightフィールドのint型
	protected Point p;
	protected int width;
	protected int height;

	//4つのint型データ
	//xとy...pフィールドに代入するPoint型変数のx,y座標値
	//width...長方形の横幅
	//height...長方形の縦幅
	//第1引数と第2引数で受け取ったデータを用いて、1つのPointオブジェクトを生成し、pフィールドに代入する。
	//第3引数と第4引数をそれぞれwidthフィールド、heightフィールドに代入する。
	//スーパークラス内で定義されているangleフィールドに4を代入する。
	
	//メモ↓戻り値なし
	//　　　メソッドはRectangle
	//　　　引数はx,y,width,height
	public  Rectangle(int x,int y,int width,int height) {
		//メモ↓newでインスタンスを生成
		//　　　Pointにx,yを代入
		//　　　pフィールドに代入する
		this.p = new Point(x, y);
		//メモ↓this.wisthにwidthを代入する
		this.width = width;
		//メモ↓this.heightにheightを代入する
		this.height = height;
		//メモ↓angleフィールドに4を代入する
		super.angle = 4;
	}
	
	//以下のようなメッセージを表示する。
	//出力例：
	//"[長方形(矩形)を描画] 点(0,0)を基準として幅100、高さ50の長方形"
	
	//メモ↓戻り値なし
	//　　　メソッドdraw
	//　　　引数なし
	public void draw() {
		//メモ↓System.out.printlnで表示
		//　　　"[長方形(矩形)を描画] 点"を表示
		//　　　
		System.out.println("[長方形(矩形)を描画] 点" + p.getX() + p.getY() + "を基準として幅" + this.width + this.height);
	}
	
	//横幅と縦幅を使い、以下の計算式で算出した結果を返す。
	//( width + height ) * 2
	public double getPerimeter() {
		return this.width + this.height * 2;
	}
	
}