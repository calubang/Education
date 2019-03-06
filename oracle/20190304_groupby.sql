-- UNION (�ߺ� ����)
-- �μ���ȣ�� 50�̰ų� 90�� �����
-- �޿��� 10000 �̻��� �����
-- ���, �̸�, �޿�, �μ���ȣ
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
    
-- UNION ALL (�ߺ� ���)
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
    
-- INTERSECT (������)
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


-- MINUS (ù��° ��� - �ι�° ���)
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
-- �׷��� �� ���� column�� �׷� �Լ��� ����� �� ����
-- �μ��� ����, ��� �޿�, ��� ��, �ִ� �޿�, �ּ� �޿�
SELECT
    department_id "�μ�",
    sum(salary) "����",
    avg(salary) "���",
    count(employee_id) "��� ��",
    max(salary) "�ִ�",
    min(salary) "�ּ�"
FROM
    employees
GROUP BY
    department_id;


-- �μ��� ����, ��� �޿�, ��� ��, �ִ� �޿�, �ּ� �޿�
-- �μ� �� ��� �޿��� 5000 ������ �μ�
-- �Ϲ� ������ WHERE, �׷� �� ������ HAVING
SELECT
    department_id "�μ�",
    sum(salary) "����",
    avg(salary) "���",
    count(employee_id) "��� ��",
    max(salary) "�ִ�",
    min(salary) "�ּ�"
FROM
    employees
GROUP BY
    department_id
HAVING
    avg(salary) <= 5000;


-- �� �μ��� ��� �޿����� ���� �޴� �����
-- ���, �̸�, �޿�
SELECT
    employee_id "���",
    first_name || ' ' || last_name "�̸�",
    salary "�޿�"
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

-- rownum : Row �� �ټ��� ǥ�����ش�.
-- rownum�� �ּҰ��� 1
-- rownum�� < �񱳴� �ּҰ��� 1���� �����͸� ��
-- rownum�� > �񱳴� �ִ밪�� ������ �� �� ���� ������ ���� �� ����.
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
    
-- ����, ���, �̸�, �޿�, �Ի���, �μ��̸�
-- �޿��� ����(��������)
-- �� �������� 5�� ���
-- 2page ���(6~10), &pageNum �� �̿��ؼ� 2�� �����ٰ� ����
-- 1980���, 1990���, 2000���

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
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 ���' 
                        when to_char(hire_date, 'yyyy') between '1990' and '1999' then
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 ���' 
                        when to_char(hire_date, 'yyyy') between '2000' and '2009' then
                            substr(to_char(hire_date, 'yyyy'), 1, 3) || '0 ���' 
                    end as hireDate_years
                    , emp.department_id
                from
                    employees emp
                where
                    to_char(hire_date, 'yyyy') between '1980' and '1989' -- 1980 ���
                    or to_char(hire_date, 'yyyy') between '1990' and '1999' -- 1990���
                    or to_char(hire_date, 'yyyy') between '2000' and '2009' -- 2000���
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
-- ����, ���, �̸�, �޿�, �Ի���, �μ��̸�
-- �޿��� ����(��������)
-- �� �������� 5�� ���
-- 2page ���(6~10), &pageNum �� �̿��ؼ� 2�� �����ٰ� ����
-- 1980���, 1990���, 2000���
select
    empSalaryRanking.ranking
    , empSalaryRanking.employee_id
    , empSalaryRanking.first_name
    , empSalaryRanking.salary
    --, empSalaryDesc.department_id
    , empSalaryRanking.department_name
    , decode(substr(to_char(empSalaryRanking.hire_date, 'yyyy'),1, 3)
                , '198', '1980 ���'
                , '199', '1990 ���'
                , '200', '2000 ���'
                , '�߸��� ��'
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
