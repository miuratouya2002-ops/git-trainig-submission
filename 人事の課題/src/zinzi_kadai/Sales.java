//営業部門
package zinzi_kadai;

//メモ↓クラスがSales（営業）
//　　　継承元がEmployee（従業員）で継承先がSales（営業）
public class Sales extends Employee {

	//メモ↓Salesにnameを格納
	public Sales(String name) {
		//superで親クラス（Employee）のコンストラクタの呼び出し
		//→name
		super(name, "営業");
	}

	//戻り値なし
	//replyWeeklyReport（週報返信）メソッド
	//引数なし
	//※replyWeeklyReportは完全に新しく作ったもので、表示させるだけだから引数はいらない
	public void replyWeeklyReport() {
		System.out.println("週報の返信をした");
	}

	//戻り値なし
	//arrangeMeeting
	//引数がEngineer engineer
	public void arrangeMeeting(Engineer engineer) {
		//getName()で継承元(Employee)のnameを持ってきた
		System.out.println(engineer.getName() + "の面談を組んだ");
	}

	public void displayInfo() {
		// フィールド名を「department」に修正
		//this.name→(名前で鈴木) : this.department→(部門で営業)
		System.out.println(this.name + "：" + this.department);
	}
}