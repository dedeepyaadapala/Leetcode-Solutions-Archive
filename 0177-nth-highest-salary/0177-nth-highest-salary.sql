CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set n = n -1;
  RETURN (
      select(
        select distinct salary from employee order by salary desc limit 1 offset n
      )
  );
END