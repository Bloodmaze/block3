select *
from student
where age < 20
  and age > 9;

select name
from student;

select *
from student
where name like '%o%';

select*
from student
where age < student.id;

select *
from student
order by age;