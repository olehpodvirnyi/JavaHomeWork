CREATE DATABASE IF NOT EXISTS work1;

USE work1;

/*
Створити таблиці class, student, school, extra_table
*/

CREATE TABLE IF NOT EXISTS School
(
    school_id      int unsigned NOT NULL AUTO_INCREMENT,
    school_name    varchar(255) NOT NULL,
    school_address varchar(255) NOT NULL,
    private_school tinyint      NOT NULL,
    PRIMARY KEY (school_id)
);

CREATE TABLE IF NOT EXISTS Class
(
    class_id   int unsigned NOT NULL AUTO_INCREMENT,
    class_name varchar(255) NOT NULL,
    school_id  int unsigned,
    PRIMARY KEY (class_id),
    FOREIGN KEY (school_id) REFERENCES School (school_id)
);

CREATE TABLE IF NOT EXISTS Student
(
    student_id   int unsigned NOT NULL AUTO_INCREMENT,
    student_name varchar(255) NOT NULL,
    age          int          NOT NULL,
    bith_date    datetime,
    class_id     int unsigned,
    avg_mark     double,
    PRIMARY KEY (student_id),
    FOREIGN KEY (class_id) REFERENCES Class (class_id)
);

CREATE TABLE IF NOT EXISTS Teacher
(
    teacher_id   int,
    teacher_name varchar(255),
    age          int,
    bith_date    varchar(255),
    PRIMARY KEY (teacher_id)
);

/*
Заповнити їх даними
*/

INSERT INTO School(school_id, school_name, school_address, private_school)
VALUES (1, 'Lyceum №6', 'United_Kingdom Constable Franklee_Lane 44', TRUE),
       (2, 'Lyceum №20', 'United_Kingdom Cle_Elum Goodwin_Avenue 12', TRUE),
       (3, 'School №8', 'United_Kingdom Binghamton Hinkle_Deegan_Lake_Road 4', FALSE),
       (4, 'Lyceum №19', 'United_Kingdom Charlotte Hannah_Street 88', TRUE),
       (5, 'School №9', 'United_Kingdom Benton_Harbor Echo_Lane 6', TRUE),
       (6, 'Lyceum №11', 'United_Kingdom Solon Spring_Street 7', FALSE),
       (7, 'School №15', 'Ukraine Kirovograd Patsaєva 25', FALSE),
       (8, 'Lyceum №41', 'Ukraine Sumy Rokіv_ZHovtnya 36', FALSE),
       (9, 'School №4', 'Ukraine Evpatoriya Lugovaya 44', FALSE),
       (10, 'School №4', 'Ukraine Belaya_Tserkov Lenina 61', FALSE),
       (11, 'School №4', 'Ukraine Donetsk Kievskiy 29', FALSE);

INSERT INTO class (class_id, class_name, school_id)
VALUES (1, 'Ukrainian', 1),
       (2, 'Ukrainian', 2),
       (3, 'Ukrainian', 3),
       (4, 'English', 1),
       (5, 'English', 5),
       (6, 'English', 6),
       (7, 'Art', 5),
       (8, 'Art', 11),
       (9, 'Art', 8),
       (10, 'Maths', 9),
       (11, 'Maths', 7);

INSERT INTO Student(student_id, student_name, age, bith_date, class_id, avg_mark)
VALUES (1, 'Uriyah', 15, '2007-01-11', 1, 11),
       (2, 'Umer', 12, '2010-02-09', 2, 10),
       (3, 'Uriyah', 16, '2006-03-05', 3, 8),
       (4, 'Boston', 14, '2008-04-27', 4, 10),
       (5, 'Percy', 15, '2009-05-16', 5, 10),
       (6, 'English', 12, '2010-06-22', 6, 9),
       (7, 'Boston', 17, '2008-07-01', 7, 11),
       (8, 'Luca', 11, '2011-08-28', 8, 5),
       (9, 'Percy', 17, '2005-09-19', 9, 6),
       (10, 'Boston', 13, '2009-10-18', 10, 8),
       (11, 'Uriyah', 16, '2007-11-28', NULL, 9);

INSERT INTO Teacher(teacher_id, teacher_name, age, bith_date)
VALUES (1, 'Uriyah', 25, '2007-01-11'),
       (2, 'Umer', 36, '2010-02-09'),
       (3, 'Uriyah', 85, '2006-03-05'),
       (4, 'Boston', 57, '2008-04-27'),
       (5, 'Percy', 45, '2009-05-16'),
       (6, 'English', 65, '20010-06-22'),
       (7, 'Boston', 37, '2008-07-01'),
       (8, 'Luca', 26, '2011-08-28'),
       (9, 'Percy', 27, '2005-09-19'),
       (10, 'Boston', 31, '2009-10-18'),
       (11, 'Uriyah', 44, '2007-11-28');

/*
Нормалізувати таблицю school
*/

ALTER TABLE School
    ADD st_number varchar(40) AFTER school_address,
    ADD street    varchar(40) AFTER school_address,
    ADD city      varchar(40) AFTER school_address,
    ADD country   varchar(40) AFTER school_address;


UPDATE School as s1
SET s1.country=(SELECT SUBSTRING_INDEX(school_address, ' ', 1)
                FROM School as s2
                WHERE s2.school_id = s1.school_id);
UPDATE School as s1
SET s1.city = (SELECT SUBSTRING_INDEX(SUBSTRING_INDEX(school_address, ' ', 2), ' ', -1)
               FROM School as s2
               WHERE s2.school_id = s1.school_id);
UPDATE School as s1
SET s1.street = (SELECT SUBSTRING_INDEX(SUBSTRING_INDEX(school_address, ' ', -2), ' ', 1)
                 FROM School as s2
                 WHERE s2.school_id = s1.school_id);
UPDATE School as s1
SET s1.st_number = (SELECT SUBSTRING_INDEX(school_address, ' ', -1)
                    FROM School as s2
                    WHERE s2.school_id = s1.school_id);

ALTER TABLE School
    DROP school_address;

/*
Змінити тип даних для будь-якої колонки таблиці extra_table
*/

ALTER TABLE Teacher
    MODIFY age varchar(50) NULL;

/*
Видалити таблицю extra_table
*/

DROP TABLE Teacher;

/*
Змінити середній бал avg_mark суденту за заданим прізвищем
*/

UPDATE Student
SET avg_mark = 9
WHERE student_name = 'Boston';

/*
Видалити відрахованого студента з бази.
*/

DELETE
FROM Student
WHERE class_id IS NULL;

/*
Вивести перших 5 студентів із найвищим середнім балом.
Якщо бали однакові (такі мають бути) сортування по алфавіту
*/

SELECT student_name,
       avg_mark
FROM Student
ORDER BY avg_mark DESC, student_name ASC
LIMIT 5;

/*
Знайти мінімальний, максимальний, середній вік і
кількість студентів для кожного року народження студента
*/

SELECT YEAR(bith_date) AS "Year",
       MIN(age)        AS "Min age",
       AVG(age)        AS "Avg age ",
       Max(age)        AS "Max age ",
       COUNT(age)      AS "Count"
FROM Student
GROUP BY YEAR(bith_date);

/*
Знайти тільки українські школи
(використати створену колонку country)
*/

SELECT school_name,
       country
FROM School
WHERE country = 'Ukraine';

/*
Знайти вік студентів кількість яких є більша 10.
Тобто якщо існує більше 10 студентів із віком 15,
тоді цей рекорд входить до вибірки. Результат подати у вигляді
age|count(student_id).
*/

SELECT age,
       COUNT(student_id)
FROM Student
GROUP BY age
HAVING COUNT(student_id) > 1;