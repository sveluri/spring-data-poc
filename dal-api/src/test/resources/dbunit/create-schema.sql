CREATE TABLE category(
  category_id int primary key,
  name varchar(255),
  description varchar(255)
);

CREATE TABLE product(
  product_id int primary key,
  name varchar(255),
  description varchar(255),
  active boolean,
  category_id int foreign key references category(category_id)
);

CREATE TABLE product_locale(
    product_id int foreign key references product(product_id),
    locale varchar(45),
    title varchar(45),
    primary key(product_id, locale)
);

CREATE TABLE hibernate_sequences(
    sequence_name varchar(255),
    next_val int
);