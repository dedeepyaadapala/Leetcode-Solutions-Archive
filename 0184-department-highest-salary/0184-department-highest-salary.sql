# Write your MySQL query statement below
select d.name as department, e.name as employee,e.salary as salary 
from employee e, department d
where e.departmentid = d.id and e.salary = (select max(e1.salary) from employee e1 where e1.departmentid = d.id);