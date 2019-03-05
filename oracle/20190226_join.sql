-- 사번, 이름, 부서번호, 부서명
-- cross Join, catesian join
select
    *
from
    employees
    , departments
;


-- join 을 할때는 
-- 최소 테이블갯수n - 1 개의 조건을 걸도록 한다.
-- 테이블간의 관계성을 통해 join 조건을 결정
-- 문제는 department_id 가 null 인 사람이 문제
-- equi join (natural join)
select
    e.employee_id
    , e.first_name
    , e.department_id
    , d.department_name
from
    employees e, departments d
where 
    e.department_id = d.department_id
order by e.employee_id
;

-- seattle 에 근무하는 사원의 사번, 이름, 부서이름, 도시이름
-- 될수 있으면 문자열비교는 upper, lower 동일하게 맞춰줄것.
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , dep.department_name as 부서이름
    , loc.city as 도시이름
from
    employees emp
    , departments dep
    , locations loc
where 
    emp.department_id = dep.department_id
    and dep.location_id = loc.location_id
    and lower(loc.city) = lower('seattle')
;

-- asia 에 근무하는 사원 이름 부서이름 도시이름
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.department_id as 부서번호
    , dep.department_name as 부서명
    , loc.city as 도시이름
    , loc.country_id as 국가코드
    , co.country_name as 국가명
    , co.region_id as 지역코드
    , reg.region_name as 지역명
from
    employees emp
    , departments dep
    , locations loc
    , countries co
    , regions reg
where
    emp.department_id = dep.department_id
    and dep.location_id = loc.location_id
    and loc.country_id = co.country_id
    and co.region_id = reg.region_id
    and lower(reg.region_name) = lower('europe')
;

-- 10 80 90번 부서에 근무중인 사원의
-- 사번 이름 직책이름, 부서이름
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , job.job_title as 직책이름
    , emp.department_id as 부서코드
    , dep.department_name as 부서이름
from
    employees emp
    , jobs job
    , departments dep
where
    emp.job_id = job.job_id
    and emp.department_id = dep.department_id
    and emp.department_id in (10, 80, 90)
;

-- 사번이 200인 사원의 근무 이력
-- 사번, 이름, 직책이름, 부서이름, 근무 개월수 (소수점 2자리까지만 표현)
select
    jh.employee_id as 사번
    , emp.first_name as 이름
    , job.job_title as 직책이름
    , dep.department_name as 부서이름
    , to_char(months_between( jh.end_date, jh.start_date), '999.99') as 근무개월수
    --*
    --, jh.*
from
    job_history jh
    , departments dep
    , employees emp
    , jobs job
where 
    jh.department_id = dep.department_id
    and jh.employee_id = emp.employee_id
    and jh.job_id = job.job_id
    and jh.employee_id = 200
;

-- 모든 사원의 부서이름, 사번, 이름, 매니저사번, 매니저이름
-- self join

select
    emp1.department_id as 부서번호
    , dep.department_name as 부서이름
    , emp1.employee_id as 사번
    , emp1.first_name as 이름
    , emp1.manager_id as 매니저사번
    , emp2.first_name as 매니저이름
from
    employees emp1
    , departments dep
    , employees emp2
where
    emp1.department_id = dep.department_id
    and emp1.manager_id = emp2.employee_id
order by emp1.department_id, emp1.manager_id
;

select *
from employees;


-- 직책 아이디가 'sa_rep' 인 사원의
-- 사번 이름 직책이름, 부서이름
-- 단 부서가 없는 경우 대기발령으로 출력
select --distinct
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.job_id as 직책코드
    , job.job_title as 직책명
    , emp.department_id as 부서코드
    --, dep.department_name as 부서이름
    , case
        when emp.department_id is null then
            '대기발령'
        else
            dep.department_name
    end as 부서이름
from 
    employees emp
    , jobs job
    , departments dep
where 
    emp.job_id = job.job_id
    and nvl(emp.department_id, 80) = dep.department_id
    --and (emp.department_id = dep.department_id or emp.department_id is null)
    and lower(emp.job_id) = lower('sa_rep')
order by emp.employee_id    
;



----------------------------------------------------------------------------------------------------
-- 1. 직책이 변경된 적이 있는 사람들의 사번, 이름, 이전직책코드, 이전직책명, 현재직책코드, 현재직책명을 표시
-- (정렬기준은 사번)
select
    emp.employee_id as 사번
    , emp.first_name as 성
    , emp.last_name as 이름
    , jobh.job_id as 이전직책
    , preJob.job_title as 이전직책명
    , emp.job_id as 현재직책코드
    , nowJob.job_title as 현재직책명
    --, emp.*
from
    job_history jobh
    , employees emp
    , jobs preJob
    , jobs nowJob
where 
    jobh.employee_id = emp.employee_id
    and jobh.job_id = preJob.job_id 
    and emp.job_id = nowJob.job_id 
order by jobh.employee_id
;

-- 한남자를 찾아라.
-- 그 남자는 3000 ~ 4500 사이의 급여를 받을 수 있는 직책을 가지고 있다.
-- 그 남자가 일하는 부서명은 Administration 이다.
-- 그 남자의 사번, 이름, 급여, 부서명 표시
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , dep.department_name as 부서명
from
    jobs job
    , employees emp
    , departments dep
where
    job.min_salary <= 3000 and job.max_salary >= 4500
    and emp.job_id = job.job_id
    and emp.department_id = dep.department_id
    and lower(dep.department_name) = lower('Administration')
;

-- 사원들의 grade_level 를 구하시오.
-- 사번, 이름, 급여, grade_level (정렬은 사번)
select 
    emp.employee_id as 사번
    --, emp.first_name as 이름
    --, emp.salary as 급여
    --, jg.grade_level
    ,emp.*
    , jg.*
from
    employees emp
    , job_grades jg
where
    emp.salary between jg.lowest_sal and jg.highest_sal
order by emp.employee_id
;



select 
    *
from
    employees emp1
    , job_history jh
    --, employees emp2
where
    emp1.employee_id != jh.employee_id
order by emp1.employee_id
;

select 
    *
from
    job_history
;
