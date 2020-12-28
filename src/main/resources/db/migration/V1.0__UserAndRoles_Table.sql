CREATE TABLE user_role (
  user_id INT8 NOT NULL,
  name VARCHAR(32)
);

CREATE TABLE app_user (
  id BIGINT AUTO_INCREMENT NOT NULL,
  active boolean NOT NULL,
  email VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


ALTER TABLE user_role
ADD CONSTRAINT user_role_fk
FOREIGN KEY (user_id) 
REFERENCES app_user(id);

CREATE INDEX user_email_index ON app_user (email);

