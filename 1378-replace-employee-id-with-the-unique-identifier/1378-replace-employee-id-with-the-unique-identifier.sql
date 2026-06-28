# Write your MySQL query statement below
select 
    b.unique_id,
    a.name
from EmployeeUni b
right join Employees a
on a.id = b.id
