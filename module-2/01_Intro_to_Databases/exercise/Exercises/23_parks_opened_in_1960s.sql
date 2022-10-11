-- 23. The name and date established of parks opened in the 1960s (6 rows)
Select park_name, date_established
From park
Where date_established BETWEEN '1960-01-01' and '1969-12-31'

