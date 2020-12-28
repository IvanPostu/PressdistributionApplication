CREATE TABLE publicity (
  id BIGINT AUTO_INCREMENT NOT NULL,
  publisher_id BIGINT,
  author_id BIGINT,
  title VARCHAR(512),
  content VARCHAR(10240),
  PRIMARY KEY (id)
);


ALTER TABLE publicity
ADD CONSTRAINT publicities_publisher_fk
FOREIGN KEY (publisher_id) 
REFERENCES publisher(id);


ALTER TABLE publicity
ADD CONSTRAINT publicities_author_fk
FOREIGN KEY (author_id) 
REFERENCES app_user(id);
