package 人事の課題;

//メモ↓abstractでEmployeeを抽象クラスとして宣言する
//　　　抽象クラスはnewによるインスタンス生成はできない
//　　　Employee（従業員）は未実装で実装させるのはSales（営業）やEngineer（エンジニア）
public abstract class Employee {
	//メモ↓nameとAffiliatedCompanyを定義する
	String name;
	String AffiliatedCompany;

	//メモ↓nameとAffiliatedCompanyを格納する
	public Employee(String name, String AffiliatedCompany) {
		//メモ↓自分自身のnameフィールド
		//　　　自分自身のAffiliatedCompanyフィールド
		this.name = name;
		this.AffiliatedCompany = AffiliatedCompany;
	}

	//メモ↓戻り値なし
	//　　　abstractで抽象
	public abstract void InformationDisplay();

	//メモ↓getNameメソッドを追加する
	public String Name() {
		//メモ↓returnで値を返す
		//　　　nameフィールドの中身を呼び出し元に返している
		return this.name;
	}
}