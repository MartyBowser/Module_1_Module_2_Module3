-- 14. The state name, nickname, and census region for states that start with the word "New" (4 rows)
Select state_name, state_nickname, census_region
From state
Where state_name like 'New%'