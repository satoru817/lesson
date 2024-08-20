

insert ignore into teachers (teacher_id,teacher_name) values
	(1,'田中'),
	(2,'佐藤'),
	(3,'鈴木'),
	(4,'山田');
	
insert ignore into students(student_id,student_name,grade,teacher_id) values
	(1,'田中 太郎',2,4),
	(2,'鈴木 花子',3,2),
	(3,'佐々木 一郎',1,1);
	
insert ignore into courses(course_id,course_name,max_students_num,period_begin,period_end,teacher_id) values
	(101,'プログラミング基礎',30,'2024-04-01','2024-09-30',1),
	(102,'データベース入門',35,'2024-04-01','2024-09-30',2),
	(103,'Webデザイン',15,'2024-04-01','2024-09-30',3),
	(104,'Java入門',10,'2024-10-01','2025-01-01',1);