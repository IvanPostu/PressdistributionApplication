CREATE TABLE user_role (
  user_id INT8 NOT NULL,
  name VARCHAR(32)
);

CREATE TABLE app_user (
  id BIGINT AUTO_INCREMENT NOT NULL,
  active boolean NOT NULL,
  email VARCHAR(256) UNIQUE,
  firstname VARCHAR(256) DEFAULT '',
  lastname VARCHAR(256) DEFAULT '',
  password VARCHAR(256) NOT NULL,
  PRIMARY KEY (id)
);


ALTER TABLE user_role
ADD CONSTRAINT user_role_fk
FOREIGN KEY (user_id) 
REFERENCES app_user(id);

CREATE INDEX user_email_index ON app_user (email);

