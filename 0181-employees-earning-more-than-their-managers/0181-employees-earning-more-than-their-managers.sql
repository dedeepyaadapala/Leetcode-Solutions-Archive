# Write your MySQL query statement below
select e.name as employee from employee e where exists (select e1.salary from employee e1 where e.managerid = e1.id and e.salary > e1.salary);