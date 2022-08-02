

SELECT student.name, student.age, faculty.name
FROM student
         INNER JOIN faculty ON student.faculty_id = faculty.id;

SELECT student.name, student.age
FROM avatar
         INNER JOIN student ON avatar.student_id = student.id;


CREATE TABLE drivers
(
    name    TEXT PRIMARY KEY,
    age     INT,
    license BIT NOT NULL,
    car_id  INT REFERENCES cars (id)
);

CREATE TABLE cars
(
    id    INT PRIMARY KEY,
    brand TEXT,
    model TEXT,
    price REAL
);

