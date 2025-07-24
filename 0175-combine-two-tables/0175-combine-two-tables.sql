# Write your MySQL query statement below
SELECT p.firstName, p.lastName, a.city,a.state FROM PERSON p
LEFT OUTER JOIN
address a
ON p.personId = a.personId;