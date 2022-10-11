-- 13. The name, abbreviation, and population of all records in the state table with no official nickname (NULL) (5 rows)
Select state_name, state_abbreviation, population
From state
Where state_nickname is null;
