-- 17. The name, population, and area of all records in the state table with no census region (NULL) and area less than 5000 square kilometers (3 rows)
Select state_name, population, area 
From state
Where census_region IS NULL and area <5000;
