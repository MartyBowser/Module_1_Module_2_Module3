-- 10. The name and area of parks that have an area less than or equal to 700 square kilometers and provides camping (21 rows)
Select park_name, area
From park
Where area <= 700 and has_camping;
