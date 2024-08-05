package lesson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees {
    
    public static void main (String[] args) {
        
        try {
            Connection con = null;
            Statement statement = null;
            con = DriverManager.getConnection ("jdbc:mariadb://localhost/employees", "admin1", "misha208");
            
            statement = con.createStatement ();
            System.out.println ("データベース接続成功");
            
            // 問題１
            String sql1 = "SELECT * FROM employees WHERE employees.birth_date LIKE '1965_01_%' ;";
            
            ResultSet result = statement.executeQuery (sql1);
            while (result.next ()) {
                int emp_no = result.getInt ("emp_no");
                Date birth_date = result.getDate ("birth_date");
                String first_name = result.getString ("first_name");
                String last_name = result.getString ("last_name");
                int rowCnt = result.getRow ();
                System.out.println (
                        rowCnt + ": 従業員番号 " + emp_no + " 誕生日 " + birth_date + " 名前 " + first_name + " " + last_name);
            }
            
            // 問題2
            String sql2 = "SELECT COUNT(gender) FROM employees WHERE gender = ? ;";
            PreparedStatement pstatement = con.prepareStatement (sql2);
            
            String genders[] = { "F", "M" };
            
            for (String gender : genders) {
                pstatement.setString (1, gender);
                ResultSet result2 = pstatement.executeQuery ();
                result2.next ();// A ResultSet cursor is initially positioned before the first row; the first
                                // call to the method next makes the first row the current row; the second call
                                // makes the second row the current row, and so on.
                int num = result2.getInt (1);
                String gen = switch (gender) {
                    case "F" -> "女性";
                    case "M" -> "男性";
                    default -> throw new IllegalStateException ("例外発生");
                };
                System.out.println (gen + "は" + num + "人");
            }
            
            // 問題3(dept_name)ごとに所属する社員の数を抽出
            String sql3 = "SELECT dept_name, COUNT(*) FROM dept_emp INNER JOIN employees ON dept_emp.emp_no = employees.emp_no INNER JOIN departments ON dept_emp.dept_no = departments.dept_no GROUP BY dept_name ; ";
            Statement statement3 = con.createStatement ();
            ResultSet result3 = statement3.executeQuery (sql3);
            while (result3.next ()) {
                String dept_name = result3.getString ("dept_name");
                int cnt = result3.getInt (2);
                System.out.println (dept_name + "は" + cnt + "人");
            }
            
            // 問題4それぞれの部署の現在のマネージャー名を抽出
            String sql4 = "SELECT  dept_name,first_name , last_name FROM (dept_manager INNER JOIN employees ON dept_manager.emp_no = employees.emp_no INNER JOIN departments ON departments.dept_no = dept_manager.dept_no) WHERE to_date LIKE '9%' ;";
            ResultSet result4 = statement.executeQuery (sql4);
            while (result4.next ()) {
                String dept_name = result4.getString ("dept_name");
                String first_name = result4.getString ("first_name");
                String last_name = result4.getString ("last_name");
                System.out.println (dept_name + "の現在のマネージャーは" + first_name + " " + last_name + "です");
            }
            
            // 問題５社員番号が10001から10100までで、名前(first_name)がPから始まる人を抽出
            String sql5 = "SELECT emp_no, first_name, last_name FROM employees WHERE 10001 <= emp_no && emp_no <= 10100 && first_name LIKE 'P%'";
            ResultSet result5 = statement.executeQuery (sql5);
            while (result5.next ()) {
                int emp_no = result5.getInt ("emp_no");
                String first_name = result5.getString ("first_name");
                String last_name = result5.getString ("last_name");
                System.out.println (emp_no + " : " + first_name + " " + last_name);
            }
            
            // 問題６1995年か1997年にdept_noがd005若しくはd008に所属していた社員の社員番号と部署番号
            String sql6 = "select emp_no , dept_no ,from_date,to_date from dept_emp WHERE (dept_no = 'd004'|| dept_no = 'd008') &&((from_date<='1995_01_01' && to_date >= '1995_01_01')||(from_date<='1997_01_01' && to_date >= '1997_01_01'));";
            ResultSet result6 = statement.executeQuery (sql6);
            while (result6.next ()) {
                int emp_no = result6.getInt ("emp_no");
                String dept_no = result6.getString ("dept_no");
                Date from_date = result6.getDate ("from_date");
                Date to_date = result6.getDate ("to_date");
                int rowCnt = result6.getRow ();
                System.out.println (rowCnt + " :従業員番号 " + emp_no + " :部署番号 " + dept_no + " :" + from_date + " から "
                        + to_date + " まで");
            }
            
            // 問題7 Customer SErvice部署で最も給料が高い社員の名前と給料
            String sql7 = "select max(salary), first_name,last_name from dept_emp inner join departments on dept_emp.dept_no = departments.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no inner join employees on employees.emp_no = dept_emp.emp_no;";
            ResultSet result7 = statement.executeQuery (sql7);
            result7.next ();
            int m_salary = result7.getInt (1);
            String first_name = result7.getString ("first_name");
            String last_name = result7.getString ("last_name");
            System.out.println (
                    "Customer Service部署で最も給料が高いのは" + first_name + " " + last_name + "で、その給料は$" + m_salary + "です");
            
            // 問題8 部署ごとの現在の給料の平均値を抽出する
            String sql8 = "select avg(salary) as avs ,dept_name from dept_emp inner join departments on departments.dept_no = dept_emp.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no where salaries.to_date LIKE '9%' group by dept_name;";
            ResultSet result8 = statement.executeQuery (sql8);
            while (result8.next ()) {
                int salary = (int) result8.getDouble ("avs");
                String dept_name = result8.getString ("dept_name");
                System.out.println (dept_name + "の現在の平均給料は$" + salary + "です");
            }
            
            // 問題9 マネージャーではない人の名前を抽出
            String sql9 = "select first_name ,last_name from employees where emp_no not in (select emp_no from dept_manager);";
            ResultSet result9 = statement.executeQuery (sql9);
            while (result9.next ()) {
                String first_name1 = result9.getString ("first_name");
                String last_name1 = result9.getString ("last_name");
                System.out.println (first_name1 + " " + last_name1);
            }
            
            // 問題10 部署ごとに現在給料が一番高い人を抽出
            String sql10 = "select dept_name, max(salary) as ms,first_name, last_name from employees inner join salaries on salaries.emp_no = employees.emp_no inner join dept_emp on dept_emp.emp_no = employees.emp_no inner join departments on departments.dept_no = dept_emp.dept_no where salaries.to_date Like '9%' group by dept_name;";
            ResultSet result10 = statement.executeQuery (sql10);
            while (result10.next ()) {
                String dept_name = result10.getString ("dept_name");
                int max_salary = result10.getInt ("ms");
                String first_name2 = result10.getString ("first_name");
                String last_name2 = result10.getString ("last_name");
                System.out.println (
                        dept_name + "で現在最も高収入なのは" + first_name2 + " " + last_name2 + "さんで、その収入は$" + max_salary + "です");
            }
        } catch (SQLException e) {
            System.out.println ("データベース接続失敗" + e);
        }
        
    }
    
}
