CREATE DATABASE IF NOT EXISTS work2;

USE work2;

CREATE TABLE IF NOT EXISTS Class
(
    class_id   int unsigned NOT NULL AUTO_INCREMENT,
    class_name varchar(255) NOT NULL,
    PRIMARY KEY (class_id)
);

CREATE TABLE IF NOT EXISTS Student
(
    student_id   int unsigned NOT NULL AUTO_INCREMENT,
    student_name varchar(255) NOT NULL,
    class_id     int unsigned,
    PRIMARY KEY (student_id),
    FOREIGN KEY (class_id) REFERENCES Class (class_id)
);

ALTER TABLE work2.class
    CONVERT TO CHARACTER SET utf8;

INSERT INTO class (class_id, class_name)
VALUES (1, '1-А'),
       (2, '1-B'),
       (3, '2-А'),
       (4, '2-B'),
       (5, '3-А'),
       (6, '3-B'),
       (7, '4-А'),
       (8, '4-B');

INSERT INTO Student(student_id, student_name, class_id)
VALUES (1, 'Uriyah', 1),
       (2, 'Umer', 2),
       (3, 'Uriyah', 3),
       (4, 'Boston', 4),
       (5, 'Percy', 4),
       (6, 'Uriyah', 5),
       (7, 'Umer', 6),
       (8, 'Uriyah', 6);

/*
Знайти усі класи без жодного студента
*/

SELECT class.class_name
FROM class
         LEFT JOIN Student ON class.class_id = Student.class_id
WHERE Student.student_id IS NULL;

/*
Для кожного класу найти значення full_class із значеннями yes або no.
Клас вважається заповненим (full),якщо він налічує > 30 студентів.
*/

SELECT class.class_name,
       COUNT(student.student_id)                       AS "Count",
       IF(COUNT(student.student_id) > 30, 'YES', 'NO') AS "Full class"
FROM class
         JOIN student ON class.class_id = student.class_id
GROUP BY class.class_name;

/*
 Знайти кількість студентів які вчаться у 1-му, 2-му,
 ... 11-му класах (тобто 1-А і 1-Б клас рахувати як один)
*/

SELECT CASE
           WHEN class.class_name LIKE '1-%' THEN '1'
           WHEN class.class_name LIKE '2-%' THEN '2'
           WHEN class.class_name LIKE '3-%' THEN '3'
           WHEN class.class_name LIKE '4-%' THEN '4' END AS "Class",
       COUNT(student.student_id)                         AS "Count"
FROM class
         JOIN student ON class.class_id = student.class_id
GROUP BY CASE
             WHEN class.class_name LIKE '1-%' THEN '1'
             WHEN class.class_name LIKE '2-%' THEN '2'
             WHEN class.class_name LIKE '3-%' THEN '3'
             WHEN class.class_name LIKE '4-%' THEN '4' END;