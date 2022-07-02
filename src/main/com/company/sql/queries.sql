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
-- https://leetcode.com/problems/fix-names-in-a-table/
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | user_id        | int     |
-- | name           | varchar |
-- +----------------+---------+
-- Write an SQL query to fix the names so that only the first character is uppercase and the rest are lowercase.
-- Return the result table ordered by user_id.
SELECT
    user_id,
    CONCAT(UPPER(LEFT(name, 1)), LOWER(SUBSTRING(name, 2, LENGTH(name)))) AS name
FROM Users
ORDER BY user_id;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/group-sold-products-by-the-date/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | sell_date   | date    |
-- | product     | varchar |
-- +-------------+---------+
-- Write an SQL query to find for each date the number of different products sold and their names.
-- The sold products names for each date should be sorted lexicographically.
-- Return the result table ordered by sell_date.
SELECT
    sell_date,
    COUNT(DISTINCT product) as num_sold,
    GROUP_CONCAT(DISTINCT product ORDER BY product ASC SEPARATOR ',') AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/patients-with-a-condition/
-- +--------------+---------+
-- | Column Name  | Type    |
-- +--------------+---------+
-- | patient_id   | int     |
-- | patient_name | varchar |
-- | conditions   | varchar |
-- +--------------+---------+
-- Write an SQL query to report the patient_id, patient_name all conditions of patients who have Type I Diabetes.
-- Type I Diabetes always starts with DIAB1 prefix.
SELECT * FROM Patients WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%';

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/employees-with-missing-information/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | name        | varchar |
-- +-------------+---------+
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | employee_id | int     |
-- | salary      | int     |
-- +-------------+---------+
-- Write an SQL query to report the IDs of all the employees with missing information. The information of an employee is missing if:
-- - The employee's name is missing, or
-- - The employee's salary is missing.
-- Return the result table ordered by employee_id in ascending order.
SELECT un.employee_id
FROM
    (SELECT * FROM Employees LEFT JOIN Salaries USING(employee_id)   --USING instead of ON when column names are the same
     UNION                                                           --FULL OUTER JOIN analog
     SELECT * FROM Employees RIGHT JOIN Salaries USING(employee_id)) --USING instead of ON when column names are the same
        AS un
WHERE un.name IS NULL OR un.salary IS NULL
ORDER BY un.employee_id;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/rearrange-products-table/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | product_id  | int     |
-- | store1      | int     |
-- | store2      | int     |
-- | store3      | int     |
-- +-------------+---------+
-- Write an SQL query to rearrange the Products table so that each row has (product_id, store, price).
-- If a product is not available in a store, do not include a row with that product_id and store combination in the result table.
SELECT product_id, 'store1' AS store, store1 AS price FROM Products WHERE store1 IS NOT NULL
UNION
SELECT product_id, 'store2' AS store, store2 AS price FROM Products WHERE store2 IS NOT NULL
UNION
SELECT product_id, 'store3' AS store, store3 AS price FROM Products WHERE store3 IS NOT NULL

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/tree-node/
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | p_id        | int  |
-- +-------------+------+
-- Each node in the tree can be one of three types:
-- - "Leaf": if the node is a leaf node.
-- - "Root": if the node is the root of the tree.
-- - "Inner": If the node is neither a leaf node nor a root node.
-- Write an SQL query to report the type of each node in the tree.
-- Return the result table ordered by id in ascending order.
SELECT
    id,
    'Root' AS type
FROM Tree WHERE p_id IS NULL
UNION ALL
SELECT
    id,
    'Inner' AS type
FROM Tree WHERE p_id IS NOT NULL AND id IN (SELECT DISTINCT p_id FROM Tree)
UNION ALL
SELECT
    id,
    'Leaf' AS type
FROM Tree WHERE p_id IS NOT NULL AND id NOT IN (SELECT DISTINCT p_id FROM Tree WHERE p_id IS NOT NULL); -- NOT IN is always false when NULL in array

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/second-highest-salary/
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | id          | int  |
-- | salary      | int  |
-- +-------------+------+
-- Write an SQL query to report the second highest salary from the Employee table.
-- If there is no second highest salary, the query should report null.
SELECT IFNULL((SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1, 1), NULL) AS SecondHighestSalary;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/combine-two-tables/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | personId    | int     |
-- | lastName    | varchar |
-- | firstName   | varchar |
-- +-------------+---------+
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | addressId   | int     |
-- | personId    | int     |
-- | city        | varchar |
-- | state       | varchar |
-- +-------------+---------+
-- Write an SQL query to report the first name, last name, city, and state of each person in the Person table.
-- If the address of a personId is not present in the Address table, report null instead.
SELECT firstName, lastName, city, state
FROM Person AS p
LEFT JOIN Address AS a ON p.personId = a.personId;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | visit_id    | int     |
-- | customer_id | int     |
-- +-------------+---------+
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | transaction_id | int     |
-- | visit_id       | int     |
-- | amount         | int     |
-- +----------------+---------+
-- Write an SQL query to find the IDs of the users who visited without making any transactions and the number of times they made these types of visits.
SELECT customer_id, COUNT(v.visit_id) AS 'count_no_trans'
FROM Visits AS v LEFT JOIN Transactions AS t ON v.visit_id = t.visit_id
WHERE t.amount IS NULL
GROUP BY v.customer_id;

------------------------------------------------------------------------------------------------------------------------
-- https://leetcode.com/problems/article-views-i/
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | article_id    | int     |
-- | author_id     | int     |
-- | viewer_id     | int     |
-- | view_date     | date    |
-- +---------------+---------+
-- Write an SQL query to find all the authors that viewed at least one of their own articles.
-- Return the result table sorted by id in ascending order.
SELECT DISTINCT author_id AS id FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;

