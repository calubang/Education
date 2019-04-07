select *
from employees;

create table job(
    key number(1)
    , key_name varchar2(10)
    , constraint job_pk primary key(key)
);


create table school(
    name varchar2(10) 
    , age number(3)
    , key number(1)
    , value varchar2(20)
    , constraint school_pk primary key(name) 
    , constraint school_key_fk foreign key(key) references job(key)
);

commit;

