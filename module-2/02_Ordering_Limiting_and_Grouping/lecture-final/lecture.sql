-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT population
FROM state
ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
WHERE census_region IS NOT NULL
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT park_name, area, (area * 1000000) AS area_in_meters
FROM park
ORDER BY area_in_meters DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, (CURRENT_DATE - date_established) AS age
FROM park
ORDER BY age DESC
LIMIT 20;


--SELECT CURRENT_TIME;
--SELECT EXTRACT(year FROM CURRENT_DATE);

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ' (' || state_abbreviation || ')' AS city_state
FROM city;

-- The all parks by name and date established.
SELECT 'NAME: ' || park_name || '  DATE ESTABLISHED: ' || date_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ': ' || state_name AS region_state
FROM state
WHERE census_region in ('West','Midwest')
ORDER BY region_state;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS west_south_total_population
FROM state
WHERE census_region in ('West','South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(population)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*) AS num_rows, COUNT(state_nickname) as num_values
FROM state;

-- The area of the smallest and largest parks.
SELECT MAX(area) AS largest, MIN(area) AS smallest
FROM park;

SELECT *
FROM park
WHERE area = 33682.6;

-- GROUP BY

-- 1. Just write select * as a placeholder
-- 2. Determine what table you are pulling from and put it in your FROM statement
-- 3. Determine if you need a where clause (none of these examples had one)
-- 4. Determine what the group you are analyzing is, and put the column name in the GROUP BY statement
-- 5. Copy the column(s) from the GROUP BY statement into your select (overwriting your *)
-- 6. Add a new column, using an aggregate function that summarizes your group (count, avg, min, max, sum)
-- 7. Add the order by if necessary

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(*) as num_cities
FROM city
GROUP BY state_abbreviation
ORDER BY num_cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS average_area
FROM park
GROUP BY has_camping
ORDER BY average_area;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS state_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_pop
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_pop;

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, state_abbreviation, population
FROM city
ORDER BY city_name
OFFSET 20 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(*) as num_cities, 
	(SELECT state_name 
	 FROM state 
	 WHERE state_abbreviation = city.state_abbreviation)
FROM city 
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- Include the names of the smallest and largest parks
SELECT park_name, area
FROM park p, (
	SELECT MAX(area) as largest, MIN(area) as smallest
	FROM park	
) smallest_largest
WHERE p.area = smallest_largest.smallest OR p.area = smallest_largest.largest;

-- List the capital cities for the states in the Northeast census region.
SELECT city_name, state_abbreviation
FROM city
WHERE city_id IN (
	SELECT capital
	FROM state
	WHERE census_region = 'Northeast'
);

select * FROM state;
