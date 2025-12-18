package zinzi_kadai;

public class Engineer extends Employee {
	//メモ↓Languageを定義する
	protected String Language;

	//メモ↓メソッドはEngineer
	//　　　引数はString nameとLanguage
	public Engineer(String name, String Language) {
		//メモ↓super(name, "エンジニア")親クラスのコンストラクタを呼び出す
		super(name, "エンジニア");

		//メモ↓Languageを代入
		this.Language = Language;
	}

	//メモ↓戻り値なし
	//　　　メソッドはdevelopment
	//　　　引数はなし
	public void development() {
		System.out.println(Language + "で開発を行なった");
	}

	//メモ↓戻り値なし
	//　　　メソッドはInformation
	//　　　引数なし
	public void Information() {
		System.out.println(this.name + ":所属部署" + this.Language + " :使用言語");

	}
}

/*エンジニアクラス extends 従業員クラス（Engineer）		
属性	
	使用言語・・・使用している言語（java, pythonなど）
操作	
	開発実施・・・「{使用言語}で開発を行なった」と出力
	情報表示・・・「{名前}：{所属部署}　使用言語：{使用言語}」と出力
*/