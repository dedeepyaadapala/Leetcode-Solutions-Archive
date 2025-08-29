# Write your MySQL query statement below
select w.id from weather w where exists(
    select id from weather w1 where w1.recorddate = date_sub(w.recorddate,interval 1 day) and w1.temperature < w.temperature
);