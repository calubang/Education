-- non-equi join 
-- 모든 사원의 사번, 이름, 급여 급여등급
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , jobGrade.grade_level as 급여등급
    --, jobgrade.lowest_sal
    --, jobgrade.highest_sal
from
    employees emp
    , job_grades jobGrade
where
    emp.salary between jobGrade.lowest_sal and jobgrade.highest_sal
order by emp.employee_id
;

-- outter join
-- 모든 사원의 사번, 이름, 부서번호, 부서이름
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.department_id as 부서번호
    , nvl(dep.department_name, '대기발령중') as 부서명
from
    employees emp
    , departments dep
where
    emp.department_id = dep.department_id(+)
order by emp.employee_id
;

-- 모든 사원의 사번, 이름, 상관사번, 상관이름
-- 단 상관이 없을 경우 상관이름에 '사장' 으로 출력
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.manager_id as 상관사번
    --, mgr.employee_id
    , nvl(mgr.first_name, '사장') as 상관이름
from
    employees emp
    , employees mgr
--        on emp.manager_id = mgr.employee_id
where
    emp.manager_id = mgr.employee_id(+)
order by emp.employee_id
;

-- 모든 사원의 사번, 이름, 상관사번, 상관이름, 부서이름
-- 단 상관이 없을 경우 상관이름에 사장으로 출력
-- 단 부서가 미지정일 경우 부서이름을 대기발령중으로 출력
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    --, emp.manager_id as 상관사번
    , nvl(mgr.first_name, '사장') as 상관이름
    --, emp.department_id as 부서코드
    , nvl(dep.department_name, '대기발령') as 부서명
from
    employees emp
    , employees mgr
    , departments dep
where
    emp.manager_id = mgr.employee_id(+)
    and emp.department_id = dep.department_id(+)
order by emp.employee_id
;

-- ANSI JOIN (표준 SQL) 
-- cross join
select
    *
from
    employees
    cross join departments
;

-- equi join = inner join
-- join 조건을 on 으로 따로 명시함.
-- inner join 을 빼도 default 는 inner join이다.
-- join조건이 아닌 조건들은 기존과 같이 where 절에 추가한다.
select
    *
from 
    employees emp 
    inner join departments dep
        on emp.department_id = dep.department_id
    inner join job_history jh
        on emp.employee_id = jh.employee_id
where
    emp.department_id = 50
;


-- inner join 의 on절은 using 통해서도 가능
-- 대신 using을 사용한 column 은 어디 table 값인지 명시할수 없다. where 에서도...
select
    *
from 
    employees emp 
    inner join departments dep
        using(department_id)
where
    department_id = 50
;

-- natural join 은 두 테이블에서 동일한 column을 기준으로 join 한다.
-- 위험한 join 방식
select
    *
from 
    employees emp 
    natural join departments dep
where
    department_id = 50
;

-- outer join
-- 모든 row를 출력하고 싶은 쪽으로 left right 가 결정됨.
-- left outer join , right outer join
select
    *
from 
    employees emp
    left outer join departments dep
        on emp.department_id = dep.department_id
;
-- outer join 은 full outer join 을 통해 양쪽의 모든 row 를 다 뽑아낼수 있다
-- oracle 에서는 안됨
select
    *
from 
    employees emp
    full outer join departments dep
        on emp.department_id = dep.department_id
;

-- 'seattle'에 근무하는 사번, 이름, 부서이름 도시
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , dep.department_name as 부서이름
    , loc.city as 도시이름
from
    employees emp 
    join departments dep
        on emp.department_id = dep.department_id
    join locations loc
        on dep.location_id = loc.location_id
where
    loc.city = 'Seattle'
;

-- 모든 사원의 사번, 이름, 부서번호, 부서이름
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.department_id as 부서번호
    , dep.department_name as 부서이름
from
    employees emp
    , departments dep
where
    emp.department_id = dep.department_id(+)
;

-- 모든 부서에 근무하는 사원의 사번, 이름, 부서번호, 부서이름
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.department_id 
    , dep.department_id as 부서번호
    , dep.department_name as 부서이름
from
    departments dep
    , employees emp
where
    dep.department_id = emp.department_id(+)
;

----------------------------------------------------------------------------------------------------------------------------------------------
-- 오늘의 문제
-- 한번도 직책이 변경된 적이 없는 사람의 사번과 이름 출력
select
    emp.employee_id as 사번
    , emp.first_name as 이름
from
    employees emp
    left outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    jobh.employee_id is null
order by emp.employee_id
;

-- 퇴직자사번, 퇴직일자 찾기
-- 직책이 변경된 이력은 있지만 현재 사원테이블에는 없는 사람을 퇴직한 사람이라 하고, 직책이 끝난날을 퇴직일이라 한다.
select
    jobh.employee_id as 사번
    , jobh.end_date as 퇴직일
from
    employees emp
    right outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    emp.employee_id is null
order by emp.employee_id
;

select
    nvl(to_char(emp.employee_id), '퇴사') as 사번
    , nvl(to_char(jobh.employee_id), '직책변경이력없음') as "변경이력"
    , emp.*
    , emp.employee_id
    , jobh.employee_id
    , jobh.*
    /*, case 
        when emp.employee_id is null then
            '퇴사'
        when jobh.employee_id is null then
            '퇴사'
        else
            '알수없음'
    end as "변경이력"*/
from
    employees emp
    full outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    emp.employee_id is null or jobh.employee_id is null
order by emp.employee_id
;
-- 10

-- 부서table 에 등록된 부서의 관리자 그리고 그 관리자가 관리하는 사원들의 정보를 출력하라.
-- (관리자가 관리하는 사원들은 employees 에 manager_id 로 확인된다)
-- 출력정보는 부서코드, 부서명, 관리자id, 관리자이름, 관리하는사원id, 관리하는사원이름 
select
    dep.department_id as 부서코드
    , dep.department_name as 부서명
    --, dep.manager_id as 매니저코드
    , mgr.first_name as 매니저이름
    --, emp.manager_id as 사원들의매니저id
    , nvl(to_char(emp.employee_id), '없음') as 사원id
    , nvl(emp.first_name, '없음') as 사원이름
    --, emp.*
from
    departments dep
    inner join employees mgr
        on dep.manager_id = mgr.employee_id
    left outer join employees emp
        on dep.manager_id = emp.manager_id
order by dep.department_id
;

select  *
from
    employees;
