SELECT * FROM employees WHERE employees.birth_date BETWEEN '1965-01-01' AND '1965-01-31';
/*betweenを利用しました*/

select gender ,count(gender) from employees group by gender;
/*group byを利用して書き直しました。*/


SELECT dept_name, COUNT(*) FROM dept_emp INNER JOIN departments ON dept_emp.dept_no = departments.dept_no GROUP BY dept_name ; 
/*無駄なjoinをなくしました*/

SELECT  dept_name,first_name , last_name FROM dept_manager INNER JOIN employees ON dept_manager.emp_no = employees.emp_no INNER JOIN departments ON departments.dept_no = dept_manager.dept_no WHERE to_date >= CURDATE() ;
/*CURDATE()に変更しました。*/

SELECT emp_no, first_name, last_name FROM employees WHERE emp_no BETWEEN 10001 AND 10100 AND first_name LIKE 'P%';
/*ANDにへんこうしました,BETWEENを利用しました*/

SELECT emp_no , dept_no ,from_date,to_date from dept_emp WHERE dept_no IN ('d004','d008') AND((from_date<='1995_01_01' AND to_date >= '1995_01_01')OR(from_date<='1997_01_01' AND to_date >= '1997_01_01'));
/*&&と||の書き直しをしました、IN句を使いました*/

select max(salary), first_name,last_name from dept_emp inner join departments on dept_emp.dept_no = departments.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no inner join employees on employees.emp_no = dept_emp.emp_no where dept_name = 'Customer Service';
/*dept_nameの指定を追加しました*/

/*部署ごとの現在の給料の平均値*/
select avg(salary) as avs ,dept_name from dept_emp inner join departments on departments.dept_no = dept_emp.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no where salaries.to_date >= CURDATE() AND dept_emp.to_date >= CURDATE() group by dept_name;
/*dept_emp.to_data>=CURDATE()の条件を追加しました*/

select first_name ,last_name from employees where emp_no not in (select emp_no from dept_manager);

/*部署ごとに現在給料が最も高い人を抽出*/
SELECT dept_name,salary,first_name,last_name FROM departments JOIN (select dept_no,max(salary) as MaxSalary from dept_emp JOIN salaries on dept_emp.emp_no = salaries.emp_no where dept_emp.to_date >= CURDATE() AND salaries.to_date >= CURDATE() group by dept_no) AS deptMaxSalary on departments.dept_no = deptMaxSalary.dept_no JOIN salaries on salaries.salary = deptMaxSalary.MaxSalary JOIN employees ON employees.emp_no = salaries.emp_no;
/*サブクエリを利用して書き直しました。*/
