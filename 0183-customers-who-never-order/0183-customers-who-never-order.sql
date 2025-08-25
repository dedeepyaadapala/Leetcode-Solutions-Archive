# Write your MySQL query statement below
select c.name as customers from customers c where not exists (select * from orders o where c.id = o.customerid); 