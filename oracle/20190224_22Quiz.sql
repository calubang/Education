--1. 오늘을 기준으로 근로자의 근속년수를 나타내고 25년이하의 사람중에 직업등급레벨이 D인사람을을 나타내시오. 
--   (사번, 이름, 고용일, 근속년수)
--   (단, 월일은 신경쓰지않는다.귀찮으니깐 ㅎ)

select 
    employee_id,
    first_name,
    hire_date,
    sysdate,
    to_char(sysdate,'yyyy'),
    to_char(hire_date,'yyyy'),
    to_char(sysdate,'yyyy') - to_char(hire_date,'yyyy') as hire,
    department_id,
    salary
from
    employees
where 
    to_char(sysdate,'yyyy') - to_char(hire_date,'yyyy') <= 25
    and salary between 10000 and 14999
;

select *
from job_grades;

--2. last_name에 a가 들어가는 사람의 사번, 풀네임, 급여를 급여가 높은 순서대로 나타내어라.
--   이름의 컬럼은 employee_name로 표시한다.
--   (단, a는 대소문자 포함한다.)

select 
    employee_id,
    last_name,
    salary
from
    employees
where 
    lower(last_name) like '%a%'
order by salary desc
;

--3. 매니저 번호가 100 이상 200 미만이고, 미국에 위치하고 있는 부서의 부서번호, 부서명

select 
    department_id,
    department_name
from
    departments
where
    manager_id between 100 and 199
    and location_id in (1400, 1500, 1700)
    ;

select *
from locations;

4. 우편번호에 9가 들어가는 지역에 위치한 부서에서 일하며, 급여가 7000 이상인 사원의 이름 (부서별 이름순으로 정렬)

select 
    --department_id,
    first_name
from
    employees
where
    department_id in ( 60, 50, 10, 90, 110, 190, 80)
    and salary >= 7000
order by
    department_id,
    first_name
    ;

select
    department_id
from
    departments
where
    location_id in ( 1400, 1500, 1700, 2500)
    ;
    
select
    location_id
from
    locations
where 
    postal_code like '%9%'
    ;


5. 급여가 3000이상이고 50번이상 부서에 근무하며 이름에 r이 들어가는 사원들의 사번과 이름, 급여를 검색하라

select
    employee_id,
    first_name,
    salary
from
    employees
where
    salary >= 3000
    and department_id >= 50
    and lower(first_name) like '%r%'
;

6. 직업아이디가 AD로 시작하는 것을 검색하고 최고급여부터 내림차순으로 급여를 정렬하라

7. 근무국가가 미국인 사원의 풀네임과 근무시작 날짜를 적어서 'OOO은 OOO부터 미국에서 일한다.' 로 출력하라. 
   별칭은 노동자 from USA로 저장(공백포함)

8. 성이나 이름에 h가 들어간 사원에 대한 정보를 모두 출력하되 급여와 고용일을 내림차순으로 정렬하여라.

---------------------------------------------------------------------------------------------------------------------

1. 이름이 bruce인 사람의 사번, 부서번호, 급여를 뽑아라. (구성이 대문자인지 소문자인지는 모른다.)


2. 이름이 Steven인 사람이 근무하는 도시이름을 구해라


3. 커미션을 받는 사람중 10000이 넘는 사람의 사번 이름 부서번호, 커미션을 포함한 급여를 찾아라


4. 근무부서가 null인 사람의 사번 이름 부서번호를 찾아라


5. 근무 부서가 Oxford인 지역번호 찾기 (대소문자 섞어서 찾기) (별칭: 지역 번호)


6. 근무자의 직업아이디 종류 출력하기 (중복없이) (별칭: 직업 아이디)
 

7. 직무별 최소급여와 최대 급여의 차이가 2배 미만으로 차이나는 직무아이디, 최소급여, 최대급여, 급여차이( 별칭 급여차이 )

select
    job_id,
    job_title,
    min_salary,
    max_salary,
    max_salary - min_salary as "급여차이"
from
    jobs
where
    (min_salary * 2) - max_salary > 0
;

8. 근무자의 직업아이디 종류 출력하기 (중복없이) (별칭: 직업 아이디) 사람의 풀네임(별칭 : 이름), 급여(별칭 : 급여) 


9. 커미션을 받는 사원의 사번 , 이름, 급여를 급여별 내림차순 정리를 하라.


10. 사번, 이름, 커미션을 포함한 급여를 내림차순 정리를 하라.(커미션을 포함한 급여의 별칭은 cms)

-------------------------------------------------------------------------------------------------------------------------
노정탁
--매니저가 없는 부서를 조건을 통해 찾으시오..
--최저월급과 최고월급의 차이가 3000이상 나는 grade_level을 찾으시오.
--4년이상 근무하고 퇴사한 사원의 번호과 JOB_ID 출력하시오.

select 
    *
from
    departments
where 
    ;

 
신지영
-- 1. 관리자 ID가 124번이며, 급여가 2500 이상 3500 미만인 사원의 (이름, 급여, 관리자 ID)를 출력하세요.
-- 단, 급여가 높은 순으로 정렬
-- 2. 관리자 ID가 100이고 이름의 2번째가 'o'인 사원의 (이름, 커미션, 커미션 적용 후 급여)를 출력하세요.  *커미션이 null인 경우 0으로 대체하여 계산 및 출력
-- 단, 커미션 적용 후 급여가 높은 순으로 정렬
-- 3. 관리자가 지정되지 않은 사원의 (이름)을 출력하세요. *이름 형식 : [성 이름]
-- 4. 최대 급여와 최소 임금의 차가 5000 이상인 직급의 (이름, 최대 급여, 최소 급여, 급여의 차이)을 출력하세요.-- 단, 급여의 차이가 큰 순으로 정렬하세요.
-- 5. 현재 시간, 3일 후, 3시간 후, 3분 후, 3초 후를 출력하세요 *각각에 별칭 지정(현재 시간, 3일 후 ~)

select 
    to_char(sysdate, 'yy/mm/dd hh24:mi:') as 현재,
    sysdate + 3 as "3일후",
    sysdate + (3/24) * 3 
from dual;


-- 단, 출력 형식은 '년도.월.일 시:분:초'

김형섭
--90년 이전에 고용된 사원들의 최대 급여를 도출해주세요. 
--직책이 President 인 사원의 고용날짜, 이름 , 급여

박광규
1. 급여가 5000이상이고 매니저가 지정된 사람의 이름을 출력하시오
2. 최대 급여와 최소 급여가 4000 이하로 차이나는 job_title을 찾으시오
3. 매니저가 지정되지 않은 사람의 '이메일, 전화번호'의 형식으로 출력하시오

이종영
--1. 마케팅 부서가 위치한 지역의 우편번호를 찾으시오.
--2. it부서가 위치한 지역의 주소를 찾으시오.
--3. Steven King 직원의 직급이 벌수 있는 최고연봉을 찾으시오.

김의연

문제1.
-- 조건1. last_name 의 앞에서 두번째에 'u'가 들어간 사람의 커미션이 포함된 급여를 출력하시오.
-- 조건2. 커미션이 포함된 급여에 별칭 "급여"를 입력하시오.

문제2.
- 부서번호가 50이상, 이름이 아닌 성에서 끝에 두번째에 'o'가 들어간 사원의 전체 풀네임과 급여를 나타내시오. 
-- 별칭 : 이름 /  급여
-- 급여 오름차순으로 정렬 하시오.




