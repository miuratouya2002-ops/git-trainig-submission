//Main
package zinzi_kadai;

public class Main {
    public static void main(String[] args) {
    	System.out.println("---会社---");
        System.out.println("BTカンパニーを設立します");
        //
        BT company = new BT();
        //
        System.out.println(company.getCompanyName() + "社が設立されました。");
        
        System.out.println("---採用---");
        System.out.println("最初の従業員（人事部）を採用します");
        HumanResource tanaka = new HumanResource("田中");
        company.createEmployee(tanaka, tanaka);
        
        System.out.println("人事部による採用活動を開始します");
        Sales suzuki = new Sales("鈴木");
        Engineer sato = new Engineer("佐藤", "Java");

        System.out.println("【鈴木さん(営業)の面接】");
        tanaka.conductInterview(true, suzuki, company);

        System.out.println("【佐藤さん(エンジニア)の面接】");
        tanaka.conductInterview(true, sato, company);

        System.out.println("【山田さん(営業)の面接】");
        Sales yamada = new Sales("山田");
        tanaka.conductInterview(false, yamada, company);
        System.out.println("------------------------------------");
        
        company.displayAllEmployees();
        
        Engineer takahashi = new Engineer("高橋", "Python");
        company.createEmployee(takahashi, suzuki);
        System.out.println("----------------------------------------------------------------");

        company.displayAllEmployees();
        
        suzuki.arrangeMeeting(sato);
        sato.develop();
        tanaka.calculateSalary(sato);
    }
}
