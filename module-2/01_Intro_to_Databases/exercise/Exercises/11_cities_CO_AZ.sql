-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ) (22 rows)
Select state_abbreviation, population, city_name
From city
Where state_abbreviation in ('CO' , 'AZ');

