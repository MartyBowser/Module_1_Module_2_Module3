BEGIN TRANSACTION ;

DROP TABLE IF EXISTS report_agency;
DROP TABLE IF EXISTS agency;
DROP TABLE IF EXISTS evidence;
DROP TABLE IF EXISTS report_sensory_experience;
DROP TABLE IF EXISTS sensory_experience;
DROP TABLE IF EXISTS report_tag;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS reporter_report;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS encounter_type;
DROP TABLE IF EXISTS reporter;

CREATE TABLE reporter(
	reporter_id serial,
	reporter_name varchar(100),
	location varchar(100),
	age int,
	email_address varchar(100),
	receive_notifications boolean, 
	number_of_stories int,
	gender varchar(25),
	CONSTRAINT pk_reporter PRIMARY KEY(reporter_id)
);

CREATE TABLE encounter_type(
	encounter_type_id serial,
	encounter_type_name varchar(25),
	CONSTRAINT pk_encounter_type PRIMARY KEY (encounter_type_id)
);


CREATE TABLE report(
	report_id serial,
	location varchar(100),
	language varchar(25),
	number_of_eyewitnesses int,
	report_date date,
	report_time timestamp,
	moon_phase_id int,
	weather varchar(25),
	description text,
	involved_alcohol boolean,
	recurring boolean,
	encounter_type_id int,
	CONSTRAINT pk_report PRIMARY KEY (report_id),
	CONSTRAINT fk_encounter_type_report FOREIGN KEY (encounter_type_id) REFERENCES encounter_type(encounter_type_id)
);

CREATE TABLE reporter_report(
	report_id int,
	reporter_id int,
	reporting boolean,
	verifying boolean,
	CONSTRAINT pk_reporter_report PRIMARY KEY (report_id, reporter_id),
	CONSTRAINT fk_report_reporter_report FOREIGN KEY (report_id) REFERENCES report(report_id),
	CONSTRAINT fk_reporter_reporter_report FOREIGN KEY (reporter_id) REFERENCES reporter(reporter_id)
);

CREATE TABLE tag(
	tag_id serial,
	tag_name varchar(25),
	CONSTRAINT pk_tag PRIMARY KEY (tag_id)
);

CREATE TABLE report_tag(
	tag_id int,
	report_id int,
	CONSTRAINT pk_report_tag PRIMARY KEY (tag_id, report_id),
	CONSTRAINT fk_report_report_tag FOREIGN KEY (report_id) REFERENCES report(report_id),
	CONSTRAINT fk_tag_report_tag FOREIGN KEY (tag_id) REFERENCES tag(tag_id)
);

CREATE TABLE sensory_experience(
	sensory_experience_id serial,
	sensory_experience_name varchar(25),
	CONSTRAINT pk_sensory_experience PRIMARY KEY (sensory_experience_id)
);

CREATE TABLE report_sensory_experience(
	report_sensory_experience_id serial,
	sensory_experience_id int,
	report_id int,
	CONSTRAINT pk_report_sensory_experience PRIMARY KEY (report_sensory_experience_id),
	CONSTRAINT fk_sensory_experience_report_sensory_experience FOREIGN KEY (sensory_experience_id) REFERENCES sensory_experience(sensory_experience_id),
	CONSTRAINT fk_report_report_sensory_experience FOREIGN KEY (report_id) REFERENCES report(report_id)
);

CREATE TABLE evidence(
	evidence_id serial,
	description text,
	report_sensory_experience_id int,
	CONSTRAINT pk_evidence PRIMARY KEY (evidence_id),
	CONSTRAINT fk_report_sensory_experience_evidence FOREIGN KEY (report_sensory_experience_id) REFERENCES report_sensory_experience(report_sensory_experience_id)
);

CREATE TABLE agency (
	agency_id serial,
	agency_name varchar(25),
	CONSTRAINT pk_agency PRIMARY KEY (agency_id)
);

CREATE TABLE report_agency (
	report_id int,
	agency_id int,
	CONSTRAINT pk_report_agency PRIMARY KEY (report_id, agency_id),
	CONSTRAINT fk_report_report_agency FOREIGN KEY (report_id) REFERENCES report(report_id),
	CONSTRAINT fk_agency_report_agency FOREIGN KEY (agency_id) REFERENCES agency(agency_id)
);



COMMIT;