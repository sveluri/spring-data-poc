CREATE TABLE product(
  product_id int primary key,
  name varchar(255),
  description varchar(255),
  active boolean
);

CREATE TABLE hibernate_sequences(
    sequence_name varchar(255),
    next_val int
);