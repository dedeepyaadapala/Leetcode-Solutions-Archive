# Write your MySQL query statement below
select c.name as customers from customers c 
left outer join orders o on c.id = o.customerid
where o.id is null;