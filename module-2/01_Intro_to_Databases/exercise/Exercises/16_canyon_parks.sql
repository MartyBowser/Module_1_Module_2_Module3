-- 16. The name, date established, and area of parks that contain the string "Canyon" anywhere in the name (5 rows)
Select park_name, date_established, area
From park
Where park_name LIKE '%Canyon%';
