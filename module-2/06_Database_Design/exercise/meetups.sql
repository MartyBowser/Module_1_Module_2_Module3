--homework 

BEGIN TRANSACTION;
DROP TABLE IF EXISTS Member_group_number_table;
DROP TABLE IF EXISTS Member_event_table;
DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Event_number;
DROP TABLE IF EXISTS Interest_group;

-- Customer Table
CREATE TABLE Member(
	member_id serial,
	first_name varchar(200),
	last_name varchar(200),
	email_address varchar(500),
	phone varchar(20)NOT NULL, 
	date_of_birth date,
	privacy_flag boolean,
	CONSTRAINT pk_member  PRIMARY KEY (member_id)
);
-- Customer Table
CREATE TABLE Interest_group(
	group_number serial,
	group_name varchar(100),
	number_of_members varchar(200),
	CONSTRAINT pk_interest_group  PRIMARY KEY (group_number)
	);
-- Customer Table
CREATE TABLE Event_number(
	event_id serial,
	event_description varchar(200),
	event_date_time varchar(200),
	group_id int, 
	duration int check (duration >=30),
	CONSTRAINT pk_Event_number PRIMARY KEY (event_id),
	CONSTRAINT fk_Interest_group_Event_number FOREIGN KEY (group_id) REFERENCES Interest_group(group_number)
	);
	-- Customer Table
	CREATE TABLE Member_event_table(
	member_event_id serial,
	member_id int,	
	event_id int,
	CONSTRAINT pk_member_event_id PRIMARY KEY (member_event_id),
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES Member(member_id),
	CONSTRAINT fk_event_id FOREIGN KEY (event_id) REFERENCES Event_number(event_id)		
		
	);
	-- Customer Table
	CREATE TABLE member_group_number_table(
	member_group_id serial,
	member_id int NOT NULL,
	group_number int NOT NULL,
	CONSTRAINT pk_member_group_id PRIMARY KEY (member_group_id),
	CONSTRAINT fk_member_id2 FOREIGN KEY (member_id)	REFERENCES MEMBER(member_id),
	CONSTRAINT fk_group_number FOREIGN KEY (group_number) REFERENCES Interest_group(group_number)	
		
	);
	
	INSERT INTO Member (first_name, last_name, email_address, phone, date_of_birth, privacy_flag)
	VALUES('Miles', 'Morales', 'I_am_the_new_spiderman@marvel.mail.com', '310-555-1256','08-03-2005',True ),
	('Wade', 'Wilson', 'anti_hero_merc_with_the_mouth@deadpoolcorps.com', '315-661-1567', '08-15-1973',True),
	('James', 'Howlett', 'i_can_slice_and_dice@xforce.com', '001-001-0012', '09-16-1887',True),
	('Bruce', 'Banner', 'hulk_smash_pewwny_man-ARRRRGGGHHH@marvel.mail.com', '126-256-1999', '11-12-1980',True),
	('T', 'Challa', 'wakanda_forever_we_dont_do_that_here@hiddencity.com', 'hidden', '11-29-1976',True),
	('Tony', 'Stark', 'yes_i_am_iron_man@nosecretidentity.com', '281-330-8004', '02-15-1980', True),
	('Thor', 'Asgardian', 'god_of_thunder_milnir_left_me@rainbowbridge.com', '', '01-01-1700', True),
	('Groot', 'I_am', 'I_am_groot_groot_groot@grootgrootgroot.groot', '426-476-6667', '02-02-2020', False),
	('Steve', 'Rogers', 'I_am_the_first_avenger@marvel.mail.com', '', '07-04-1920', False),
	('Sam', 'Wilson', 'dont_say_on_your_left@marvel.maol.com', '426-851-2036', '06-24-1994',True),
	('Rocket', 'Racoon', 'ill_trade_ya@guardians.com', '', '08-13-2020',False);
	
	INSERT INTO Interest_group(group_name, number_of_members)
	VALUES('XFORCE', 2), ('Avengers', 7), ('Guardians', 2);
	
	INSERT INTO EVENT_number (event_description,event_date_time,duration, group_id)
	VALUES('end_game', '04-26-2019',182, 2);
	
	INSERT INTO EVENT_number (event_description,event_date_time,duration, group_id)
	VALUES('civil_war', '05-06-2016',148, 2);
	
	INSERT INTO EVENT_number (event_description,event_date_time,duration, group_id)
	VALUES('infinity_war', '04-27-2018',149, 2);
	
	INSERT INTO EVENT_number (event_description,event_date_time,duration, group_id)
	VALUES('guardians_of_the_galaxy', '08-01-2014', 122, 3);
	
	INSERT INTO member_group_number_table(member_id, group_number)
	VALUES(2,1), (3,1);
	
	INSERT INTO member_event_table(member_id, event_id)
	VALUES(6,2), (7,2), (9,2), (10,2);
	
	
	
	
	
	
	
	
	
	
--SELECT * FROM MEMBER
	
	
	
	
	
COMMIT;