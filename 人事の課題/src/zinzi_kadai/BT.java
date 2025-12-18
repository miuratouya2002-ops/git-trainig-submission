//会社
package zinzi_kadai;

import java.util.ArrayList;
import java.util.List;

public class BT {
	// 変数名(定数名)をJavaの慣習に合わせる
	private static final String COMPANY_NAME = "BT";
	//フィールド名がemployeeList
	private List<Employee> employeeList;
	//フィールド名がdepartmentList
	private List<String> departmentList;

	public BT() {
		//
		this.employeeList = new ArrayList<>();
		// 変数名を「departmentList」
		this.departmentList = new ArrayList<>();
		this.departmentList.add("人事");
		this.departmentList.add("営業");
		this.departmentList.add("エンジニア");
	}

	// ゲッターメソッドを追加
	public String getCompanyName() {
		return COMPANY_NAME;
	}

	public void createEmployee(Employee employee, Employee caller) {
		//
		if (caller instanceof HumanResource) {
			System.out.println("従業員の作成は人事部の社員しか行えません。");
			return;
		}
		System.out.println(employee.getName() + "さんを従業員リストに追加しました。");
		this.employeeList.add(employee);
	}

	public void displayAllEmployees() {
		System.out.println("---従業員---");
		for (Employee emp : this.employeeList) {
			emp.displayInfo();
		}
		System.out.println("--------------------");
	}
}
