-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
Select *
From state
ORDER BY population ASC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
Select state_name, census_region
From state 
order by census_region DESC, state_name ASC

-- The biggest park by area
Select park_name, aream (area * 1000000) AS area_in_meters
From park
Order By area_in_meters DESC


-- LIMITING RESULTS

-- The 10 largest cities by populations
select city_name, population
from city
order by population DESC
limit 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
Select park_name, (CURRENT_DATE - date_established) AS age
From park
Order by age DESC
limit 20;

-- Select CURRENT_TIME;
-- Select CURRENT_DATE;
-- Select EXTRACT(year from CURRENT_DATE);


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
select city_name || '(' || state_abbreviation || ')' AS city_state
From city;

-- The all parks by name and date established.
Select 'NAME: ' || park_name || ' DATE ESTABLISHED: ' || date_established
From park;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
Select census_region || ': ' || state_name AS region_state
From state
where census_region in ('West','Midwest')
order by region_state

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
Select AVG (population) AS avg_population
From state;

-- Total population in the West and South census regions
Select SUm(population) AS west_south_total_population
From state
where census_region in ('West', 'South');


-- The number of cities with populations greater than 1 million
Select COUNT(*)
from city
Where population > 1000000;

-- The number of state nicknames.
Select Count (*)  as num_rows, COUNT (state_nickname) as num_values
From state;


-- The area of the smallest and largest parks.
Select MAX(area) AS largest, MIN(area) as smallest
From park; 

Select *
From park
Where area = 33682.6



-- GROUP BY

-- 1. Just write select * as placeholder
-- 2. Determine what table you are pulling from and out it in your FROM statement
-- 3. Determine if you need a where clause (none of these examples had one)
-- 4. Determine what the group you are analyzing is, and put the column name in the GROUP BY statement
-- 5. Copy the column(s) from the GROUP BY statement into your select (overwriting your *)
-- 6. Add a new column, using an aggregate that summarizes your group (count, avg, min, max, sum)
-- 7. Add the drder by if necessary


-- Count the number of cities in each state, ordered from most cities to least.
Select *
From city
GROUP BY state_abbreviation
ORDER BY num_cities DESC; 


-- Determine the average park area depending upon whether parks allow camping or not.
Select has_camping, AVG(area)
From park
GROUP BY has_camping;


-- Sum of the population of cities in each state ordered by state abbreviation.
Select state_abbreviation, SUM(population)
from city
Group BY state_abbreviation
Order BY state_abbreviation; 

-- The smallest city population in each state ordered by city population.
Select state_abbreviation, MIN(population) As state_population
From city
GROUP BY state_abbreviation
ORDER BY state_abbreviation


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population, state_abbreviation
From city
ORDER BY city_name
OFFSET  0 ROWS FETCH NEXT 10 ROWS ONLY; 




-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT (*) as num_cities, (Select state_name FROM state Where state_abbreviation = c.state_abbreviaton)	
From city c
GROUP BY state_abbreviation
ORDER BY state_abbreviation
-- Include the names of the smallest and largest parks
SELECT park_name, area 
From park p, (
	SELECT MAX(area) as largest, MIN(area) as smallest
	FROM park
) smallest_largest
WHERE p.area = smallest_largest.smallest or P.area = slammest_largest.largest;


-- List the capital cities for the states in the Northeast census region.
SELECT city_name, state_abbreviation
FROM city
WHERE city_id IN (
	SELECT capital
	FROM state
	WHERE census_region = 'Northeast'
);
select * FROM state;

