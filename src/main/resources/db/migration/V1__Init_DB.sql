create sequence document_sequence start 1 increment 1;

create table document (
    id int8 not null,
    name varchar(255),
    save_time timestamp,
    text text,
    primary key (id)
);

ALTER TABLE document
    ALTER COLUMN id
        SET DEFAULT NEXTVAL('document_sequence');

create table document_codes (
    document_id int8 not null,
    code int8
);

alter table if exists document_codes
    add constraint document_codes_fk
    foreign key (document_id) references document;


