-- non-equi join 
-- ��� ����� ���, �̸�, �޿� �޿����
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , jobGrade.grade_level as �޿����
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
-- ��� ����� ���, �̸�, �μ���ȣ, �μ��̸�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.department_id as �μ���ȣ
    , nvl(dep.department_name, '���߷���') as �μ���
from
    employees emp
    , departments dep
where
    emp.department_id = dep.department_id(+)
order by emp.employee_id
;

-- ��� ����� ���, �̸�, ������, ����̸�
-- �� ����� ���� ��� ����̸��� '����' ���� ���
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.manager_id as ������
    --, mgr.employee_id
    , nvl(mgr.first_name, '����') as ����̸�
from
    employees emp
    , employees mgr
--        on emp.manager_id = mgr.employee_id
where
    emp.manager_id = mgr.employee_id(+)
order by emp.employee_id
;

-- ��� ����� ���, �̸�, ������, ����̸�, �μ��̸�
-- �� ����� ���� ��� ����̸��� �������� ���
-- �� �μ��� �������� ��� �μ��̸��� ���߷������� ���
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    --, emp.manager_id as ������
    , nvl(mgr.first_name, '����') as ����̸�
    --, emp.department_id as �μ��ڵ�
    , nvl(dep.department_name, '���߷�') as �μ���
from
    employees emp
    , employees mgr
    , departments dep
where
    emp.manager_id = mgr.employee_id(+)
    and emp.department_id = dep.department_id(+)
order by emp.employee_id
;

-- ANSI JOIN (ǥ�� SQL) 
-- cross join
select
    *
from
    employees
    cross join departments
;

-- equi join = inner join
-- join ������ on ���� ���� �����.
-- inner join �� ���� default �� inner join�̴�.
-- join������ �ƴ� ���ǵ��� ������ ���� where ���� �߰��Ѵ�.
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


-- inner join �� on���� using ���ؼ��� ����
-- ��� using�� ����� column �� ��� table ������ ����Ҽ� ����. where ������...
select
    *
from 
    employees emp 
    inner join departments dep
        using(department_id)
where
    department_id = 50
;

-- natural join �� �� ���̺��� ������ column�� �������� join �Ѵ�.
-- ������ join ���
select
    *
from 
    employees emp 
    natural join departments dep
where
    department_id = 50
;

-- outer join
-- ��� row�� ����ϰ� ���� ������ left right �� ������.
-- left outer join , right outer join
select
    *
from 
    employees emp
    left outer join departments dep
        on emp.department_id = dep.department_id
;
-- outer join �� full outer join �� ���� ������ ��� row �� �� �̾Ƴ��� �ִ�
-- oracle ������ �ȵ�
select
    *
from 
    employees emp
    full outer join departments dep
        on emp.department_id = dep.department_id
;

-- 'seattle'�� �ٹ��ϴ� ���, �̸�, �μ��̸� ����
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , dep.department_name as �μ��̸�
    , loc.city as �����̸�
from
    employees emp 
    join departments dep
        on emp.department_id = dep.department_id
    join locations loc
        on dep.location_id = loc.location_id
where
    loc.city = 'Seattle'
;

-- ��� ����� ���, �̸�, �μ���ȣ, �μ��̸�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.department_id as �μ���ȣ
    , dep.department_name as �μ��̸�
from
    employees emp
    , departments dep
where
    emp.department_id = dep.department_id(+)
;

-- ��� �μ��� �ٹ��ϴ� ����� ���, �̸�, �μ���ȣ, �μ��̸�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.department_id 
    , dep.department_id as �μ���ȣ
    , dep.department_name as �μ��̸�
from
    departments dep
    , employees emp
where
    dep.department_id = emp.department_id(+)
;

----------------------------------------------------------------------------------------------------------------------------------------------
-- ������ ����
-- �ѹ��� ��å�� ����� ���� ���� ����� ����� �̸� ���
select
    emp.employee_id as ���
    , emp.first_name as �̸�
from
    employees emp
    left outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    jobh.employee_id is null
order by emp.employee_id
;

-- �����ڻ��, �������� ã��
-- ��å�� ����� �̷��� ������ ���� ������̺��� ���� ����� ������ ����̶� �ϰ�, ��å�� �������� �������̶� �Ѵ�.
select
    jobh.employee_id as ���
    , jobh.end_date as ������
from
    employees emp
    right outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    emp.employee_id is null
order by emp.employee_id
;

select
    nvl(to_char(emp.employee_id), '���') as ���
    , nvl(to_char(jobh.employee_id), '��å�����̷¾���') as "�����̷�"
    , emp.*
    , emp.employee_id
    , jobh.employee_id
    , jobh.*
    /*, case 
        when emp.employee_id is null then
            '���'
        when jobh.employee_id is null then
            '���'
        else
            '�˼�����'
    end as "�����̷�"*/
from
    employees emp
    full outer join job_history jobh
        on emp.employee_id = jobh.employee_id
where
    emp.employee_id is null or jobh.employee_id is null
order by emp.employee_id
;
-- 10

-- �μ�table �� ��ϵ� �μ��� ������ �׸��� �� �����ڰ� �����ϴ� ������� ������ ����϶�.
-- (�����ڰ� �����ϴ� ������� employees �� manager_id �� Ȯ�εȴ�)
-- ��������� �μ��ڵ�, �μ���, ������id, �������̸�, �����ϴ»��id, �����ϴ»���̸� 
select
    dep.department_id as �μ��ڵ�
    , dep.department_name as �μ���
    --, dep.manager_id as �Ŵ����ڵ�
    , mgr.first_name as �Ŵ����̸�
    --, emp.manager_id as ������ǸŴ���id
    , nvl(to_char(emp.employee_id), '����') as ���id
    , nvl(emp.first_name, '����') as ����̸�
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
