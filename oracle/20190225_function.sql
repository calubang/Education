-- round(a, b) 는 반올림 
-- b까지 나오도록 반올림
select 
    1234.5438,
    round(1234.5438, 1),
    round(1234.5438, 3),
    round(1234.5438, -3)
from
    dual
;

-- trunc(a, b) 는 내림 
-- b까지 나오도록 내림
select 
    1234.5438,
    trunc(1234.5438, 1),
    trunc(1234.5438, 3),
    trunc(1234.5438, -3)
from
    dual
;

--floor(a) 는 소수점 버리기
select 
    1234.5438,
    floor(1234.5438),
from
    dual
;

-- mod(a, b) : a / b의 나머지연산
select
    5+3,
    5-3,
    5*3,
    5/3,
    mod(5, 3)
from 
    dual
    ;

-- abs(a) : a 의 절대값    
select
    abs(+3),
    abs(-3),
    abs(3)
from
    dual
;

-- 사원의 사번, 이름, 급여, 커미션포함급여
-- 커미션 포함 급여는 100의 자리수로 반올림
select
    employee_id,
    first_name || ' ' || last_name as 풀네임,
    salary,
    commission_pct,
    salary + round(salary*nvl(commission_pct, 0), -2) as "커미션 포함"
from
    employees
;

-- kItRi 
-- lower 소문자
-- upper 대문자
-- initcap 첫글자만 대문자
select
    'kItRi',
    lower('kItRi'),
    upper('kItRi'),
    initcap('kItRi'),
    length('kItRi')
from dual
;

-- 사번, 풀네임
-- concat(a, b) a 와 b 문자열을 합쳐라
select
    employee_id,
    first_name || ' ' || last_name as 풀네임,
    concat(concat(first_name, ' ' ), last_name)
from
    employees
;

-- Oracle 에서의 index는 1부터 시작한다.
-- substr(a, b, [c]) : a는 문자열, b,c는 숫자, c는 생략가능(생략시 끝까지나온다)
-- a에서 b번째부터 c만큼의 문자열을 반환
-- - 가 오면 오른쪽부터 추출
-- 없으면 null
select 
    'hello oracle !!!',
    substr('hello oracle !!!', 2, 6),
    substr('hello oracle !!!', 2)
from dual;

-- instr(a, b, [c], [d]) : a,b 는 문자열 c 는 숫자, c,d는 생략가능(생략시 처음부터검색, 연속의미 없음)
-- a에서 c번째 문자부터 b가 d번째로 나타나는 절대위치
-- 없으면 0
select 
    'hello oracle !!!',
    instr('hello oracle !!!', 'ㅁ', 6)-1,
    instr('hello oracle !!!', 'ㅁ')
from dual;

select
    '123-456' as zip,
    instr('123-456', '-'),
    substr('123-456', 1, instr('123-456', '-')-1) as zip1,
    substr('123-456', instr('123-456', '-')+1, 3) as zip2,
    substr('010-7163-3863', 1, instr('010-7163-3863', '-')-1) as phone1,
    substr('010-7163-3863', instr('010-7163-3863', '-')+1, instr('010-7163-3863', '-', 1, 2)-1 - instr('010-7163-3863', '-') ) as phone2,
    substr('010-7163-3863', instr('010-7163-3863', '-', 1, 2)+1) as phone3
    --instr('010-7163-3863', '-', instr('010-7163-3863', '-')+1)))
from dual
;

select
    '1234-56' as zip,
    instr('1234-56', '-'),
    substr('1234-56', 1, instr('1234-56', '-')-1) as zip1,
    substr('1234-56', instr('1234-56', '-')+1 ) as zip2
from dual
;

select
    employee_id,
    lpad(employee_id, 5, 'abc'),
    rpad(employee_id, 5, 'abc')
from 
    employees
;

-- 날짜연산 
select 
    sysdate,
    sysdate + 3,
    to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
    to_char(sysdate + 3 / 24, 'yyyy-mm-dd hh24:mi:ss')
from dual
;

-- months_between(A, B) : a, b사이의 개월수차이
select
    sysdate,
    sysdate + 70,
    months_between(sysdate, sysdate + 70)
from dual
;

-- next_day(a, b) : a에서 가장 가까운 b일
-- 일요일부터 1을 의미
select
    sysdate,
    next_day(sysdate, 1),
    next_day(sysdate, 3),
    next_day(sysdate, '월')
from dual
;

-- add_months(a, b) : a에 b만큼 개월을 더한 날짜
-- last_day(a) : a의 마지막 날
select
    sysdate,
    add_months(sysdate, 2),
    to_char(last_day(sysdate), 'yyyy mm dd hh mi ss'),
    round(sysdate, 'day')
from
    dual
;

-- mm 숫자형태 월(0x) mon 은 JAN 축약 , month 는 january 와 같은 풀네임
-- w 는 해당월의 몇주차, ww 는 해당년의 몇주차
-- d 는 주에서 몇일차(일요일시작)  dd 는 월에서 몇일차, ddd는 년에서 몇일차
-- dy 월  day 월요일 
-- am(pm) hh 오전(오후) 시간
-- hh 는 12시형태, hh24 는 24시간형태
-- mi 분 
-- ss 초
select
    sysdate
    ,to_char(sysdate, 'yyyy') as a
    --,to_char(sysdate, 'yyyy mm mon')
    --,to_char(sysdate, 'yyyy mm month')
    ,to_char(sysdate, 'yyyy mm mon d dd ddd')
from dual
;

select 
    to_char(sysdate, 'yyyy mm dd hh24:mi:ss') as "sysdate"
    , to_char(round(sysdate), 'yyyy mm dd hh24:mi:ss') as "to_char" 
    , to_char(round(sysdate, 'dd'), 'yyyy mm dd hh24:mi:ss') as dd 
    , to_char(round(sysdate, 'mm' ), 'yyyy mm dd hh24:mi:ss') as mm
    , to_char(round(sysdate, 'hh' ), 'yyyy mm dd hh24:mi:ss') as hh
    , to_char(round(sysdate, 'mi' ), 'yyyy mm dd hh24:mi:ss') as mi
from
    dual
union
select 
    to_char(sysdate, 'yyyy mm dd hh24:mi:ss') as "sysdate"
    , to_char(trunc(sysdate), 'yyyy mm dd hh24:mi:ss') as "to_char"
    , to_char(trunc(sysdate, 'dd'), 'yyyy mm dd hh24:mi:ss') as dd
    , to_char(trunc(sysdate, 'mm' ), 'yyyy mm dd hh24:mi:ss') as mm
    , to_char(trunc(sysdate, 'hh' ), 'yyyy mm dd hh24:mi:ss') as hh
    , to_char(trunc(sysdate, 'mi' ), 'yyyy mm dd hh24:mi:ss') as mi
from
    dual
;

-- 변환 함수
select 
    3
    , '3'
    , '3' + 3  -- 자동형변환
from
    dual
;

-- to_char(a, b) : a 를 b 형태의 문자열로 변환
-- b는 a보다 자리수가 크거나 같아야한다.
-- 소수점은 부족하면 반올림
select
    123456.789
    , to_char(123456.789, '000,000,000.00') as "000,000,000.00" -- 빈자리에 0 이 채워진다
    , length(to_char(123456.789)) as len1
    , to_char(123456.789, '999,999,999.990') as "999,999,999.99" -- 빈자리에 빈공간이 채워진다
    , length(to_char(123456.789, '999,999,999.990')) as len2
    , to_char(123456.789, '$009,999.9900') as "09,999.9900"
from dual
;

-- to_number(a, b) : a 를 b 형태의 숫자로 변환
-- b 는 a보다 자리수가 같아야한다.
select
    '123,456.78'
    , to_number('123,456.78', '000,000.00') + 3
from dual
;

-- 20190225142154 >> 날짜 >> 3일후
select
    20190225142154
    , to_char(20190225142154) as "to_char"
    , length( to_char(20190225142154))
    , to_date('20190225142154', 'yyyymmddhh24miss') as "to_date"
    , to_char(to_date(to_char(20190225142154), 'yyyymmddhh24miss') + 3, 'yyyy mm dd hh24:mi:ss') as "3일후"
    , to_date('15, 1월, 2019', 'dd, Month, yyyy')
from
    dual
;

--일반함수
-- nvl(a, b) : a가 null 이면 a를 return, null이면 b를 return
-- nvl2(a, b, c) : a가 null 이면 c를 null 이면 b를 return

-- 급여가 4000 미만인 사원은 저연봉, 10000미만은 평균연봉, 10000이상은 고연봉
select
    EMPLOYEE_ID,
    FIRST_NAME,
    SALARY,
    case
        when SALARY < 4000  then
            '저연봉'
        when SALARY < 10000 then
            '평균연봉'
        else
            '고연봉'
    end as 연봉등급
from
    EMPLOYEES
order by SALARY desc
;

-- 1980년도 입사 임원, 90 평사원, 00 신입사원
select
    employee_id
    , first_name
    , last_name
    , hire_date
    , case
        when to_char(hire_date, 'yy') like '8%' then
            '임원'
        when hire_date < to_date('2000/01/01') then
            '평사원'
        else
            '신입사원'        
      end 사원구분
from
    employees
order by hire_date, employee_id
;

-- 모든 문자값은 ascii 로 해당되는 숫자로 표현될 수 있다.
-- 이것을 통해 문자열의 비교가 가능하다
-- 왼쪽부터 차례대로 하나씩 ascii 를 통해 비교한다. 
select
    ascii('0')
    , ascii('A')
    , ascii('a')
from
    dual
;

------------------------------------------------------------------------------------------
-- 함수사용
-- 형변환
-- case 문 사용
-- job_id 를 통해 어떤 사업부에서 일하는지 분류하여라.(job_id 의 '_' 이전이 사업부코드라 가정하며 _이전에는 몇개의 알파벳이 올지 알 수 없다.)
-- ad : Administration
-- ac : Accounting
-- sa : Sales
-- st : Stock
-- it : It
-- mk : Marketing
-- 최종형태 : 사번, last_name(이름) job_id(직업코드), 사업부
-- 정렬은 사업부, 사번 순으로 오름차순

select
    employee_id as 사번
    , last_name as 이름
    , job_id as 직업코드
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '사업부없음'
      end as "사업부"
from
    employees
order by 사업부, employee_id
;

-- 날짜 변환 
-- 근속일에 따른 커미션 상승과 근속월에 따른 임금상승을 하려고 한다.
-- 커미션상승은 근속일 8천미만은 +1, 1만미만은 +2, 그 이상은 +3 (기존에 commission_pct가 없다면 0으로 생각)
-- 임금상승은 250주 미만은 +1000 , 300주 미만은 +2000, 350주 미만은 +3000, 350주 이상은 + 5000 을 한 값을 구하라.
-- 사번, 입사일, 기존 커미션, 상승된커미션, 기존임금, 상승된임금 (사번, 입사일순으로 오름차순)

select
    employee_id as 사번
    , hire_date as 입사일
    , nvl(commission_pct,0) as 기존커미션
    , case
        when sysdate - hire_date < 8000 then
            nvl(commission_pct,0) + 1
        when sysdate - hire_date < 10000 then
            nvl(commission_pct,0) + 2
        else
            nvl(commission_pct,0) + 3
      end as "상승된커미션"  
    , salary as 기존임금
    , case
        when months_between(sysdate, hire_date) < 250 then
            salary + 1000
        when months_between(sysdate, hire_date) < 300 then
            salary + 2000
        when months_between(sysdate, hire_date) < 350 then
            salary + 3000
        else
            salary + 5000
      end as 상승된임금
from
    employees
order by employee_id, hire_date
;

-- phone_number 에서 . 구분자가 3개면 핸드폰번호, 2개면 집 전화번호 라고 가정하고
-- 집전화번호는 앞에 02. 을 추가하고 핸드폰번호는 그대로 두고 출력한다.
-- 최종출력 : 사번, 기존폰번호, 변경된번호, 폰번호 종류

select 
    employee_id
    , phone_number
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            concat('02.', phone_number) 
        else
            phone_number
      end as "변경된 번호" 
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            '집 번호'
        else
            '핸드폰 번호'
      end as "폰번호 종류"
from
    employees
;

SELECT  '010-34-568' pnum, 
        substr('010-34-568', 1, (instr('010-34-568', '-')-1)) pnum1, 
        substr('010-34-568', instr('010-34-568', '-') +1 , (instr('010-34-568', '-', (instr('010-34-568', '-')+1)) - instr('010-34-568', '-')-1)) pnum2,
        substr('010-34-568', (instr('010-34-568', '-', instr('010-34-568', '-')+1)+1)) pnum3
        
FROM    dual;

-- 1. 다음의 조건들을 만족하는 "결과" 열을 출력하세요 (내림차순으로 정렬)
-- 1) 부서 번호가 없는 경우 : 풀 네임
-- 2) 관리자 번호가 없는 경우 : 고용 일을 XXXX-YY-ZZ 형식으로
-- 3) 커미션을 알 수 있는 경우 : 봉급에 커미션을 포함하여 십의 자리에서 반올림하고 5자리로 표현 (단, 5자리 보다 작을 경우 공백 처리)
------ 1), 2), 3) 조건을 만족하지 않는 경우 --
-- 4) 이름이 3글자인 경우 : 현재 날짜 기준으로 근속 년수
-- 5) IT로 시작하는 직무인 경우 : 전화번호
------ 4), 5) 조건을 만족하지 않는 경우 --
-- 6) 고용일이 80년대인 경우 : 봉급을 5자리로 표현 (단, 5자리 보다 작을 경우 공백 처리)
-- 7) 그 외의 경우 : 이메일

5--*사번이 100~199번인 사원의 사번, 이름, 급여, 커미션포함급여 ( 100자리수표시)


6 자신포함조원의 번호 표시 ( substr / instr 사용)


7 사원번호, 이름, 급여, 커미션포함급여, 급여등급-커미션포함급여 ( 내림차순)

select employee_id, first_name, salary, round(salary+salary*nvl(commission_pct, 0), -2)
where employee_id between 100 and 199;
from employees
;

select 
    *
from
    job_grades
    ;

select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0 ),
      case
      when salary+salary*nvl(commission_pct, 0 ) <3000
      then 'A'
      when salary+salary*nvl(commission_pct, 0 ) <6000
      then 'B'
      when salary+salary*nvl(commission_pct, 0 )<10000
      then 'C'
      when salary+salary*nvl(commission_pct, 0 ) < 15000
      then 'D'
      when salary+salary*nvl(commission_pct, 0 ) < 25000
      then 'E'
      else 'F'
      end 급여등급
      from employees
order by salary+salary*nvl(commission_pct, 0 ) desc;

select 
    employee_id
    , phone_number
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            concat('02.', phone_number) 
        else
            phone_number
      end as "변경된 번호" 
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            '집 번호'
        else
            '핸드폰 번호'
      end as "폰번호 종류"
from
    employees
;


select
    employee_id as 사번
    , last_name as 이름
    , job_id as 직업코드
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '사업부없음'
      end as "사업부"
from
    employees
order by 사업부, employee_id
;

select
    employee_id as 사번
    , hire_date as 입사일
    , nvl(commission_pct,0) as 기존커미션
    , case
        when sysdate - hire_date < 8000 then
            nvl(commission_pct,0) + 1
        when sysdate - hire_date < 10000 then
            nvl(commission_pct,0) + 2
        else
            nvl(commission_pct,0) + 3
      end as "상승된커미션"  
    , salary as 기존임금
    , case
        when months_between(sysdate, hire_date) < 250 then
            salary + 1000
        when months_between(sysdate, hire_date) < 300 then
            salary + 2000
        when months_between(sysdate, hire_date) < 350 then
            salary + 3000
        else
            salary + 5000
      end as 상승된임금
from
    employees
order by employee_id, hire_date
;

SELECT
    CASE 
        WHEN (department_id is null) THEN first_name || ' ' || last_name
        WHEN (manager_id is null) THEN to_char(hire_date, 'yyyy-mm-dd')
        WHEN (commission_pct is not null) THEN to_char(trunc(salary * (1 + commission_pct), -2), '99999')
        ELSE CASE
                    WHEN (first_name like '___') THEN to_char(round(sysdate - hire_date, 0) / 365, '99')
                    WHEN (job_id like 'IT%') THEN phone_number
                    ELSE CASE
                                WHEN (to_char(hire_date, 'yy') like '8%') THEN to_char(salary, '99999')
                                ELSE email
                            END
                END
    END "결과"
FROM
    employees
ORDER BY
    "결과" desc;