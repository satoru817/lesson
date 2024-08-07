SELECT * FROM employees WHERE employees.birth_date LIKE '1965_01_%' ;

SELECT COUNT(gender) FROM employees WHERE gender = 'F' ;

SELECT COUNT(gender) FROM employees WHERE gender = 'M' ;

SELECT dept_name, COUNT(*) FROM dept_emp INNER JOIN employees ON dept_emp.emp_no = employees.emp_no INNER JOIN departments ON dept_emp.dept_no = departments.dept_no GROUP BY dept_name ; 

SELECT  dept_name,first_name , last_name FROM (dept_manager INNER JOIN employees ON dept_manager.emp_no = employees.emp_no INNER JOIN departments ON departments.dept_no = dept_manager.dept_no) WHERE to_date LIKE '9%' ;

SELECT emp_no, first_name, last_name FROM employees WHERE 10001 <= emp_no && emp_no <= 10100 && first_name LIKE 'P%';

SELECT emp_no , dept_no ,from_date,to_date from dept_emp WHERE (dept_no = 'd004'|| dept_no = 'd008') &&((from_date<='1995_01_01' && to_date >= '1995_01_01')||(from_date<='1997_01_01' && to_date >= '1997_01_01'));

select max(salary), first_name,last_name from dept_emp inner join departments on dept_emp.dept_no = departments.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no inner join employees on employees.emp_no = dept_emp.emp_no;

select avg(salary) as avs ,dept_name from dept_emp inner join departments on departments.dept_no = dept_emp.dept_no inner join salaries on salaries.emp_no = dept_emp.emp_no where salaries.to_date LIKE '9%' group by dept_name;

select first_name ,last_name from employees where emp_no not in (select emp_no from dept_manager);

select dept_name, max(salary) as ms,first_name, last_name from employees inner join salaries on salaries.emp_no = employees.emp_no inner join dept_emp on dept_emp.emp_no = employees.emp_no inner join departments on departments.dept_no = dept_emp.dept_no where salaries.to_date Like '9%' group by dept_name;

