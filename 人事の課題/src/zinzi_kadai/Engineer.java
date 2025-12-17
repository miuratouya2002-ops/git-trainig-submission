package zinzi_kadai;

public class Engineer extends Employee {
	//Languageを定義する
	protected String Language;
	//メソッドはEngineer
	//引数はString name
	//
	public Engineer(String Language) {
		
		super(Language, "エンジニア");
		
	}
	
	public void development() {
		System.out.println({}"で開発を行なった");
	}
	
	public void Information(String , ) {
		System.out.println({名前}:{所属部署}, {使用言語}:{使用言語});
		
	}
}

/*エンジニアクラス extends 従業員クラス（Engineer）		
属性	
	使用言語・・・使用している言語（java, pythonなど）
操作	
	開発実施・・・「{使用言語}で開発を行なった」と出力
	情報表示・・・「{名前}：{所属部署}　使用言語：{使用言語}」と出力
*/