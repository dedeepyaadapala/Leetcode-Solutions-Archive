# Write your MySQL query statement below
select c.name as customers from customers c where (select count(*) from orders o where c.id = o.customerId) = 0;