-- https://leetcode.com/problems/big-countries/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | name        | varchar |
-- | continent   | varchar |
-- | area        | int     |
-- | population  | int     |
-- | gdp         | int     |
-- +-------------+---------+
-- A country is big if:
-- - it has an area of at least three million (i.e., 3000000 km2), or
-- - it has a population of at least twenty-five million (i.e., 25000000).
-- Write an SQL query to report the name, population, and area of the big countries.
SELECT name, population, area
FROM World
WHERE area > 3000000 OR population > 25000000

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/find-customer-referee/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- | referee_id  | int     |
-- +-------------+---------+
-- Write an SQL query to report the names of the customer that are not referred by the customer with id = 2.
SELECT name
FROM customer
WHERE referee_id <> 2 OR referee_id IS NULL

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/customers-who-never-order/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- +-------------+---------+
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | customerId  | int  |
-- +-------------+------+
-- Write an SQL query to report all customers who never order anything.
SELECT A.Name from Customers A
LEFT JOIN Orders B on  a.Id = B.CustomerId
WHERE b.CustomerId is NULL

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/calculate-special-bonus/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | name        | varchar |
-- | salary      | int     |
-- +-------------+---------+
-- Write an SQL query to calculate the bonus of each employee.
-- The bonus of an employee is 100% of their salary if the ID of the employee is an odd number and the employee name
-- does not start with the character 'M'. The bonus of an employee is 0 otherwise.
-- Return the result table ordered by employee_id.
SELECT employee_id,
    CASE
    WHEN employee_id%2=1 AND name NOT LIKE 'M%' THEN salary
    ELSE 0
    END
AS bonus FROM Employees ORDER BY employee_id;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/swap-salary/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | name        | varchar |
-- | salary      | int     |
-- +-------------+---------+
-- Write an SQL query to swap all 'f' and 'm' values (i.e., change all 'f' values to 'm' and vice versa)
UPDATE Salary SET sex = CASE WHEN sex = 'm' THEN 'f' ELSE 'm' END;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/delete-duplicate-emails/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | email       | varchar |
-- +-------------+---------+
-- Write an SQL query to delete all the duplicate emails, keeping only one unique email with the smallest id.
DELETE p1
FROM Person p1, Person p2
WHERE p1.Email = p2.Email AND
p1.Id > p2.Id

------------------------------------------------------------------------------------------------------------------------