1. 모든사원의 사번, 직책,  급여, 최고급여, 최저급여를 구하시오 

select
    employee_id 
    , 
from
    employees
;


select e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.job_id = j.job_id;

2. US에 거주하는 사원의 사번 직책을 뽑으시오

select e.employee_id, e.job_id, c.country_id, d.department_id, l.city
from employees e, countries c, locations l, departments d
where upper(c.country_id) = upper('us')
and c.country_id = l.country_id
and d.department_id = e.department_id
and l.location_id = d.location_id;


3. 모든 사원의 부서이름, 사번, 이름, 매니저사번, 매니저이름 (case 문 사용)


select
    emp.*
from
    employees emp
;


select d.department_name, e.employee_id, e.first_name, d.manager_id, e.manager_id,
    case when e.manager_id = m.employee_id
        then m.first_name
        end "매니저이름"
from employees e, departments d, employees m
where e.department_id = d.department_id 
    and e.manager_id = m.employee_id
order by department_name;


4. 모든 직원의 사번, 이름, 부서이름, 직책이름, 부서장 (본인이 부서장일 경우 null 표시는 무시)

select e.employee_id, e.first_name, d.department_name, j.job_title, d.manager_id,
    case when d.manager_id = e.manager_id
         then m.first_name
         when e.manager_id = m.employee_id
         then e.first_name
        end "부서장"
from employees e, departments d, jobs j, employees m

where e.department_id = d.department_id
      and e.job_id = j.job_id
      and e.manager_id = m.employee_id;


5. 사번, 이름, 부서번호, 부서이름, 분류를 뽑아라.
--분류(decode이용)
--부서번호가 110이면 경영
--          60이면 개발
--          50이면 운송
--          그외 기타
 
답) select e.employee_id, e.first_name, e.department_id, d.department_name, 
        decode(d.department_id,
            110, '경영',
            60, '개발',
            50, '운송',
            '기타')
from employees e, departments d 
where e.department_id=d.department_id;

6. 직업 번호, 직업이름, 사번, 이름, 급여, 최대급여, 최소급여를 구해라

답)select e.job_id, j.job_title, e.employee_id, e.first_name, e.salary, j.max_salary, j.min_salary 
from employees e, jobs j
where j.job_id=e.job_id;