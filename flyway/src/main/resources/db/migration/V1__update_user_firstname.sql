-- Flyway migration to update first_name for user_id 2
UPDATE users 
SET first_name = 'sujal' 
WHERE user_id = 2;
