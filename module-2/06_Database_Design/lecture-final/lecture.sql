BEGIN TRANSACTION;

DROP TABLE IF EXISTS Artist_Painting;
DROP TABLE IF EXISTS Artist;
DROP TABLE IF EXISTS Customer_Purchases;
DROP TABLE IF EXISTS Painting;
DROP TABLE IF EXISTS Customer;

-- Customer Table
CREATE TABLE Customer (
	customer_id serial,
	customer_name varchar(200),
	address varchar(500),
	phone varchar(20) unique, -- forces the column to be unique
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

CREATE TABLE Painting(
	painting_id serial,
	title varchar(200) not null,
	starting_price money not null default(1), -- gives the column a default value
	
	CONSTRAINT pk_painting PRIMARY KEY (painting_id)
);

CREATE TABLE Customer_Purchases (
	customer_id int not null,  -- not null prevents this column from ever having a null value
	painting_id int not null,
	purchase_date timestamp not null,
	sales_price money not null,
	
	CONSTRAINT pk_customer_purchases PRIMARY KEY (customer_id, painting_id),
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
	CONSTRAINT fk_artist_artist_painting FOREIGN KEY (artist_id) REFERENCES Artist(artist_id),
	CONSTRAINT fk_painting_artist_painting FOREIGN KEY (painting_id) REFERENCES Painting(painting_id)

);

-- EXAMPLE OF A CHECK - make sur ethis column exists in a set of predetermined values
--CREATE TABLE state (
--	state_abbreviation char(2) NOT NULL,
--	state_name varchar(50) NOT NULL,
--	census_region varchar(10) NULL,
--	CONSTRAINT PK_state PRIMARY KEY(state_abbreviation), 
--	CONSTRAINT CHK_census_region CHECK (census_region IS NULL OR census_region IN ('Northeast', 'South', 'Midwest', 'West'))
);

COMMIT;