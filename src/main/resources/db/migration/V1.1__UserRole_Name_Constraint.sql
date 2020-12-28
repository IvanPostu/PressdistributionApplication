
ALTER TABLE user_role
ADD CONSTRAINT user_role_name__constraint 
CHECK (
	name='WRITER' OR name='READER'
);

ALTER TABLE user_role  ALTER COLUMN name SET DEFAULT 'WRITER';
