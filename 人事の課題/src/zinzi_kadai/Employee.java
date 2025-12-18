//従業員
//人事、営業、エンジニアの継承元
package zinzi_kadai;

public abstract class Employee {
	//メモ↓フィールド名を「department」に統一
	//　　　protectedが自分と同じパッケージに属するか、自分を継承した子クラス
	//　　　nameフィールドを定義
	//　　　departmentフィールドを定義
	protected String name;
	protected String department;

	//メモ↓Employee（従業員）メソッドにname,departmentを格納
	public Employee(String name, String department) {
		//メモ↓name(引数)をthis.nameに代入
		this.name = name;
		//メモ↓department(引数)をthis.departmentに代入
		this.department = department;
	}

	//メモ↓抽象メソッド名をdisplayInfo
	public abstract void displayInfo();

	//メモ↓getでnameを持ってくる
	public String getName() {
		//メモ↓returnでthis.nameの値を返す
		return this.name;
	}
}