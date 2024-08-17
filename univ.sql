CREATE TABLE teachers ( teacher_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
						teacher_name VARCHAR(255));

CREATE TABLE students (student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
					   student_name VARCHAR(255),
                       grade INT,
                       teacher_id INT,
                       FOREIGN KEY(teacher_id) REFERENCES teachers(teacher_id));
                       
CREATE TABLE courses(course_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
					 teacher_id INT NOT NULL,
                     max_students_num INT,
                     period_begin DATE,
                     perido_end DATE);
                     
CREATE TABLE attendances(attendance_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
						student_id INT NOT NULL,
                        course_id INT NOT NULL,
                        FOREIGN KEY(student_id) REFERENCES students(student_id),
                        FOREIGN KEY(course_id) REFERENCES courses(course_id));
