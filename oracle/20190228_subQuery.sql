-- ��������
-- �μ��̸��� it�� �ٹ��ϴ� ����� ��� �̸� �޿�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
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

-- 'seattle' �� �ٹ��ϴ� ����� ��� �̸� �޿�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
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
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
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


-- ������ȣ�� 1700 �� �μ����� ���ϴ� 
-- ����� ��� �̸� �μ���ȣ �μ��̸�
-- �ζ��� view ( from ���� subquery �� �������ν� �ӽ������� ������� table)
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , dep.department_id as �μ���ȣ
    , dep.department_name as �μ��̸�
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

-- kevin ���� �޿��� ���� �޴� ����� ���, �̸�, �޿�

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

-- 50�� �μ��� �ִ� ����麸�� �޿��� ���� �޴� ����� ��� �̸� �޿�
-- all �� �Ἥ ó���ϴ°��� �´�
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
-- �μ����� �ٹ��ϴ� ������� ��� �޿����� ���� �޴� ����� ��� �̸� �޿�
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
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , emp.department_id as �μ���ȣ
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
-- �μ���ȣ�� 20���� �μ��� ��ձ޿����� ũ��, 
-- �μ����� ����̸鼭 �μ���ȣ�� 20�� �ƴ� ����� ��� �̸� �޿� �μ���ȣ
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

-- 20�� �μ��� ��ձ޿�
-- 50�� �μ��� �޿�����
-- 80�� �μ��� �ο���
-- ���ϰ�(������, �����÷�)���� �����ϴ�.
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

-- ��� ����� ���, �̸�, �޿�, ���, �μ��̸�
-- ��, A�� 1���, B�� 2���....
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , nvl(dep.department_name, '�μ�����')as �μ��̸�
    , decode(jg.grade_level, 'A', '1���', 'B', '2���', 'C', '3���', 'D', '4���', 'E', '5���', 'F', '6���', '��޾���') as �޿����
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
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , nvl(dep.department_name, '�μ�����') as �μ���
    /*, case
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'A' then
            '1���'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'B' then
            '2���'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'C' then
            '3���'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'D' then
            '4���'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'E' then
            '5���'
        when (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal) = 'F' then
            '6���'
        ELSE 
            'NULL'
    end "���"
    */
    , decode( (select jg.grade_level from job_grades jg where emp.salary between jg.lowest_sal and jg.highest_sal)
        , 'A', '1���'
        , 'B', '2���'
        , 'C', '3���'
        , 'D', '4���'
        , 'E', '5���'
        , '6���'
    ) as "���"
from
    employees emp
    left outer join departments dep
        on emp.department_id = dep.department_id
;


------------------------------------------------------------------------------------------
-- ����.. �� �μ����� �ְ�޿��� �޴� ����� ���, �̸�, ����
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

-- ���� ������� ������ ����ض�
-- ���table�� manage_id �� ��ϵ� ������� ��� �̸� �޿� �� ���
-- ���, �̸�, �μ���
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

-- ��å�� �ٲ� ���� �ִ� ���(job_history)�� ���, �̸�, �޿�, �� ����� ���� �μ����� �ְ�޿�
select
    emp.employee_id as ���
    , emp.first_name as �̸�
    , emp.salary as �޿�
    , (
        select 
            max(salary)
        from
            employees depEmp
        where
            emp.department_id = depEmp.department_id
    ) as �μ����ְ�޿�
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