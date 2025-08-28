delete from person p where p.id not in(
    select min(id) from (
        select p1.id from person p1
        where p.email = p1.email
    ) as temp
);