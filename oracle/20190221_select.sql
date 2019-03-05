--** [ ] �� ������ ������ ����

-- ��� ����� ��� ������ �ѷ���
SELECT
    *
FROM
    employees;

-- ����� ���, �̸�, �޿�

SELECT
    employee_id,
    first_name,
    salary
FROM
    employees;
   
-- �μ��� �μ���ȣ, �μ��̸�

SELECT
    department_id,
    department_name
FROM
    departments;

-- �μ���ȣ(employees ����)
-- [all / distinct ] �� ���� �ߺ������Ϳ� ���� ó���� ����
-- default �� all �� �ɷ��ִ�
-- select ���� �Ǿտ����� �����ϴ�.
-- distinct �� column ���� �Ŵ°��� �Ұ���.

-- ������ ���� ����

SELECT
    employee_id, distinct department_id
from    employees;

-- �������� ����
select distinct employee_id, department_id
from    employees;

-- ** ���� ** --
select [all | distinct] (* | col1, col2, col3....) FROM TABLE;

-----------------------------------------------------------------------
-- ��������
-- �Ϲ������� dual �̶�� �׽�Ʈ�� ���̺��� �̿��Ѵ�.
SELECT
    1 + 1
FROM
    dual;

-- ���, �̸�, �޿�, 200�λ� �޿�

SELECT
    employee_id,
    first_name,
    last_name,
    salary,
    salary + 200
FROM
    employees;


-- ���, �̸�, �޿�, Ŀ�̼����Ա޿�
select --*
    employee_id,
    first_name,
    last_name,
    salary,
    commission_pct,
    salary*(1+nvl(commission_pct,0)) as comit
from employees;

--** null �� �˼����� ��� �ǹ�
--** nvl(column, 0 ) -> column �� null �̸� 0���� ��ü

----------------------------------------------------------
select
    employee_id ���,
    first_name as ��,
    last_name as "�̸�",
    salary as "�޿�",
    nvl(commission_pct, 0) Ŀ�̼�,
    salary*(1+nvl(commission_pct,0)) as "Ŀ�̼� ���Ա޿�" -- ������ ������쿡�� "" �� ���
from 
    employees;

-----------------------------------------------------------

-- ���, �̸�(Ǯ����)
-- || �� ���ڿ� 2���� �ٿ��ִ� ���
-- ���ڵ����ʹ� ' ' �� ���Ѵ�
-- oracle db ���� " "�� ��Ī������ ����� �����ϴ�.
select 
    employee_id,
    first_name || ' ' || last_name as Ǯ����
from
    employees;
    

-- ����� 100�� ����� �̸��� steven King �Դϴ�. ���� �������� ���
select 
    '����� ' || employee_id || '�� ����� �̸��� ' || first_name || ' ' || last_name || ' �Դϴ�.' as info
from 
    employees;

----------------------------------------------------------------------------------------------------
-- ����1 employee ���̺��� �Ŵ������� id �� ���
select *
from
    employees;

select distinct
    employee_id,
    first_name || ' ' || last_name,
    manager_id
from
    employees;


-- location_id �� US Texas Southlake 2014 jabberwocky Rd, �����ȣ �Դϴ�.  �� ���� �������� select ���� ����ϼ���(alias�� "�ּ�" �Դϴ�.) 
select location_id || ' �� ' || country_id || ' ' || state_province || ' ' || street_address || ' , ' || postal_code || ' �Դϴ�.' as �ּ�
from
    locations;

-- ����ڵ�, �̸�(Ǯ����), Ŀ�̼��� ����� �޿�('�������޿�' �� ǥ��), �����Ŀ�̼� +3.5 �� �ö� �޿�('�����ı޿�' �� ǥ��) �� ����ϼ���.
-- Ŀ�̼��� null �ΰ��� 0���� ����մϴ�.
select 
    employee_id,
    first_name || ' ' || last_name,
    salary+salary*nvl(commission_pct,0) as �������޿�,
    salary+salary*(nvl(commission_pct,0 )+3.5) as �����ı޿�
from
    employees;
    
--�ǿ���
--* ����̸�(Ǯ����), �Ի���, �Ŵ�����ȣ (�Ŵ����� ���� ��� '-1' ���� ǥ��)
select 
    first_name || ' ' || last_name as Ǯ����
from
    employees;

--*  oo�� ����� oo�� �μ����� oo������ �����ϰ� �� ���ڴ� oo�� �Դϴ�. (��Ī "�������")

--�̼Ҵ�


--1. ������ xx�� ����� �̸� xxx �̸� �޿��� xxx �Դϴ�.
--2. ����  �̸�(Ǯ����) ��� �޿� Ŀ�̼�(0) Ŀ�̼��ձ޿�+2





