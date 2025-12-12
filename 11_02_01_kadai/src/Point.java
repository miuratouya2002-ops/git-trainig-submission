//座標位置情報を表すクラス

//メモ　classはPoint
public class Point {

	//x座標を表すprivateフィールド
	
	//メモ　型がintの属性がxのprivateフィールド
	private int x;
	
	//y座標を表すprivateフィールド
	
	//メモ　型がintの属性がyのprivateフィールド
	private int y;
	
	
	/**
	 * 引数なしコンストラクタの定義
	 * x座標、y座標ともに0で初期化する。
	 */
	
	//メモ　引数なしで定義
	//　　　this.にして自分自身のxとyの値を0に初期化
	public Point() {
		this.x = 0;
		this.y = 0;
	}
		
		/**
		 *x座標、y座標を受け取りその値で初期化するコンストラクタの定義
		 *第1引数で渡された値をxフィールドに代入する。
		 *第2引数で渡された値をyフィールドに代入する。 
		 * @param x
		 * @param y
		 */
		
	//メモ　引数int型のx,yの値を受け取る
	//　　　その値で引数int x, int yで渡される
	//　　　区別するためにthis.にして受け取ったxとyの値をxフィールド、yフィールドに代入
	public Point (int x, int y) {
	    this.x = x;
	    this.x = y;
	}
	    
	    /**
	     * xフィールドの値を返すメソッド
	     * @return
	     */
	    
	//メモ　戻り値はint引数はなし
	//　　　getX()でxフィールドの値を持ってくる
	//　　　returnで持ってきたxフィールドの値を返す
	public int getX() {
		return this.x;
	}
	
	/**
	 * 引数で渡された値を、xフィールドにセットするメソッド
	 * @param x
	 */
	
	//メモ　戻り値なしで引数int型の値はx
	//　　　引数で渡されたxをsetXでセットになる
	//　　　区別するためにthis.をつけてxフィールドにセットする
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * yフィールドの値を返すメソッド
	 * @return
	 */

	//メモ　戻り値がintで引数はなし
	//　　　getY()でyフィールドの値を持ってくる
	//　　　returnで持ってきたyフィールドの値を返す
	public int getY() {
		return this.y;
	}
	/**
	 * 引数で渡された値を、yフィールドにセットするメソッド
	 * @param y
	 */
	
	//メモ　戻り値なしで引数int型の値はx
	//　　　引数で渡されたxをsetYでセットになる
	//　　　区別するためにthis.をつけてyフィールドにセットする
	public void setY(int y) {
	    this.y = y;
	}
}