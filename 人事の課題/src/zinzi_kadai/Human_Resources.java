package zinzi_kadai;


//メモ↓extends Employeeで継承を宣言する
//　　　※「HumanResourceクラスは、Employeeクラスの子クラスです」と宣言
public class HumanResource extends Employee {
	
	
	//メモ↓new HumanResourceのように、このクラスのインスタンスが生成されるときに呼び出される
	//　　　Employeeのコンストラクタを、引数nameと、固定の文字列"人事"で呼び出してください」と命令
	//　　　super()呼び出しは親のルールに従い必要な情報を報告
	//　　　HumanResourceのインスタンスは、"人事"に設定された状態
	//　　　

    public HumanResource(String name) {
    	//メモ↓super(name, "人事")親クラスのコンストラクタを呼び出す
        super(name, "人事");
    }

    
    //メモ↓boolean isHiredで「採用」か「不採用」かをtrue/falseで受け取る
    //　　　Employee targetEmployeeで採用するとき従業員のインスタンスを受け取る
    //　　　if (isHired): もし採用（isHiredがtrue）なら、t.createEmployee(targetEmployee, this)
    //　　　会社インスタンスbtのcreateEmployeeメソッドを呼ぶ
    //　　　
    public void conductInterview(boolean isHired, Employee targetEmployee, BT bt) {
    	//メモ↓採用（結果がtrue）になる場合は表示する
        if (isHired) {
            System.out.println("面接を行い、結果は「採用」だった");
            //メモ↓BTクラスの従業員作成メソッドを呼び出す
            bt.createEmployee(targetEmployee, this);
            //メモ↓不採用（結果がelse）になる場合は表示する
        } else {
            System.out.println("面接を行い、結果は「不採用」だった");
        }
    }
}