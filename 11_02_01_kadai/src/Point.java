//座標位置情報を表すクラス
public class Point {

	//x座標を表すprivateフィールド
	private int x;
	
	//y座標を表すprivateフィールド
	private int y;
	
	/**
	 * 引数なしコンストラクタの定義
	 * x座標、y座標ともに0で初期化する。
	 */
	
	public Point() {
		this.x = 0;
		this.y = 0;
		
		/**
		 *x座標、y座標を受け取りその値で初期化するコンストラクタの定義
		 *第1引数で渡された値をxフィールドに代入する。
		 *第2引数で渡された値をyフィールドに代入する。 
		 * @param x
		 * @param y
		 */
		
	public Point (int x, int y) {
	    this.x = x;
	    this.x = y;
	    
	    /**
	     * xフィールドの値を返すメソッド
	     * @return
	     */
	    
	public int getX() {
		return this.x;
	}
	
	/**
	 * 引数で渡された値を、xフィールドにセットするメソッド
	 * @param x
	 */
	
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * yフィールドの値を返すメソッド
	 * @return
	 */
		
	public int getY() {
		return this.y;
	}
	/**
	 * 引数で渡された値を、yフィールドにセットするメソッド
	 * @param y
	 */
	public void setY(int y) {
	    this.y = y;
	}
}