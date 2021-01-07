CREATE DATABASE election_voting_system;
USE election_voting_system;

DROP TABLE IF EXISTS admin_login_credentials;
DROP TABLE IF EXISTS add_candidates;

CREATE TABLE admin_login_credentials
(
username varchar(10) not null,
password varchar(10) not null
);

CREATE TABLE add_candidates
(
ID             int         not null,
Name           varchar(30) not null,
Party          varchar(15) not null,
Nationality    varchar(10) not null,
NIC_No         varchar(12) not null,
Address        varchar(50) not null,
Contact_No     int         not null,
DOB            date        not null,
Gender         varchar(8)  not null,
constraint add_candidates_ID_uindex
unique (ID)
);

alter table add_candidates
add primary key (ID);

CREATE TABLE voters_ballots
(
ID varchar(10) not null,
Name varchar(25) not null,
DOB varchar(15) not null,
constraint voters_ballots_ID_uindex
unique (ID)
);

alter table voters_ballots
add primary key (ID);

CREATE TABLE votes
(
voterID varchar(10) not null,
candidateID varchar(10) not null
);

alter table votes
add primary key (voterID);

INSERT INTO 
admin_login_credentials(username, password)
VALUES 
("admin", "123");


