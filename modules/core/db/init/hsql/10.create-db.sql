-- begin EXPERIMENT_PATIENT
create table EXPERIMENT_PATIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MEMBER_NUMBER varchar(255),
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    BIRTH_DATE date,
    --
    primary key (ID)
)^
-- end EXPERIMENT_PATIENT
-- begin EXPERIMENT_CLAIM
create table EXPERIMENT_CLAIM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PATIENT_ID varchar(36),
    CLAIM_DATE date,
    PROVIDER_NAME varchar(255),
    --
    primary key (ID)
)^
-- end EXPERIMENT_CLAIM
