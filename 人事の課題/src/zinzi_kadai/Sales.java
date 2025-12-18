package zinzi_kadai;

//メモ↓クラスは営業
//　　　extendsで継承
//　　　Employee（従業員）から引き継ぐ
public class Sales extends Employee {

	//メモ↓メソッドはSales
	//　　　Salesの引数はString name
	public Sales(String name) {
		//メモ↓親クラスのEmployeeからコンストラクタを呼び出した
		//　　　名前と、固定の部署名「営業」を渡す
		super(name, "営業");
	}

	//戻り値なし
	//メソッドはreplyWeekReport()
	//引数はなし
	public void replyWeeklyReport() {
		System.out.println("週報の返信をした");
	}

	//戻り値なし
	//メソッドはarrangeMeeting
	//引数はEngineer engineerになる
	public void arrangeMeeting(Engineer engineer) {
		// 引数で受け取ったengineerインスタンスの名前を取得して表示する
		System.out.println("「" + engineer.getName() + "の面談を組んだ」");
	}

	//戻り値なし
	//メソッドはhaveMeeting()
	//引数はなし
	public void haveMeeting() {
		System.out.println("新規の打ち合わせをした");
	}

	//メモ↓戻り値なし
	//　　　displayInfoメソッド
	//　　　引数なし
	@Override
	public void displayInfo() {
		//メモ↓親から受け継いだnameとdepartmentフィールドを使って情報を表示する
		//　　　従業員情報を表示する（親クラスの抽象メソッドを実装
		System.out.println("「" + this.name + "：" + this.AffiliatedCompany + "」");
	}
}

/*
	営業クラス extends 従業員クラス（Sales）		
		操作	
			週報返信・・・「週報の返信をした」と出力
			面談組む（引数：エンジニア）・・・「{エンジニア.名前}の面談を組んだ」と出力
			打ち合わせ・・・「新規の打ち合わせをした」と出力
			情報表示・・・「{名前}：{所属部署}」を出力する

*/