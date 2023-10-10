use gravel_family;

-- Solve each task by writing a query below the task description.
-- Each task describes the expected result.
-- Unfortunately, tasks must be verified manually. :(

-- Example: 
-- Count the number of customer in Toronto
-- Expected: 14
select count(*)
from customer
where city = 'Toronto';

-- How many employees have the last_name 'Soyle'?
-- Expected: 12
select count(*)
from employee
where last_name = 'Soyle';

-- How many projects are there in the database?
-- Expected: 1121
select count(*)
from project;

-- What's the earliest project start_date?
-- Expected: 2017-09-23

select project_id, start_date
from project
order by start_date asc;



-- What's the latest employee start_date?
-- Expected: 2020-08-25

select last_name, start_date 
from employee
order by start_date desc;

-- Count customers per city.
-- Expected: 88 Rows

select city, count(*)
from customer
group by city;

select *
from customer;


-- Count customers per postal_code.
-- Expected: 84 Rows

select postal_code, count(*)
from customer
group by postal_code;

-- Count employees per last_name.
-- Expected: 3 Rows

select last_name, count(*)
from employee
group by last_name;

-- Count the number of projects per city.
-- Expected: 88 Rows


SELECT COUNT(distinct customer.city) FROM customer
INNER JOIN project ON customer.customer_id = project.customer_id;


-- Count the number of projects per city.
-- Sort by the count descending and select the top 10 rows.
-- Expected: 10 Rows

select project.project_id, project.customer_id, count(*)
from project
inner join customer
on project.customer_id = customer.customer_id
group by customer.city;

select customer.city, count(*)
from project
inner join customer
on project.customer_id = customer.customer_id
group by customer.city
order by count(*) desc
limit 10;

select
	c.customer_id,
	c.city,
    count(*)
from project p
inner join customer c on p.customer_id = c.customer_id
group by c.customer_id, c.city;

select count(*) from project; -- 1121 count


-- Which postal_code has the most projects?
-- Expected: M3H

select customer.postal_code, count(*)
from project
inner join customer
on project.customer_id = customer.customer_id
group by customer.postal_code
order by count(*) desc
limit 1;

-- Count the number of projects per start_date year.
-- Expected: 4 Rows

select customer.postal_code, count(*)
from project
inner join customer
on project.customer_id = customer.customer_id
group by customer.postal_code
order by count(*) desc
limit 1;

-- Count the number of employees per project in the M3H postal_code.
-- Group by project_id, sort by count descending.
-- Expected: 39 Rows

-- Calculate the total cost per project in the 'M3H' postal_code.
-- (Hint: sum a calculation)
-- Expected: 39 Rows

-- What's the most expensive project in the 'M3H' postal_code?
-- Expected: 18828.00

-- How many projects did each employee work on?
-- Expected: 33 Rows

-- How many employees worked on more than 140 projects?
-- Expected: 10 Rows

-- How many projects cost more than $20,000?
-- Expected: 55 Rows

-- Across all projects, what are the total costs per item?
-- Select the item name and sum.
-- Sort by the sum desc;
-- Expected: 18 Rows

-- Across all projects, what are the total costs per item category?
-- Select the category name and sum.
-- Sort by the sum desc;
-- Expected: 7 Rows

-- What's the average 'Standard Labor' cost per city?
-- Expected: 88 Rows

-- Challenge: Which customer has the first project of 2019?
-- (Requires a subquery.)
-- Expected: Starkie 2019-01-01