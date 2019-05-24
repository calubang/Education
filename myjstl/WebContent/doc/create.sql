drop sequence product_id_seq;
drop SEQUENCE order_info_no_seq;
drop table order_line;
drop table order_info;
drop table product;
drop table product_category;
drop table customer;

create sequence product_id_seq
	start with 0
	increment by 1
    MINVALUE 0
    MAXVALUE 99999
    ;

create table customer(
	id varchar2(16)
	, pass varchar2(16)
	, name varchar2(30)
	, address varchar2(100)
	, constraint customer_pk PRIMARY KEY(id)
);

create table product_category(
	cate_no	char(1)
	, cate_name	varchar2(30)
        CONSTRAINT cate_name_nn not null 
    , CONSTRAINT cate_no_pk PRIMARY KEY(cate_no)
);

create table product(
	prod_no varchar2(5)
	, prod_cate  char(1) 
        CONSTRAINT prod_cate_nn not null 
	, prod_name varchar(100)
        CONSTRAINT prod_name_nn not null 
	, prod_price number(10) 
        CONSTRAINT prod_price_nn not null 
        CONSTRAINT prod_price_ck check(prod_price >= 0)
	, prod_detail varchar2(50)
	, constraint prod_no_pk primary key(prod_no)
	, constraint prod_cate_cate_no_fk  foreign key(prod_cate) references product_category(cate_no)
);

create sequence order_info_no_seq
	start with 0
	increment by 1
    MINVALUE 0
    MAXVALUE 99999
;

create table order_info(
    order_no number
    , order_id varchar2(16)
    , order_dt date DEFAULT sysdate
    , CONSTRAINT order_info_pk PRIMARY KEY(order_no)
    , CONSTRAINT order_info_customer_id_fk FOREIGN KEY(order_id) REFERENCES customer(id)
);

create table order_line(
    order_no number
    , order_prod_no varchar2(5)
    , order_quantity number(3)
    , CONSTRAINT order_line_pk PRIMARY KEY(order_no, order_prod_no)
    , CONSTRAINT order_line_oder_info_fk FOREIGN KEY(order_no) REFERENCES order_info(order_no)
    , CONSTRAINT order_line_product_fk FOREIGN KEY(order_prod_no) REFERENCES product(prod_no)
);


insert into product_category(
	cate_no
	, cate_name
) values(
	'D'
	, '음료'
);

insert into product_category(
	cate_no
	, cate_name
) values(
	'F'
	, '음식'
);

insert into product_category(
	cate_no
	, cate_name
) values(
	'G'
	, '상품'
);

insert into product(
	prod_no 
	, prod_cate 
	, prod_name
	, prod_price
) values(
	trim(to_char(product_id_seq.nextval, '00000'))
    , 'D'
	, '아메리카노'
    , 2500
);

insert into product(
	prod_no 
	, prod_cate 
	, prod_name
	, prod_price
) values(
	trim(to_char(product_id_seq.nextval, '00000'))
    , 'D'
	, '아이스 아메리카노'
    , 2500
);

insert into product(
	prod_no 
	, prod_cate 
	, prod_name
	, prod_price
) values(
	trim(to_char(product_id_seq.nextval, '00000'))
    , 'D'
	, '카페라떼'
    , 3000
);

insert into product(
	prod_no 
	, prod_cate 
	, prod_name
	, prod_price
) values(
	trim(to_char(product_id_seq.nextval, '00000'))
    , 'F'
	, '치즈케잌'
    , 4000
);

insert into customer(
	id
	, pass
	, name
)values(
	'calubang'
	, '123'
	, '안병욱'
);

commit;

select *
from product
;

select *
from product_category
;
-- 전체 상품목록 조회
select 
    cate.cate_no
    , cate.cate_name
    , prod.prod_no
    , prod.prod_name
    , prod.prod_price
    , prod.prod_detail
from 
    product prod 
    inner join product_category cate
        on prod.prod_cate = cate.cate_no
order by 
    cate_no
    , prod_name
;

-- 카테고리별 조회
select 
    cate.cate_no
    , cate.cate_name
    , prod.prod_no
    , prod.prod_name
    , prod.prod_price
    , prod.prod_detail
from 
    product prod 
    inner join product_category cate
        on prod.prod_cate = cate.cate_no
where 
    upper(cate.cate_no) = upper('D')
order by 
    cate_no
    , prod_name
;

--D카테고리에 해당하는 총상품가격을 출력
select 
    sum(prod_price)
from 
    product 
where 
    upper(prod_cate) = upper('D')
;

--카테고리별 총상품가격
SELECT 
    SUM(prod.prod_price) as prod_cate_sum_price
from 
    product prod 
    inner join product_category cate
        on prod.prod_cate = cate.cate_no
group by
    cate.cate_no
;

-- id로 검색하기
select
    prod.prod_no
    , prod.prod_cate
    , prod.prod_name
    , prod.prod_price
    , prod.prod_detail
    , cate.cate_no
    , cate.cate_name
from
    product prod
    inner join product_category cate
        on prod.prod_cate = cate.cate_no
where 
    prod_no = '00001'
;

