//中心座標と半径を指定することで、円を描画するクラス
public class Circle extends Shape {
	//円描画メソッド
	private Point center;
	//円周の長さを取得するメソッド
	private int radius;
	
	//引数なしコンストラクタの定義
	public  Circle() {
		this.center = new Point();
		this.radius = 0;
	}
	
	public Circle(int x,int y,int r) {
		this.center = new Point(x, y);
		this.radius = r;
	}
	
	public void draw() {
		int x = 0;
		int y = 0;
		this.center = 
		
	}
	
	
}