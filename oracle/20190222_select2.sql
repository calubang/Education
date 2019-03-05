-- 검색문[query] (select)

-- 급여를 5000이상 받는 사원의 사번, 이름, 급여, 부서번호
SELECT
    employee_id     AS 사번,
    first_name
    || ' '
    || last_name AS 이름,
    salary          AS 급여,
    department_id   AS 부서번호
FROM
    employees
WHERE
    salary >= 5000;
-- 사번이 100번인 사원의 사번, 이름, 부서번호

SELECT
    employee_id,
    first_name,
    department_id
FROM
    employees
WHERE
    employee_id = 100;
    
-- 근무도시가 seatle 인 지역의 지역번호, 우편번호

SELECT
    *
FROM
    locations
WHERE
    lower(city) = lower('Seattle');
    
-- 급여를 5000 이상 받으면서 10000 미만를 받는 사원의 사번 이름 급여 부서번호

SELECT
    employee_id     AS 사번,
    first_name      AS 성,
    last_name       AS 이름,
    salary          AS 급여,
    department_id   AS 부서번호
FROM
    employees
WHERE
    salary >= 5000
    AND salary <= 12000;
    
-- 부서번호가 50인 사원 중 급여를 5000이상 받는 사원의 사번, 이름, 급여 부서번호

select 
    employee_id,
    first_name,
    salary,
    department_id    
from 
    employees
where 
    department_id = 50
    and salary >= 5000
;

-- 급여를 5000 이상 받으면서 12000 이하를 받는 사원의 사번 이름 급여 부서번호

SELECT
    employee_id     AS 사번,
    first_name      AS 성,
    last_name       AS 이름,
    salary          AS 급여,
    department_id   AS 부서번호
FROM
    employees
WHERE
    salary between 5000 and 12000
    ;
    
-- 커미션을 받는 사원의 사번, 이름, 급여, 커미션포함급여
-- null 은 알수없다 이기 때문에 같다 다르다 비교할수가 없다.
-- null 을 비교할때에는 is 라는 녀석을 이용한다.
select 
    employee_id,
    first_name,
    salary,
    nvl(commission_pct,0) 커미션,
    salary + (salary * nvl(commission_pct, 0)) as 커미션포함급여
from 
    employees
where 
    --nvl(commission_pct, 0) != 0
    commission_pct is not null
    ;
    
-- 근무부서가 50, 60, 80 인 사원의 사번, 이름, 부서번호

select 
    employee_id,
    first_name,
    department_id
from 
    employees
where
    department_id = 50 
    or department_id = 60
    or department_id = 80
    --or department_id is null
    ;

-- 근무부서가 50, 60, 80 이 아닌 사원의 사번, 이름, 부서번호
select
    employee_id,
    first_name,
    department_id
from 
    employees
where 
    department_id != 50
    and department_id != 60
    and department_id != 80
    --or department_id is null
    ;

select
    *
from 
    employees
where 
    department_id in (50, 60, 80)
;

select
    *
from 
    employees
where 
    department_id not in (50, 60, 80)
;

-- 급여가 3천이상이거나 8천이상이거나 5천 이상인 사원의 사번, 이름, 급여
select
    employee_id,
    first_name,
    salary
from 
    employees
where 
    salary >= 3000
    or salary >= 8000
    or salary >= 5000
;

-- in 과 any의 차이점
-- in 은 동일한지에 대한 비교 
-- any 는 등가비교가 가능

select
    employee_id,
    first_name,
    salary
from 
    employees
where 
    salary >= any(3000, 5000, 8000)
;

-- 급여가 3000이상이고 8천이상이고 5천 이상인 사원의 사번, 이름, 급여
 
select
    employee_id,
    first_name,
    salary
from 
    employees
where 
    salary >= 3000
    and salary >= 8000
    and salary >= 5000
;

select
    employee_id,
    first_name,
    salary
from 
    employees
where 
    salary >= all( 3000, 8000, 5000)
;

-- 현재시간, 3일후, 3시간 후
select 
    sysdate, 
    to_char(sysdate, 'yy.mm.dd hh24:mi:ss'),
    to_char(sysdate + 3, 'yy.mm.dd hh24:mi:ss') "3일후",
    to_char(sysdate + 3/24, 'yy.mm.dd hh24:mi:ss') "3시간후"
from 
    dual
    ;

-- 이름이 steven 인 사원의 사번과 이름
select
    *
from 
    employees
where 
    lower(first_name) = 'steven'
    ;

-- 이름이 's' 로 시작하는 사원의 사번과 이름
select
    *
from
    employees
where 
    lower(first_name) like lower('s%')
    ;

-- 이름이 'e' 를 포함하고 있는
select
    *
from 
    employees
where 
    lower(first_name) like lower('%e%')
;

-- 이름이 'y'로 끝나는 사람
select
    *
from 
    employees
where 
    lower(first_name) like lower('%y')
;
-- 이름에서 끝에서 두번째가 'e'인 사원의 사번, 이름
select
    *
from
    employees
where
    first_name like '%e_'
    ;

-- 부서번호가 50이 아닌 사원의 
select
    *
from
    employees
where 
    department_id ^= '50'
    ;


-- 모든 사원의 사번, 이름, 급여
-- 단 급여순 정렬
-- 숫자로 하면 select 에서 나오는 column에 맞춰서 나온다.
-- column 명을 직접 명시하는것이 더 좋다
-- asc 오름차순, desc 내림차순
-- default 는 asc 오름차순
select 
    employee_id as 사번,
    first_name,
    salary
from
    employees
order by salary desc
;

-- 부서번호 사번 이름 급여
-- 부서별 급여순으로 정렬
-- 별칭으로도 정렬할 수 있다.
select
    employee_id,
    first_name,
    department_id,
    salary
from
    employees
order by 
    department_id asc, 
    salary desc
;

-- 근무도시가 'seattle' 인 사원의 사번, 이름, 부서번호

select
    *
from
    locations
where
    lower(city) = lower('seattle')
    ;    
-- 1700

select
    *
from
    departments
where
    location_id = 1700
;
-- 10, 90, 110, 190

select
    *
from
    employees
where
    department_id in ( 10, 90, 110, 190)
    ;






--문제1. 입사일이 91/01/02 과 98/12/21 사이인 사원의 정보를 출력.(사원번호, 풀네임, 입사일, 급여(커미션이 있다면 포함할것), 커미션(없으면 0으로 표시) 으로 출력할것)
select 
    employee_id as 사원번호,
    first_name || ' ' || last_name as 풀네임,
    hire_date as 입사일,
    salary + salary * nvl(commission_pct, 0) as 급여,
    nvl(commission_pct, 0) as 커미션
from
    employees
where 
    hire_date between '91/01/02' and '98/12/21'
    ;

-- 문제2. employees에서 회장(president)의 사번을 알아낸뒤 사장의 인적사항을 채워넣으세요.
-- 사번 : 100
-- 풀네임 : Steven King
-- 입사일 : 87/06/17
-- 커미션포함된 급여 : 24000
-- 소속부서명 : Executive
-- 부서가 속한 주소(자세히) : US Washington Seattle 2004 Charade Rd, 98199

select 
    *
from
    jobs
;
-- AD_PRES

select
    employee_id,
    first_name || ' ' || last_name,
    hire_date,
    salary + salary * nvl(commission_pct, 0),
    department_id
from
    employees
where 
    lower(job_id) = lower('AD_PRES')
    ;

-- 90
select
    *
from
    departments
where
    department_id = 90
    ;
-- 1700

select
    *
from
    locations
where
    location_id = 1700
    ;


-- 부서가 ShiPping 에 속하면서 급여는  2000 ~ 4000 사이면서 firstName에 알파펫 t 가 들어가는 사람이면서 입사일이 97/01/01~98/12/30 에 포함되지 않는 사람의 사번과 풀네임은?
select 
    department_id, department_name
from 
    departments
where 
    lower(department_name) = lower('ShiPping')
;
-- 50

select
    employee_id,
    first_name || ' ' || last_name
from
    employees
where
    department_id = 50
    and (salary between 2000 and 4000)
    and lower(first_name) like '%t%'
    and hire_date not BETWEEN '97/01/01' and '98/12/30'
    --and first_name not like '%t%'
;

select
    *
from
    job_history
order by
    start_date, end_date
;


-- 운재형 퀴즈
-- 1. 7000~9000 사이의 급여를 받을 수 있는 직업 이름 중에서 'Manager'를 포함하는 직업 이름, 최소 급여, 최대 급여 (최소 급여는 오름차순으로 정렬)
select
    job_title,
    min_salary,
    max_salary
from 
    jobs
where 
    lower(job_title) like '%manager%'
    and min_salary <= 9000 
    and max_salary >= 7000
order by
    min_salary 
    ;
    
    
-- 2. 관리자 번호가 부여되지 않은 부서의 부서번호
-- 정답 : 190
select
    *--department_id
from
    departments
where
    manager_id is null
    ;
-- 10
-- 20
-- 50
-- 60
-- 80
-- 90
-- 110
-- 190

select 
    distinct department_id
from
    employees
order by
    department_id
;
-- 10 20 50 60 80 90 110
-- 세자리 부서 번호에 속한 사원의 급여 (급여가 많은 순서대로 정렬)
select 
    *
from
    employees
where 
    department_id like '___'
order by salary
    ;


-- 4. 1990년 이후에 고용된 사원의 이름, 이메일, 고용 일자 (먼저 입사한 순서대로 정렬)
select
    first_name,
    email,
    hire_date
from
    employees
where
    --to_char(hire_date, 'yy') >= '90'
    hire_date > '90/01/01'
order by
    hire_date
;

-- 5. 커미션, 관리 번호, 부서 번호가 하나라도 알 수 없는 사원의 이름, 전화번호 (전화번호는 오름차순)

select
    first_name || ' ' || last_name as 이름,
    phone_number as 전화번호
from
    employees
where
    commission_pct is null
    or manager_id is null
    or department_id is null
order by 
    phone_number
;

-- 6. 
SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null;

SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    employee_id asc;

SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    commission_pct asc;
    
SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    commission_pct desc, employee_id asc;
    
SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    employee_id asc, commission_pct desc;
    
    

select 
    *
from
    employees
where
    salary > 5000
    or lower(first_name) > '%a%'
    --and  (hire_date > '94/01/01' and hire_date < '95/01/01'))
    or lower(first_name) > '%p%'
;

select 
    *
from
    employees
where 
    salary > 5000
    or 
;

select 
    *
from
    employees
where
    lower(first_name)
    lower(first_name) > 's%'
    
    and (hire_date > '94/01/01' and hire_date < '95/01/01')
    and salary <9000
;


SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    commission_pct desc, employee_id asc;

SELECT
    employee_id,
    email,
    hire_date,
    salary,
    manager_id,
    department_id
FROM
    employees
WHERE
    commission_pct is null
ORDER BY
    commission_pct asc;
    
select *
from employees
order by department_id desc
;

-- any 이중에 하나(or)이고 all 은 이것들 모두(and) 에 만족하는 조건이다.


