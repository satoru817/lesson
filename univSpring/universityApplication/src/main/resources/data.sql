INSERT IGNORE INTO `teachers` (`teacher_id`, `teacher_name`) VALUES
(1, '田中'),
(2, '佐藤'),
(3, '鈴木'),
(4, '山田');

INSERT IGNORE INTO `students` (`student_id`, `student_name`, `grade`, `teacher_id`) VALUES
(1, '田中 太郎', 2, 4),
(2, '鈴木 花子', 3, 2),
(3, '佐々木 一郎', 1, 1);

INSERT IGNORE INTO `courses` (`course_id`, `teacher_id`, `max_students_num`, `period_begin`, `period_end`, `course_name`) VALUES
(101, 1, 30, '2024-04-01', '2024-09-30', 'プログラミング基礎'),
(102, 2, 35, '2024-04-01', '2024-09-30', 'データベース入門'),
(103, 3, 15, '2024-04-01', '2024-09-30', 'Webデザイン'),
(104, 1, 10, '2024-10-01', '2025-01-01', 'Java入門');

INSERT IGNORE INTO `attendances` (`attendance_id`, `student_id`, `course_id`) VALUES
(21, 1, 101),
(31, 2, 101),
(32, 3, 101),
(33, 1, 102),
(34, 2, 102),
(35, 3, 102),
(36, 1, 103),
(37, 2, 103),
(38, 3, 104);





