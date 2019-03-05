-- 사번 이름 부서번호 직원유형
-- 부서번호가 60-개발, 90-임원진, 나머지-비개발자
select
    employee_id
    , first_name
    , department_id
    , case
        when department_id = 60 then
            '개발'
        when department_id = 90 then
            '임원진'
        else
            '비개발자'
    end as "직원 유형"
from
    employees
order by "직원 유형"
;

-- decode(columnm, 비교값1, 결과값1, 비교값2, 결과값2,......., 예외결과)
-- decode 는 = 비교만 가능.
select
    employee_id
    , first_name
    , department_id
    , decode(department_id, 
        60, '개발자'
        ,90, '임원진'
        ,'비개발자' ) 직원유형
from
    employees
order by "직원 유형"
;

-- 그룹함수
-- 회사의 총사원수, 급여총합, 급여평균, 최고급여, 최저급여

select
    count(employee_id) as 직원수 -- 행의 개수를 구한다. 단일행
    , sum(salary) as 급여총합       -- 해당 column 의 총합을 구한다. 단일행
    , avg(salary) as 급여평균        -- 해당 column 의 평균을 구한다. 단일행
    , max(salary) as 최고급여       -- 해당 column 의 최대값을 구한다. 단일행
    , min(salary) as 최저급여        -- 해당 column 의 최저값을 구한다. 단일행
from
    employees
;

-- 평균급여보다 많이 받는 사원의 사번, 이름, 급여
-- 실행되는 순서를 생각해보면 알수 있다.
select
    employee_id
    , first_name
    , salary
from
    employees
where 
    salary > avg(salary)
    --salary > 8775
;

