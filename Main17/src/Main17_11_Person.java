//例外インスタンスを自分で投げる
public class Main17_11_Person {
	int age;

	public void setAge(int age) {
		//引数をチェック
		if (age < 0) {
			throw new IllegalArgumentException("年齢は0以上の数を指定すべきです。指定値=" + age);
		}
		//問題ないなら、フィールドに値をセット
		this.age = age;
	}
}
