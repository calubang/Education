-- �˻���[query] (select)

-- �޿��� 5000�̻� �޴� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT
    employee_id     AS ���,
    first_name
    || ' '
    || last_name AS �̸�,
    salary          AS �޿�,
    department_id   AS �μ���ȣ
FROM
    employees
WHERE
    salary >= 5000;
-- ����� 100���� ����� ���, �̸�, �μ���ȣ

SELECT
    employee_id,
    first_name,
    department_id
FROM
    employees
WHERE
    employee_id = 100;
    
-- �ٹ����ð� seatle �� ������ ������ȣ, �����ȣ

SELECT
    *
FROM
    locations
WHERE
    lower(city) = lower('Seattle');
    
-- �޿��� 5000 �̻� �����鼭 10000 �̸��� �޴� ����� ��� �̸� �޿� �μ���ȣ

SELECT
    employee_id     AS ���,
    first_name      AS ��,
    last_name       AS �̸�,
    salary          AS �޿�,
    department_id   AS �μ���ȣ
FROM
    employees
WHERE
    salary >= 5000
    AND salary <= 12000;
    
-- �μ���ȣ�� 50�� ��� �� �޿��� 5000�̻� �޴� ����� ���, �̸�, �޿� �μ���ȣ

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

-- �޿��� 5000 �̻� �����鼭 12000 ���ϸ� �޴� ����� ��� �̸� �޿� �μ���ȣ

SELECT
    employee_id     AS ���,
    first_name      AS ��,
    last_name       AS �̸�,
    salary          AS �޿�,
    department_id   AS �μ���ȣ
FROM
    employees
WHERE
    salary between 5000 and 12000
    ;
    
-- Ŀ�̼��� �޴� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
-- null �� �˼����� �̱� ������ ���� �ٸ��� ���Ҽ��� ����.
-- null �� ���Ҷ����� is ��� �༮�� �̿��Ѵ�.
select 
    employee_id,
    first_name,
    salary,
    nvl(commission_pct,0) Ŀ�̼�,
    salary + (salary * nvl(commission_pct, 0)) as Ŀ�̼����Ա޿�
from 
    employees
where 
    --nvl(commission_pct, 0) != 0
    commission_pct is not null
    ;
    
-- �ٹ��μ��� 50, 60, 80 �� ����� ���, �̸�, �μ���ȣ

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

-- �ٹ��μ��� 50, 60, 80 �� �ƴ� ����� ���, �̸�, �μ���ȣ
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

-- �޿��� 3õ�̻��̰ų� 8õ�̻��̰ų� 5õ �̻��� ����� ���, �̸�, �޿�
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

-- in �� any�� ������
-- in �� ���������� ���� �� 
-- any �� ��񱳰� ����

select
    employee_id,
    first_name,
    salary
from 
    employees
where 
    salary >= any(3000, 5000, 8000)
;

-- �޿��� 3000�̻��̰� 8õ�̻��̰� 5õ �̻��� ����� ���, �̸�, �޿�
 
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

-- ����ð�, 3����, 3�ð� ��
select 
    sysdate, 
    to_char(sysdate, 'yy.mm.dd hh24:mi:ss'),
    to_char(sysdate + 3, 'yy.mm.dd hh24:mi:ss') "3����",
    to_char(sysdate + 3/24, 'yy.mm.dd hh24:mi:ss') "3�ð���"
from 
    dual
    ;

-- �̸��� steven �� ����� ����� �̸�
select
    *
from 
    employees
where 
    lower(first_name) = 'steven'
    ;

-- �̸��� 's' �� �����ϴ� ����� ����� �̸�
select
    *
from
    employees
where 
    lower(first_name) like lower('s%')
    ;

-- �̸��� 'e' �� �����ϰ� �ִ�
select
    *
from 
    employees
where 
    lower(first_name) like lower('%e%')
;

-- �̸��� 'y'�� ������ ���
select
    *
from 
    employees
where 
    lower(first_name) like lower('%y')
;
-- �̸����� ������ �ι�°�� 'e'�� ����� ���, �̸�
select
    *
from
    employees
where
    first_name like '%e_'
    ;

-- �μ���ȣ�� 50�� �ƴ� ����� 
select
    *
from
    employees
where 
    department_id ^= '50'
    ;


-- ��� ����� ���, �̸�, �޿�
-- �� �޿��� ����
-- ���ڷ� �ϸ� select ���� ������ column�� ���缭 ���´�.
-- column ���� ���� ����ϴ°��� �� ����
-- asc ��������, desc ��������
-- default �� asc ��������
select 
    employee_id as ���,
    first_name,
    salary
from
    employees
order by salary desc
;

-- �μ���ȣ ��� �̸� �޿�
-- �μ��� �޿������� ����
-- ��Ī���ε� ������ �� �ִ�.
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

-- �ٹ����ð� 'seattle' �� ����� ���, �̸�, �μ���ȣ

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






--����1. �Ի����� 91/01/02 �� 98/12/21 ������ ����� ������ ���.(�����ȣ, Ǯ����, �Ի���, �޿�(Ŀ�̼��� �ִٸ� �����Ұ�), Ŀ�̼�(������ 0���� ǥ��) ���� ����Ұ�)
select 
    employee_id as �����ȣ,
    first_name || ' ' || last_name as Ǯ����,
    hire_date as �Ի���,
    salary + salary * nvl(commission_pct, 0) as �޿�,
    nvl(commission_pct, 0) as Ŀ�̼�
from
    employees
where 
    hire_date between '91/01/02' and '98/12/21'
    ;

-- ����2. employees���� ȸ��(president)�� ����� �˾Ƴ��� ������ ���������� ä����������.
-- ��� : 100
-- Ǯ���� : Steven King
-- �Ի��� : 87/06/17
-- Ŀ�̼����Ե� �޿� : 24000
-- �ҼӺμ��� : Executive
-- �μ��� ���� �ּ�(�ڼ���) : US Washington Seattle 2004 Charade Rd, 98199

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


-- �μ��� ShiPping �� ���ϸ鼭 �޿���  2000 ~ 4000 ���̸鼭 firstName�� ������ t �� ���� ����̸鼭 �Ի����� 97/01/01~98/12/30 �� ���Ե��� �ʴ� ����� ����� Ǯ������?
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


-- ������ ����
-- 1. 7000~9000 ������ �޿��� ���� �� �ִ� ���� �̸� �߿��� 'Manager'�� �����ϴ� ���� �̸�, �ּ� �޿�, �ִ� �޿� (�ּ� �޿��� ������������ ����)
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
    
    
-- 2. ������ ��ȣ�� �ο����� ���� �μ��� �μ���ȣ
-- ���� : 190
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
-- ���ڸ� �μ� ��ȣ�� ���� ����� �޿� (�޿��� ���� ������� ����)
select 
    *
from
    employees
where 
    department_id like '___'
order by salary
    ;


-- 4. 1990�� ���Ŀ� ���� ����� �̸�, �̸���, ��� ���� (���� �Ի��� ������� ����)
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

-- 5. Ŀ�̼�, ���� ��ȣ, �μ� ��ȣ�� �ϳ��� �� �� ���� ����� �̸�, ��ȭ��ȣ (��ȭ��ȣ�� ��������)

select
    first_name || ' ' || last_name as �̸�,
    phone_number as ��ȭ��ȣ
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

-- any ���߿� �ϳ�(or)�̰� all �� �̰͵� ���(and) �� �����ϴ� �����̴�.


