-- 서브쿼리
-- 부서이름이 it에 근무하는 사원의 사번 이름 급여
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
from
    departments dep
    , employees emp
where
    dep.department_id = emp.department_id
    and dep.department_name = 'IT'
;

select
    *
from
    employees
where
    department_id = ( 
                            select 
                                department_id 
                            from 
                                departments 
                            where 
                                departments.department_name = 'IT'
                            )
;

-- 'seattle' 에 근무하는 사원의 사번 이름 급여
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , emp.department_id
    , dep.department_name 
    , dep.location_id
    , loc.city
from
    employees emp
    , departments dep
    , locations loc
where
    emp.department_id = dep.department_id
    and dep.location_id = loc.location_id
    and lower(loc.city) = lower('seattle')
;

select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , emp.department_id
    --, dep.department_name 
    --, dep.location_id
    --, loc.city
from
    employees emp
where
    emp.department_id in ( 
                                    select
                                        department_id
                                    from
                                        departments dep
                                    where
                                        dep.location_id in ( 
                                                                    select
                                                                        loc.location_id
                                                                    from
                                                                        locations loc
                                                                    where
                                                                        lower(loc.city) = lower('seattle')
                                                                )
                                 )
;


-- 지역번호가 1700 인 부서에서 일하는 
-- 사원의 사번 이름 부서번호 부서이름
-- 인라인 view ( from 절에 subquery 를 넣음으로써 임시적으로 만들어진 table)
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , dep.department_id as 부서번호
    , dep.department_name as 부서이름
from
    employees emp
    , (
        select
            *
        from
            departments 
        where
            location_id = 1700
    ) dep
where
    emp.department_id = dep.department_id
;

select
    *
from
    departments 
where
    location_id = 1700
;

-- kevin 보다 급여를 많이 받는 사원의 사번, 이름, 급여

select
    *
from
    employees emp
    , ( 
        select
            salary
        from
            employees
        where
            lower(first_name) = lower('kevin')
    ) kevinSalary
where
    emp.salary > kevinSalary.salary
;

-- 50번 부서에 있는 사원들보다 급여를 많이 받는 사원의 사번 이름 급여
-- all 을 써서 처리하는것이 맞다
select
    *
from
    employees emp
where
    salary > all (
                        select
                            salary
                        from
                            employees dept50_employee
                        where
                            dept50_employee.department_id = 50
                    )
;
-- 부서별에 근무하는 사원들의 평균 급여보다 많이 받는 사원의 사번 이름 급여
select
    *
from
    employees emp
where
    emp.salary > (
                        select
                            avg(deptEmp.salary)
                        from
                            employees deptEmp
                        where
                            deptEmp.department_id  = emp.department_id
                        )
;

select
    *
from
    employees emp
where
    emp.salary > (
                        select
                            avg(deptEmp.salary)
                        from
                            employees deptEmp
                        where
                            deptemp.department_id is not null
                        )
;

select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , emp.department_id as 부서번호
    , emp.*
from
    employees emp
    , (
        select distinct
            manager_id as mgrEmployee_id
        from
            employees 
    ) mgrEmp
    , (
        select
            avg(salary) as avgSalary
        from
            employees
        where
            department_id = 20
    ) avgSalary
where
    emp.employee_id = mgrEmp.mgrEmployee_id
    and emp.department_id != 20
    and emp.salary > avgSalary.avgSalary
;
-- 부서번호가 20번인 부서의 평균급여보다 크고, 
-- 부서장인 사람이면서 부서번호가 20이 아닌 사원의 사번 이름 급여 부서번호
select
    *
from
    employees emp
    , departments dep
where
    emp.employee_id = dep.manager_id
    and emp.department_id != 20
    and emp.salary > (
                                select
                                    avg(salary)
                                from
                                    employees
                                where
                                    department_id = 20
                            )
;





select
    *
from
    employees emp
    , (
        select
            avg(salary) as avgSalary
        from
            employees dept20_employee
        where
            dept20_employee.department_id = 20
    ) dept20_avgSalary
where
    emp.salary > dept20_avgsalary.avgsalary
    and emp.manager_id is not null
    and emp.department_id != 20
;

select
    *
from
    employees emp
    join departments dep
        on emp.department_id  = dep.department_id
;

-- 20번 부서의 평균급여
-- 50번 부서의 급여총합
-- 80번 부서의 인원수
-- 단일값(단일행, 단일컬럼)만이 가능하다.
select
    (
        select
            avg(salary)
        from
            employees
        where
            department_id = 20
    ) avgSalary
    , (
        select
            sum(salary)
        from
            employees
        where
            department_id = 50
    ) sumSalary
    , (
        select
            count(employee_id)
        from
            employees
        where
            department_id = 80
    ) countEmp
    , emp.*
from 
    employees emp
;

-- 모든 사원의 사번, 이름, 급여, 등급, 부서이름
-- 단, A는 1등급, B는 2등급....
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , nvl(dep.department_name, '부서없음')as 부서이름
    , decode(jg.grade_level, 'A', '1등급', 'B', '2등급', 'C', '3등급', 'D', '4등급', 'E', '5등급', 'F', '6등급', '등급없음') as 급여등급
from
    employees emp
    left outer join departments dep
        on emp.department_id = dep.department_id
    inner join job_grades jg
        on emp.salary between jg.lowest_sal and jg.highest_sal
order by
    emp.employee_id
;

select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , nvl(dep.department_name, '부서없음') as 부서명
    /*, case
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'A' then
            '1등급'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'B' then
            '2등급'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'C' then
            '3등급'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'D' then
            '4등급'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'E' then
            '5등급'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'F' then
            '6등급'
        ELSE 
            'NULL'
    end "등급"
    */
    , decode( (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal)
        , 'A', '1등급'
        , 'B', '2등급'
        , 'C', '3등급'
        , 'D', '4등급'
        , 'E', '5등급'
        , '6등급'
    ) as "등급"
from
    employees emp
    left outer join departments dep
        on emp.department_id = dep.department_id
;


------------------------------------------------------------------------------------------
-- 문제.. 각 부서에서 최고급여를 받는 사람의 사번, 이름, 봉급
select
    *
from
    employees emp
where
    emp.salary = (
                        select
                            max(salary)
                        from
                            employees deptEmp
                        where
                            nvl(emp.department_id, 0) = nvl(deptEmp.department_id, 0)
                        )
;

-- 다음 사람들의 정보를 출력해라
-- 사원table에 manage_id 로 등록된 사원들의 사번 이름 급여 를 출력
-- 사번, 이름, 부서명
select
    *
from
    employees emp
    , (
        select distinct
            manager_id
        from
            employees
    ) mgrId
where
    emp.employee_id = mgrid.manager_id
;

-- 직책이 바뀐 적이 있던 사원(job_history)의 사번, 이름, 급여, 그 사원이 속한 부서에서 최고급여
select
    emp.employee_id as 사번
    , emp.first_name as 이름
    , emp.salary as 급여
    , (
        select 
            max(salary)
        from
            employees depEmp
        where
            emp.department_id = depEmp.department_id
    ) as 부서내최고급여
from
    employees emp
where
    emp.employee_id in (
                                    select
                                        jh.employee_id
                                    from
                                        job_history jh
                                )
;