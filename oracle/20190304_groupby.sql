-- UNION (중복 제거)
-- 부서번호가 50이거나 90인 사원과
-- 급여가 10000 이상인 사원의
-- 사번, 이름, 급여, 부서번호
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id in (50, 90)


UNION


SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    salary >= 10000;
    
-- UNION ALL (중복 허용)
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id in (50, 90)


UNION ALL


SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    salary >= 10000;
    
-- INTERSECT (교집합)
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id in (50, 90)


INTERSECT


SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    salary >= 10000;


-- MINUS (첫번째 결과 - 두번째 결과)
-- A - B
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id in (50, 90)


MINUS


SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    salary >= 10000;


-- B - A
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    salary >= 10000
    
MINUS
    
SELECT
    employee_id,
    first_name || ' ' || last_name,
    salary,
    department_id
FROM
    employees
WHERE
    department_id in (50, 90);


-- GROUP BY
-- 그룹을 한 기준 column과 그룹 함수는 사용할 수 있음
-- 부서별 총합, 평균 급여, 사원 수, 최대 급여, 최소 급여
SELECT
    department_id "부서",
    sum(salary) "총합",
    avg(salary) "평균",
    count(employee_id) "사원 수",
    max(salary) "최대",
    min(salary) "최소"
FROM
    employees
GROUP BY
    department_id;


-- 부서별 총합, 평균 급여, 사원 수, 최대 급여, 최소 급여
-- 부서 별 평균 급여가 5000 이하인 부서
-- 일반 조건은 WHERE, 그룹 별 조건은 HAVING
SELECT
    department_id "부서",
    sum(salary) "총합",
    avg(salary) "평균",
    count(employee_id) "사원 수",
    max(salary) "최대",
    min(salary) "최소"
FROM
    employees
GROUP BY
    department_id
HAVING
    avg(salary) <= 5000;


-- 각 부서의 평균 급여보다 많이 받는 사원의
-- 사번, 이름, 급여
SELECT
    employee_id "사번",
    first_name || ' ' || last_name "이름",
    salary "급여"
FROM
    employees
WHERE
    salary > all (SELECT
                    avg(salary)
                FROM
                    employees
                GROUP BY
                    department_id);

select
    dept.department_name
    , emp.employee_id
    , emp.first_name
    , emp.salary
from
    employees emp
    , departments dept
    , (
        select
            max(empDept.salary) as deptMaxSalary
            , empDept.department_id as department_id
        from
            employees empDept
        group by empDept.department_id
    ) deptMaxSalary
where
    emp.department_id = dept.department_id(+)
    and nvl(emp.department_id, -1) = nvl(deptMaxSalary.department_id, -1)
    and emp.salary = deptMaxSalary.deptMaxSalary
;

-- rownum : Row 의 줄수를 표시해준다.
-- rownum의 최소값은 1
-- rownum의 < 비교는 최소값인 1부터 데이터를 비교
-- rownum의 > 비교는 최대값이 얼마인지 알 수 없기 때문에 비교할 수 없다.
select
    *
from
    (
        select 
            rownum as count
            , emp.employee_id
            , salary
        from
            employees emp
        where
            rownum < 10
    ) empRownum
where
    empRownum.count >= 5
 ;
    
-- 순위, 사번, 이름, 급여, 입사년대, 부서이름
-- 급여순 순위(내림차순)
-- 한 페이지당 5명씩 출력
-- 2page 출력(6~10), &pageNum 을 이용해서 2를 누른다고 가정
-- 1980년대, 1990년대, 2000년대

select
    *
from
    (
        select
            rownum as ranking
            , empSalaryDesc.employee_id
            , empSalaryDesc.first_name
            , empSalaryDesc.salary
            , empSalaryDesc.hireDate_years
            --, empSalaryDesc.department_id
            , dept.department_name
        from
            (
                select
                    emp.employee_id 
                    , emp.first_name
                    , emp.salary 
                    , emp.hire_date
                    , case
                        when to_char(hire_date, 'yyyy') between '1980' and '1989' then
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 년대' 
                        when to_char(hire_date, 'yyyy') between '1990' and '1999' then
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 년대' 
                        when to_char(hire_date, 'yyyy') between '2000' and '2009' then
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 년대' 
                    end as hireDate_years
                    , emp.department_id
                from
                    employees emp
                where
                    to_char(hire_date, 'yyyy') between '1980' and '1989' -- 1980 년대
                    or to_char(hire_date, 'yyyy') between '1990' and '1999' -- 1990년대
                    or to_char(hire_date, 'yyyy') between '2000' and '2009' -- 2000년대
                order by salary desc
            ) empSalaryDesc
            , departments dept
        where
            empSalaryDesc.department_id = dept.department_id(+)
    ) empSalaryRanking
where
    empsalaryranking.ranking between ((5 * (&pageNum - 1)) + 1) and 5 * (&pageNum)
;

--------------------------------------------------------------------------------
-- 순위, 사번, 이름, 급여, 입사년대, 부서이름
-- 급여순 순위(내림차순)
-- 한 페이지당 5명씩 출력
-- 2page 출력(6~10), &pageNum 을 이용해서 2를 누른다고 가정
-- 1980년대, 1990년대, 2000년대
select
    empSalaryRanking.ranking
    , empSalaryRanking.employee_id
    , empSalaryRanking.first_name
    , empSalaryRanking.salary
    --, empSalaryDesc.department_id
    , empSalaryRanking.department_name
    , decode(substr(to_char(empSalaryRanking.hire_date, 'yyyy'),1, 3)
                , '198', '1980 년대'
                , '199', '1990 년대'
                , '200', '2000 년대'
                , '잘못된 값'
    ) as hireDate_years
from
    (
    select
        rownum as ranking
        , empSalaryDesc.*
    from
        (
        select
            emp.employee_id 
            , emp.first_name
            , emp.salary 
            , emp.hire_date
            , emp.department_id
            , dep.department_name
        from
            employees emp
            , departments dep
        where
            emp.department_id = dep.department_id(+)
            --and substr(to_char(hire_date, 'yyyy'),1, 3) in ('198', '199', '200')
        order by salary desc
        ) empSalaryDesc
    ) empSalaryRanking
where
    empsalaryranking.ranking between ((5 * (&pageNum - 1)) + 1) and (5 * (&pageNum))
;

-- rank over()
select 
    *
from
    (
    select
        employee_id
        , first_name
        , salary
        , rank() over (order by salary desc) as salaryRank
    from
        employees
    )
where
    salaryRank between 1 and 5
order by salaryRank
;
