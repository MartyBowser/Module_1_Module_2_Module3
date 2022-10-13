-- 10. For all people born before 1950 and have a home page, add the home page to the end of their biography. (142 rows)
-- Note: Assume all biographies end in a period with no trailing spaces. You'll need to also add a space before the website address.
SELECT person_name, birthday, biography
FROM person
WHERE home_page IS NOT null AND birthday < '1/1/1950';

UPDATE person
SET biography = (biography || ' '|| home_page)
WHERE home_page IS NOT null AND birthday < '1/1/1950';

