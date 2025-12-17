package zinzi_kadai;

//メモ↓abstractでEmployeeを抽象クラスとして宣言する
//　　　抽象クラスはnewによるインスタンス生成はできない
//　　　クラスEmployee（従業員）は未実装で実装させるのはSales（営業）やEngineer（エンジニア）
public abstract class Employee {
	//メモ↓nameとAffiliatedCompanyを定義する
	protected String name;
	protected String AffiliatedCompany;

	//メモ↓nameとAffiliatedCompanyを格納する
	public Employee(String name, String AffiliatedCompany) {
		//メモ↓自分自身のnameフィールド
		this.name = name;
		//メモ↓自分自身のAffiliatedCompanyフィールド
		this.AffiliatedCompany = AffiliatedCompany;
	}

	//メモ↓戻り値なし
	//　　　abstractで抽象
	public abstract void InformationDisplay();

	//メモ↓Nameメソッドを追加する
	public String getName() {
		//メモ↓returnで値を返す
		//　　　nameフィールドの中身を呼び出し元に返している
		return this.name;
	}
		
		//メモ↓Interviewメソッドを作成してい定義
		//　　　boolean型のRecruitment変数（採用）
		public void interview(boolean Recruitment, Employee name, BT bt) {
	        if (Recruitment) {
	        	//メモ↓結果は採用
	            System.out.println("面接を行い、結果は「採用」だった");
	            //メモ↓BTクラスの従業員作成メソッドを呼び出す
	            public bt createEmployee();
	            //メモ↓elseの場合は不採用にする
	        } else {
	            System.out.println("面接を行い、結果は「不採用」だった");
	        }
	    }
	    //メモ↓給与計算を定義
	    //　　　Employee empとして、給与計算の対象となる従業員を一人受け取る
	    //　　　型がEmployeeでどんな部署の従業員の給与でも計算できる
	    public void calculateSalary(Employee emp) {
	        System.out.println(emp.getName() + "の給与を計算します。");
	    }

	    //メモ↓親クラスであるEmployeeが持っていた抽象メソッドInformationDisplay()を実装（オーバーライド）している
	    //　　　this.name / this.department→親から受け継いだフィールドを使った
	    public void displayInfo() {
	        System.out.println("名前：" + this.name + " 所属部署：" + this.AffiliatedCompany);
	    }
}


/*	abstract 従業員クラス（Employee）		
属性	
名前・・・社員の名前
所属部署・・・所属している部署名
操作	
abstract 情報表示
*/