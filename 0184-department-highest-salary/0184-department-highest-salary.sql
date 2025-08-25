# Write your MySQL query statement below
select d.name as department, e.name as employee,e.salary as salary 
from employee e
join department d
on d.id = e.departmentid
where e.salary = (select max(e1.salary) from employee e1 where d.id = e1.departmentid);