BEGIN TRANSACTION;

DROP TABLE IF EXISTS Artist_Painting;
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Customer_purchases;
DROP TABLE IF EXISTS Painting;
DROP TABLE IF EXISTS customer;

-- Customer Table
CREATE TABLE Customer(
	customer_id serial,
	name varchar(200),
	address varchar(500),
	phone varchar(20)unique, --forces the column to be unique
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);
CREATE TABLE Painting(
	painting_id serial,
	title varchar(500),
	starting_price money,
	CONSTRAINT pk_painting PRIMARY KEY (painting_id)
	
);
CREATE TABLE Customer_Purchases (
	customer_id int not null, -- not null prevents this column from ever having a null value
	painting_id int not null, 
	purchase_date timestamp,
	sales_price money not null,
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id,painting_id),
	CONSTRAINT fk_customer_customer_purchases FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
	CONSTRAINT fk_painting_customer_purchases FOREIGN KEY (painting_id) REFERENCES Painting(painting_id)

);

CREATE TABLE Artist(
	artist_id serial,
	artist_name varchar(200) not null,
	CONSTRAINT pk_artist PRIMARY KEY (artist_id)
	
);


CREATE TABLE Artist_Painting(
	artist_id int not null,
	painting_id int not null,
	CONSTRAINT pk_artist_painting PRIMARY KEY (artist_id, painting_id),
	CONSTRAINT fk_artist_painting FOREIGN KEY (artist_id) REFERENCES Artist(artist_id),
	CONSTRAINT fk_painting_artist_painting FOREIGN KEY ( painting_id) REFERENCES Painting(painting_id)

);
COMMIT;

