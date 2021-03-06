create table wikicredit.wikipedia_data
(
    id int,
    cid int,
    page_id int,
    summary text,
    loading_timestamp timestamp
);

comment on table wikicredit.wikipedia_data is 'Data loaded from Wikipedia REST API';