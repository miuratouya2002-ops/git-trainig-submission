//エンジニア部門
package zinzi_kadai;

//クラスがEngineer
//継承元がEmployeeで継承先がEngineer
public class Engineer extends Employee {
	//属性を入れるため、フィールドを定義
	//language変数に言語(Java,Python)が入る
	private String language;

	//メソッドがEngineer
	//String name, String languageが格納
	public Engineer(String name, String language) {
		//superで継承元のEmployeeのnameのデータを引き継ぐ
		super(name, "エンジニア");
		//フィールドにlanguageを代入
		this.language = language;
	}

	// メソッド名がdevelop
	public void develop() {
		//this.language→Jave+で開発を行なったと表示
		System.out.println(this.language + "で開発を行なった");
	}

	// メソッドがdisplayInfo（表示情報）
	public void displayInfo() {
		//出力内容
		//this.name→名前で佐藤
		//this.department→部門でエンジニア
		//this.language→言語でJava
		System.out.println(this.name + "：" + this.department + " 使用言語：" + this.language);
	}
}