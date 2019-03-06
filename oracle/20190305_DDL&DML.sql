-- DDL Data Definition Language

-- ������ type
-- char(max2000) , varchar2(4000) : ������
-- char, varchar2�� ������
-- char(10) �� ���� 10ĭ�� ������ ���������� �����Ѵ�.
-- varchar2(10) : �ִ� 10�� ������ ���������� �����Ѵ�. 
-- char �� ���� : �������� ������ ������ ������ �����Ͱ� ���� ����� �� ������ �ִ�.
-- ������ ������� �����ϱ� ������ �񱳰� �� �ȵȴ�.
-- long : 2gb ���� ���� ������, �ӵ����������� �� �̿���� �ʴ´�
  
-- �ѱ��� ����
-- �ϼ���, ������
-- euc-kr : �ѱ۸� ���� �ѱ��� 2byte
-- utf-8 : ������ ��� �� ����, �ѱ� 3byte

-- blob : ���̳ʸ� ������ ����
-- clob : character ������ ����

-- ��������
-- not null : null �� ������� ����
-- unique key : ���ϼ��� ��������, null�� ����
-- primary key : null�� �ȵǸ� ���ϼ�
-- foreign key : �ٸ� ���̺��� ���� ����
-- ���������� ����
-- alter table ���̺�� drop constraint ����� [cascade];
-- cascade �� �������� ��ɾ�


-- ȸ��(�ʼ�)    member
-- �̸�            name           varchar2(32)
-- ���̵�          id               varchar2(16)
-- ��й�ȣ       pass           varchar2(16)
-- ����            age              number(3)
-- �̸��Ͼ��̵� email            varchar2(32)
-- �̸��ϵ����� emaildomain   varchar2(32)
-- ������          joindate        date

-- ȸ�� ������ member_detail
-- ���̵�       id                 varchar2(32)
-- �����ȣ    zipcode         varchar2(5) -> ���ڷ� ������ �Ǿ��� 0�ΰ�� �ٸ� ����� ���´�
-- �Ϲݹ�ȣ    address         varchar2(128)
-- ���ּ�    adress_detail   varchar2(128)
-- ��ȭ��ȣ1   tel1               varchar2(3)
-- ��ȭ��ȣ2   tel2               varchar2(4)
-- ��ȭ��ȣ3   tel3               varchar2(4)


drop table member;
drop table member_detail;

create table member
(
    name varchar2(32) not null
    , id varchar2(16)
    , pass varchar2(16) not null
    , age number(3) check( age < 150 and age > 0  )
    , email varchar2(32)
    , emaildomain varchar2(32)
    , joindate date default sysdate
    , constraint member_id_pk primary key (id)
)
;

create table member_detail
(
    id varchar2(32)
    , zipcode varchar2(5)
    , address varchar2(128)
    , adress_detail varchar2(128)
    , tel1 varchar2(3)
    , tel2 varchar2(4)
    , tel3 varchar2(4)
    , constraint member_detaill_id_fk foreign key(id) references member(id)
)
;

create table emp_all
as 
select * from employees
;
create table emp_blank
as 
select * from employees
where 1=0
;

select *


drop table emp_50
;


create table emp_50
as 
select emp.employee_id eid
    , emp.first_name name
    , emp.salary sal
    , dep.department_name dname
from employees emp, departments dep
where emp.department_id = 50
and emp.department_id = dep.department_id
;

-- DML Data 
-- insert

insert into member
values (
    '�Ⱥ���'  -- name varchar2(32) not null
    ,'calubang' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    ,32 -- age number(3) check( age < 150 and age > 0  )
    ,'acalubang' -- email varchar2(32)
    ,'gmail.com' -- emaildomain varchar2(32)
    , sysdate -- joindate date default sysdate
)
;

insert into member(
    name
    , id
    , pass
    , age
    , email
    , emaildomain
    , joindate
)
values (
    '�����'  -- name varchar2(32) not null
    ,'leejw' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    ,32 -- age number(3) check( age < 150 and age > 0  )
    ,'acalubang' -- email varchar2(32)
    ,'gmail.com' -- emaildomain varchar2(32)
    , sysdate -- joindate date default sysdate
)
;

insert into member(
    name
    , id
    , pass
    , joindate
)
values (
    '�����2'  -- name varchar2(32) not null
    ,'leejw2' -- id varchar2(16)
    ,'zkfqod' -- pass varchar2(16) not null
    , sysdate -- joindate date default sysdate
)
;

select  *
from member_detail
;

delete from member;


insert into member_detail(
    id    -- varchar2
    , zipcode -- varchar2
    , address -- varchar2
    , address_detail  -- varchar2
    , tel1 -- varchar2
    , tel2 -- varchar2
    , tel3 -- varchar2
)
values (
    '�Ⱥ���'  
    ,'12345' 
    ,'��⵵' 
    ,'�����' 
    ,'010' 
    ,'7163'
    , '3863' 
)
;



insert all
    into member(
        name
        , id
        , pass
        , age
        , email
        , emaildomain
        , joindate
    )
    values (
        '����Ŭ'  -- name varchar2(32) not null
        ,'oracle2' -- id varchar2(16)
        ,'1234' -- pass varchar2(16) not null
        ,25 -- age number(3) check( age < 150 and age > 0  )
        ,'acalubang' -- email varchar2(32)
        ,'gmail.com' -- emaildomain varchar2(32)
        , sysdate -- joindate date default sysdate
    )
     into member_detail(
        id    -- varchar2
        , zipcode -- varchar2
        , address -- varchar2
        , address_detail  -- varchar2
        , tel1 -- varchar2
        , tel2 -- varchar2
        , tel3 -- varchar2
    )
    values (
        null  
        ,'12345' 
        ,'��⵵' 
        ,'�����' 
        ,'010' 
        ,'7163'
        , '3863' 
    )
select * from dual
;



select
    *
from 
    member mem
    , member_detail memd
where
    mem.id = memd.id
;

commit;

purge recyclebin;

select *
from tab;

select 
    *
from
    emp_blank;

-- insert
insert into emp_blank
select
    *
from
    employees emp
where
    department_id = 80
;


insert into emp_blank(
    employee_id
    , first_name
    , last_name
    , job_id
    , department_id
    , email
    , hire_date
)
select
    employee_id
    , first_name
    , last_name
    , job_id
    , department_id
    , email
    , hire_date
from
    employees
where
    employee_id = 100
;

-- update
commit;

rollback;

select
    *
from
    member
;

update member
set
    pass = '5678'
    , age = (
                select age
                from member
                where id = 'oracle'
            )
where
    id = 'oracle2'
;

-- delete
commit;

rollback;

select
    *
from member_detail
;
select
    *
from member
;

delete member_detail
where id = 'oracle'
;

delete member
where id = 'oracle'
;

-- merge
drop table product;

create table product
(
    pid number
    , pname varchar2(10)
    , cnt number
    , price number
    , constraint product_pid_pk primary key (pid)
)
;
insert all
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        100
        , '�����'
        , 100
        , 1500
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        200
        , '����Ĩ'
        , 80
        , 2700
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        300
        , '������'
        , 120
        , 1000
    )
select *
from dual
;

select
    *
from member_detail
;

-- �߰� on () �� �ʼ��̴�
merge into member mem
using member_detail memd
on (mem.id = memd.id
and memd.zipcode = '12345')
when matched then
update set pass = '4444'
when not matched then
insert(
    id
    , pass
    , name
)
values(
    'java'
    , '3333'
    , '�ڹ�'
)
;

select
*
from
    member
;



merge into product
using dual
on (pid = 400)
when matched then
update set cnt = cnt + 150
when not matched then
insert 
    (pid, pname, cnt, price)
    values(
        400
        , '�ڰ�ġ'
        , 150
        , 1200
    )
;

commit;
--------------------------------------------------------------------------------------------
select
    *
from 
    product
;

update product
set cnt = 400
where  pid = 100
;

-- transection : �۾��� ����
-- commmit : �۾��� ���ڵ忡 �ݿ�
-- rollback : �۾��� ���
-- DML ������ ������ �����̴�
commit;

insert all
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        101
        , '�����'
        , 101
        , 1501
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        102
        , 'Ĩ�ϲ�'
        , 82
        , 2702
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        103
        , '�λ���'
        , 123
        , 1003
    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        104
--        , '�����'
--        , 124
--        , 1004
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        105
--        , 'Ĩ����'
--        , 125
--        , 1005
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        106
--        , '���λ�'
--        , 126
--        , 1006
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        107
--        , '�����'
--        , 127
--        , 1007
--    )
select *
from dual
;
insert all
--   into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        101
--        , '�����'
--        , 101
--        , 1501
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        102
--        , 'Ĩ�ϲ�'
--        , 82
--        , 2702
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        103
--        , '�λ���'
--        , 123
--        , 1003
--    ) 
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        104
--        , '�����'
--        , 124
--        , 1004
--    )
--    into product (
--        pid
--        , pname
--        , cnt
--        , price
--    )
--    values(
--        105
--        , 'Ĩ����'
--        , 125
--        , 1005
--    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        106
        , '���λ�'
        , 126
        , 1006
    )
    into product (
        pid
        , pname
        , cnt
        , price
    )
    values(
        107
        , '�����'
        , 127
        , 1007
    )
select *
from dual
;

-- �� �������� transection�� ����Ʈ�� ����
savepoint b;

select *
from product;

rollback to b;

commit to b;

-- sequence 
-- 1���ͽ����ϰ� 1�� ����
-- SEQUENCE_NAME.nextval �� ���� ������Ų��.
-- SEQUENCE_NAME.currval �� ���� �����ġ�� �̴´�.
-- �ϳ��� ���������� ������ ������ų �� ����.
create sequence product_seq
start with 1 increment by 1;

delete product;

commit;

insert into product(
    pid
    , pname
    , cnt
    , price
)
values(
    product_seq.nextval
    , '����'
    , 10
    , 1000
)
;

select * from product;

select product_seq.currval, product_seq.nextval
from dual
;

commit;

