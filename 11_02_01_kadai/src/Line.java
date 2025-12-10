//Lineに
public abstract class Line implements Figure {
	private Point p1;
	private Point p2;
	
	//クラスから実物を作る作業がnew、PointはクラスなのでPointだけではメソッドの実行だからエラーになる
	public Line() {
		this.p1 = new Point(0, 0);
		this.p2 = new Point(0, 0);
	}
	
	public Line(int x1, int y1, int x2, int y2) {
		this.p1 = new Point();
		this.p2 = new Point();
	}
}