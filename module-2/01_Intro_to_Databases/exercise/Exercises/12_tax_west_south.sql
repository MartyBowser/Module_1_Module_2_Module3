-- 12. The state name, nickname, and sales tax from records in the state table in the "West" and "South" census regions with a sales tax that isn't 0% (26 rows)
Select state_name, state_nickname, sales_tax
From state
Where   census_region in ('South', 'West') and sales_tax != 0;

