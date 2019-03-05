--** [ ] 는 생략이 가능한 구문

-- 모든 사원의 모든 정보를 뿌려라
SELECT
    *
FROM
    employees;

-- 사원의 사번, 이름, 급여

SELECT
    employee_id,
    first_name,
    salary
FROM
    employees;
   
-- 부서의 부서번호, 부서이름

SELECT
    department_id,
    department_name
FROM
    departments;

-- 부서번호(employees 기준)
-- [all / distinct ] 을 통해 중복데이터에 대한 처리가 가능
-- default 로 all 이 걸려있다
-- select 절의 맨앞에서만 가능하다.
-- distinct 는 column 마다 거는것이 불가능.

-- 에러가 나는 형태

SELECT
    employee_id, distinct department_id
from    employees;

-- 정상적인 적용
select distinct employee_id, department_id
from    employees;

-- ** 정리 ** --
select [all | distinct] (* | col1, col2, col3....) FROM TABLE;

-----------------------------------------------------------------------
-- 산술연산식
-- 일반적으로 dual 이라는 테스트용 테이블을 이용한다.
SELECT
    1 + 1
FROM
    dual;

-- 사번, 이름, 급여, 200인상 급여

SELECT
    employee_id,
    first_name,
    last_name,
    salary,
    salary + 200
FROM
    employees;


-- 사번, 이름, 급여, 커미션포함급여
select --*
    employee_id,
    first_name,
    last_name,
    salary,
    commission_pct,
    salary*(1+nvl(commission_pct,0)) as comit
from employees;

--** null 은 알수없다 라는 의미
--** nvl(column, 0 ) -> column 이 null 이면 0으로 대체

----------------------------------------------------------
select
    employee_id 사번,
    first_name as 성,
    last_name as "이름",
    salary as "급여",
    nvl(commission_pct, 0) 커미션,
    salary*(1+nvl(commission_pct,0)) as "커미션 포함급여" -- 공백이 있을경우에는 "" 를 사용
from 
    employees;

-----------------------------------------------------------

-- 사번, 이름(풀네임)
-- || 은 문자열 2개를 붙여주는 기능
-- 문자데이터는 ' ' 로 감싼다
-- oracle db 에서 " "는 별칭에서만 사용이 가능하다.
select 
    employee_id,
    first_name || ' ' || last_name as 풀네임
from
    employees;
    

-- 사번이 100인 사원의 이름은 steven King 입니다. 같은 형식으로 출력
select 
    '사번이 ' || employee_id || '인 사원의 이름은 ' || first_name || ' ' || last_name || ' 입니다.' as info
from 
    employees;

----------------------------------------------------------------------------------------------------
-- 문제1 employee 테이블에서 매니저들의 id 를 출력
select *
from
    employees;

select distinct
    employee_id,
    first_name || ' ' || last_name,
    manager_id
from
    employees;


-- location_id 는 US Texas Southlake 2014 jabberwocky Rd, 우편번호 입니다.  와 같은 형식으로 select 문을 출력하세요(alias는 "주소" 입니다.) 
select location_id || ' 는 ' || country_id || ' ' || state_province || ' ' || street_address || ' , ' || postal_code || ' 입니다.' as 주소
from
    locations;

-- 사원코드, 이름(풀네임), 커미션이 적용된 급여('변경전급여' 라 표시), 전사원커미션 +3.5 가 올라간 급여('변경후급여' 라 표시) 를 출력하세요.
-- 커미션이 null 인경우는 0으로 계산합니다.
select 
    employee_id,
    first_name || ' ' || last_name,
    salary+salary*nvl(commission_pct,0) as 변경전급여,
    salary+salary*(nvl(commission_pct,0 )+3.5) as 변경후급여
from
    employees;
    
--권영찬
--* 사원이름(풀네임), 입사일, 매니저번호 (매니저가 없을 경우 '-1' 으로 표시)
select 
    first_name || ' ' || last_name as 풀네임
from
    employees;

--*  oo번 사원이 oo번 부서에서 oo업무를 시작하게 된 일자는 oo일 입니다. (별칭 "업무기록")

--이소담


--1. 직업이 xx인 사원의 이름 xxx 이며 급여는 xxx 입니다.
--2. 직업  이름(풀네임) 사번 급여 커미션(0) 커미션합급여+2





