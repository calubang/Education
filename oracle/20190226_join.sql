-- ���, �̸�, �μ���ȣ, �μ���
-- cross Join, catesian join
select
    *
from
    employees
    , departments
;


-- join �� �Ҷ��� 
-- �ּ� ���̺���n - 1 ���� ������ �ɵ��� �Ѵ�.
-- ���̺��� ���輺�� ���� join ������ ����
-- ������ department_id �� null �� ����� ����
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

-- seattle �� �ٹ��ϴ� ����� ���, �̸�, �μ��̸�, �����̸�
-- �ɼ� ������ ���ڿ��񱳴� upper, lower �����ϰ� �����ٰ�.
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , dep.department_name as �μ��̸�
    , loc.city as �����̸�
from
    employees emp
    , departments dep
    , locations loc
where 
    emp.department_id = dep.department_id
    and dep.location_id = loc.location_id
    and lower(loc.city) = lower('seattle')
;

-- asia �� �ٹ��ϴ� ��� �̸� �μ��̸� �����̸�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.department_id as �μ���ȣ
    , dep.department_name as �μ���
    , loc.city as �����̸�
    , loc.country_id as �����ڵ�
    , co.country_name as ������
    , co.region_id as �����ڵ�
    , reg.region_name as ������
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

-- 10 80 90�� �μ��� �ٹ����� �����
-- ��� �̸� ��å�̸�, �μ��̸�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , job.job_title as ��å�̸�
    , emp.department_id as �μ��ڵ�
    , dep.department_name as �μ��̸�
from
    employees emp
    , jobs job
    , departments dep
where
    emp.job_id = job.job_id
    and emp.department_id = dep.department_id
    and emp.department_id in (10, 80, 90)
;

-- ����� 200�� ����� �ٹ� �̷�
-- ���, �̸�, ��å�̸�, �μ��̸�, �ٹ� ������ (�Ҽ��� 2�ڸ������� ǥ��)
select
    jh.employee_id as ���
    , emp.first_name as �̸�
    , job.job_title as ��å�̸�
    , dep.department_name as �μ��̸�
    , to_char(months_between( jh.end_date, jh.start_date), '999.99') as �ٹ�������
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

-- ��� ����� �μ��̸�, ���, �̸�, �Ŵ������, �Ŵ����̸�
-- self join

select
    emp1.department_id as �μ���ȣ
    , dep.department_name as �μ��̸�
    , emp1.employee_id as ���
    , emp1.first_name as �̸�
    , emp1.manager_id as �Ŵ������
    , emp2.first_name as �Ŵ����̸�
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


-- ��å ���̵� 'sa_rep' �� �����
-- ��� �̸� ��å�̸�, �μ��̸�
-- �� �μ��� ���� ��� ���߷����� ���
select --distinct
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.job_id as ��å�ڵ�
    , job.job_title as ��å��
    , emp.department_id as �μ��ڵ�
    --, dep.department_name as �μ��̸�
    , case
        when emp.department_id is null then
            '���߷�'
        else
            dep.department_name
    end as �μ��̸�
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
-- 1. ��å�� ����� ���� �ִ� ������� ���, �̸�, ������å�ڵ�, ������å��, ������å�ڵ�, ������å���� ǥ��
-- (���ı����� ���)
select
    emp.employee_id as ���
    , emp.first_name as ��
    , emp.last_name as �̸�
    , jobh.job_id as ������å
    , preJob.job_title as ������å��
    , emp.job_id as ������å�ڵ�
    , nowJob.job_title as ������å��
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

-- �ѳ��ڸ� ã�ƶ�.
-- �� ���ڴ� 3000 ~ 4500 ������ �޿��� ���� �� �ִ� ��å�� ������ �ִ�.
-- �� ���ڰ� ���ϴ� �μ����� Administration �̴�.
-- �� ������ ���, �̸�, �޿�, �μ��� ǥ��
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , dep.department_name as �μ���
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

-- ������� grade_level �� ���Ͻÿ�.
-- ���, �̸�, �޿�, grade_level (������ ���)
select 
    emp.employee_id as ���
    --, emp.first_name as �̸�
    --, emp.salary as �޿�
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
