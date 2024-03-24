INSERT INTO
  user_details (id, dob, name)
VALUES
  (1001, current_date(), 'him sing!');

INSERT INTO
  user_details (id, dob, name)
VALUES
  (1002, LOCALTIMESTAMP() - 2500, 'him song!');

INSERT INTO
  user_details (id, dob, name)
VALUES
  (1003, '1989-06-15', 'him speak!');

INSERT INTO
  post (id, user_id, description)
VALUES
  (2001, '1003', 'an awesome circuit');

INSERT INTO
  post (id, user_id, description)
VALUES
  (2002, '1003', 'awesome new amp');

INSERT INTO
  post (id, user_id, description)
VALUES
  (2003, '1003', 'new post about a 16 channel mixer');