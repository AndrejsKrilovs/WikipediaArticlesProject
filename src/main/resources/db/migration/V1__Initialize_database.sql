create schema wikicredit;

create table wikicredit.company
(
    cid int auto_increment,
    name varchar2 not null
);

comment on table wikicredit.company is 'Our table for entity - company name, identified by by cid';

create unique index COMPANY_CID_UINDEX
    on wikicredit.company (cid);

alter table wikicredit.company
    add constraint COMPANY_PK
        primary key (cid);

INSERT INTO WIKICREDIT.COMPANY (NAME) VALUES ('Swedbank');
INSERT INTO WIKICREDIT.COMPANY (NAME) VALUES ('AirBaltic');
INSERT INTO WIKICREDIT.COMPANY (NAME) VALUES ('Ave_Line');
INSERT INTO WIKICREDIT.COMPANY (NAME) VALUES ('Olainfarm');
INSERT INTO WIKICREDIT.COMPANY (NAME) VALUES ('VEF');

commit;

--
-- create table wikicredit.wikipedia_data
-- (
--     cid int,
--     page_id int,
--     summary text,
--     loading_timestamp timestamp
-- );
--
-- comment on table wikicredit.wikipedia_data is 'Data loaded from Wikipedia REST API';