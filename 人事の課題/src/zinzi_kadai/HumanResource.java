//人事部門
package zinzi_kadai;

//メモ↓クラスはHumanResource（人事）
//　　　継承元がEmployee（従業員）で継承先がHumanResource（人事）
public class HumanResource extends Employee {

	//メモ↓メソッドがHumanResource
	//　　　引数がString name
	public HumanResource(String name) {
		//super
		super(name, "人事");
	}

	//メモ↓戻り値なし
	//　　　メソッドがconductInterview（インタビューする）
	//　　　bookean型でisHired（雇用）という変数にした
	//　　boolean isHired, Employee targetEmployee, BT btを引数に格納する
	public void conductInterview(boolean hired, Employee targetEmployee, BT bt) {
		if (hired) {
			System.out.println("面接を行い、結果は「採用」だった");
			bt.createEmployee(targetEmployee, this);
		} else {
			System.out.println("面接を行い、結果は「不採用」だった");
		}
	}

	//メモ↓メソッドがalculateSalary（給与計算）
	//　　　引数がEmployee emp
	public void calculateSalary(Employee emp) {
		//getNameで持ってくる
		System.out.println(emp.getName() + "の給与計算をおこなった。");
	}

	//メモ↓メソッドがdisplayInfo（表示情報）
	public void displayInfo() {
		System.out.println(this.name + "：" + this.department);
	}
}