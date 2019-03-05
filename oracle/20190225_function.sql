-- round(a, b) �� �ݿø� 
-- b���� �������� �ݿø�
select 
    1234.5438,
    round(1234.5438, 1),
    round(1234.5438, 3),
    round(1234.5438, -3)
from
    dual
;

-- trunc(a, b) �� ���� 
-- b���� �������� ����
select 
    1234.5438,
    trunc(1234.5438, 1),
    trunc(1234.5438, 3),
    trunc(1234.5438, -3)
from
    dual
;

--floor(a) �� �Ҽ��� ������
select 
    1234.5438,
    floor(1234.5438),
from
    dual
;

-- mod(a, b) : a / b�� ����������
select
    5+3,
    5-3,
    5*3,
    5/3,
    mod(5, 3)
from 
    dual
    ;

-- abs(a) : a �� ���밪    
select
    abs(+3),
    abs(-3),
    abs(3)
from
    dual
;

-- ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿�
-- Ŀ�̼� ���� �޿��� 100�� �ڸ����� �ݿø�
select
    employee_id,
    first_name || ' ' || last_name as Ǯ����,
    salary,
    commission_pct,
    salary + round(salary*nvl(commission_pct, 0), -2) as "Ŀ�̼� ����"
from
    employees
;

-- kItRi 
-- lower �ҹ���
-- upper �빮��
-- initcap ù���ڸ� �빮��
select
    'kItRi',
    lower('kItRi'),
    upper('kItRi'),
    initcap('kItRi'),
    length('kItRi')
from dual
;

-- ���, Ǯ����
-- concat(a, b) a �� b ���ڿ��� ���Ķ�
select
    employee_id,
    first_name || ' ' || last_name as Ǯ����,
    concat(concat(first_name, ' ' ), last_name)
from
    employees
;

-- Oracle ������ index�� 1���� �����Ѵ�.
-- substr(a, b, [c]) : a�� ���ڿ�, b,c�� ����, c�� ��������(������ ���������´�)
-- a���� b��°���� c��ŭ�� ���ڿ��� ��ȯ
-- - �� ���� �����ʺ��� ����
-- ������ null
select 
    'hello oracle !!!',
    substr('hello oracle !!!', 2, 6),
    substr('hello oracle !!!', 2)
from dual;

-- instr(a, b, [c], [d]) : a,b �� ���ڿ� c �� ����, c,d�� ��������(������ ó�����Ͱ˻�, �����ǹ� ����)
-- a���� c��° ���ں��� b�� d��°�� ��Ÿ���� ������ġ
-- ������ 0
select 
    'hello oracle !!!',
    instr('hello oracle !!!', '��', 6)-1,
    instr('hello oracle !!!', '��')
from dual;

select
    '123-456' as zip,
    instr('123-456', '-'),
    substr('123-456', 1, instr('123-456', '-')-1) as zip1,
    substr('123-456', instr('123-456', '-')+1, 3) as zip2,
    substr('010-7163-3863', 1, instr('010-7163-3863', '-')-1) as phone1,
    substr('010-7163-3863', instr('010-7163-3863', '-')+1, instr('010-7163-3863', '-', 1, 2)-1 - instr('010-7163-3863', '-') ) as phone2,
    substr('010-7163-3863', instr('010-7163-3863', '-', 1, 2)+1) as phone3
    --instr('010-7163-3863', '-', instr('010-7163-3863', '-')+1)))
from dual
;

select
    '1234-56' as zip,
    instr('1234-56', '-'),
    substr('1234-56', 1, instr('1234-56', '-')-1) as zip1,
    substr('1234-56', instr('1234-56', '-')+1 ) as zip2
from dual
;

select
    employee_id,
    lpad(employee_id, 5, 'abc'),
    rpad(employee_id, 5, 'abc')
from 
    employees
;

-- ��¥���� 
select 
    sysdate,
    sysdate + 3,
    to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'),
    to_char(sysdate + 3 / 24, 'yyyy-mm-dd hh24:mi:ss')
from dual
;

-- months_between(A, B) : a, b������ ����������
select
    sysdate,
    sysdate + 70,
    months_between(sysdate, sysdate + 70)
from dual
;

-- next_day(a, b) : a���� ���� ����� b��
-- �Ͽ��Ϻ��� 1�� �ǹ�
select
    sysdate,
    next_day(sysdate, 1),
    next_day(sysdate, 3),
    next_day(sysdate, '��')
from dual
;

-- add_months(a, b) : a�� b��ŭ ������ ���� ��¥
-- last_day(a) : a�� ������ ��
select
    sysdate,
    add_months(sysdate, 2),
    to_char(last_day(sysdate), 'yyyy mm dd hh mi ss'),
    round(sysdate, 'day')
from
    dual
;

-- mm �������� ��(0x) mon �� JAN ��� , month �� january �� ���� Ǯ����
-- w �� �ش���� ������, ww �� �ش���� ������
-- d �� �ֿ��� ������(�Ͽ��Ͻ���)  dd �� ������ ������, ddd�� �⿡�� ������
-- dy ��  day ������ 
-- am(pm) hh ����(����) �ð�
-- hh �� 12������, hh24 �� 24�ð�����
-- mi �� 
-- ss ��
select
    sysdate
    ,to_char(sysdate, 'yyyy') as a
    --,to_char(sysdate, 'yyyy mm mon')
    --,to_char(sysdate, 'yyyy mm month')
    ,to_char(sysdate, 'yyyy mm mon d dd ddd')
from dual
;

select 
    to_char(sysdate, 'yyyy mm dd hh24:mi:ss') as "sysdate"
    , to_char(round(sysdate), 'yyyy mm dd hh24:mi:ss') as "to_char" 
    , to_char(round(sysdate, 'dd'), 'yyyy mm dd hh24:mi:ss') as dd 
    , to_char(round(sysdate, 'mm' ), 'yyyy mm dd hh24:mi:ss') as mm
    , to_char(round(sysdate, 'hh' ), 'yyyy mm dd hh24:mi:ss') as hh
    , to_char(round(sysdate, 'mi' ), 'yyyy mm dd hh24:mi:ss') as mi
from
    dual
union
select 
    to_char(sysdate, 'yyyy mm dd hh24:mi:ss') as "sysdate"
    , to_char(trunc(sysdate), 'yyyy mm dd hh24:mi:ss') as "to_char"
    , to_char(trunc(sysdate, 'dd'), 'yyyy mm dd hh24:mi:ss') as dd
    , to_char(trunc(sysdate, 'mm' ), 'yyyy mm dd hh24:mi:ss') as mm
    , to_char(trunc(sysdate, 'hh' ), 'yyyy mm dd hh24:mi:ss') as hh
    , to_char(trunc(sysdate, 'mi' ), 'yyyy mm dd hh24:mi:ss') as mi
from
    dual
;

-- ��ȯ �Լ�
select 
    3
    , '3'
    , '3' + 3  -- �ڵ�����ȯ
from
    dual
;

-- to_char(a, b) : a �� b ������ ���ڿ��� ��ȯ
-- b�� a���� �ڸ����� ũ�ų� ���ƾ��Ѵ�.
-- �Ҽ����� �����ϸ� �ݿø�
select
    123456.789
    , to_char(123456.789, '000,000,000.00') as "000,000,000.00" -- ���ڸ��� 0 �� ä������
    , length(to_char(123456.789)) as len1
    , to_char(123456.789, '999,999,999.990') as "999,999,999.99" -- ���ڸ��� ������� ä������
    , length(to_char(123456.789, '999,999,999.990')) as len2
    , to_char(123456.789, '$009,999.9900') as "09,999.9900"
from dual
;

-- to_number(a, b) : a �� b ������ ���ڷ� ��ȯ
-- b �� a���� �ڸ����� ���ƾ��Ѵ�.
select
    '123,456.78'
    , to_number('123,456.78', '000,000.00') + 3
from dual
;

-- 20190225142154 >> ��¥ >> 3����
select
    20190225142154
    , to_char(20190225142154) as "to_char"
    , length( to_char(20190225142154))
    , to_date('20190225142154', 'yyyymmddhh24miss') as "to_date"
    , to_char(to_date(to_char(20190225142154), 'yyyymmddhh24miss') + 3, 'yyyy mm dd hh24:mi:ss') as "3����"
    , to_date('15, 1��, 2019', 'dd, Month, yyyy')
from
    dual
;

--�Ϲ��Լ�
-- nvl(a, b) : a�� null �̸� a�� return, null�̸� b�� return
-- nvl2(a, b, c) : a�� null �̸� c�� null �̸� b�� return

-- �޿��� 4000 �̸��� ����� ������, 10000�̸��� ��տ���, 10000�̻��� ����
select
    EMPLOYEE_ID,
    FIRST_NAME,
    SALARY,
    case
        when SALARY < 4000  then
            '������'
        when SALARY < 10000 then
            '��տ���'
        else
            '����'
    end as �������
from
    EMPLOYEES
order by SALARY desc
;

-- 1980�⵵ �Ի� �ӿ�, 90 ����, 00 ���Ի��
select
    employee_id
    , first_name
    , last_name
    , hire_date
    , case
        when to_char(hire_date, 'yy') like '8%' then
            '�ӿ�'
        when hire_date < to_date('2000/01/01') then
            '����'
        else
            '���Ի��'        
      end �������
from
    employees
order by hire_date, employee_id
;

-- ��� ���ڰ��� ascii �� �ش�Ǵ� ���ڷ� ǥ���� �� �ִ�.
-- �̰��� ���� ���ڿ��� �񱳰� �����ϴ�
-- ���ʺ��� ���ʴ�� �ϳ��� ascii �� ���� ���Ѵ�. 
select
    ascii('0')
    , ascii('A')
    , ascii('a')
from
    dual
;

------------------------------------------------------------------------------------------
-- �Լ����
-- ����ȯ
-- case �� ���
-- job_id �� ���� � ����ο��� ���ϴ��� �з��Ͽ���.(job_id �� '_' ������ ������ڵ�� �����ϸ� _�������� ��� ���ĺ��� ���� �� �� ����.)
-- ad : Administration
-- ac : Accounting
-- sa : Sales
-- st : Stock
-- it : It
-- mk : Marketing
-- �������� : ���, last_name(�̸�) job_id(�����ڵ�), �����
-- ������ �����, ��� ������ ��������

select
    employee_id as ���
    , last_name as �̸�
    , job_id as �����ڵ�
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '����ξ���'
      end as "�����"
from
    employees
order by �����, employee_id
;

-- ��¥ ��ȯ 
-- �ټ��Ͽ� ���� Ŀ�̼� ��°� �ټӿ��� ���� �ӱݻ���� �Ϸ��� �Ѵ�.
-- Ŀ�̼ǻ���� �ټ��� 8õ�̸��� +1, 1���̸��� +2, �� �̻��� +3 (������ commission_pct�� ���ٸ� 0���� ����)
-- �ӱݻ���� 250�� �̸��� +1000 , 300�� �̸��� +2000, 350�� �̸��� +3000, 350�� �̻��� + 5000 �� �� ���� ���϶�.
-- ���, �Ի���, ���� Ŀ�̼�, ��µ�Ŀ�̼�, �����ӱ�, ��µ��ӱ� (���, �Ի��ϼ����� ��������)

select
    employee_id as ���
    , hire_date as �Ի���
    , nvl(commission_pct,0) as ����Ŀ�̼�
    , case
        when sysdate - hire_date < 8000 then
            nvl(commission_pct,0) + 1
        when sysdate - hire_date < 10000 then
            nvl(commission_pct,0) + 2
        else
            nvl(commission_pct,0) + 3
      end as "��µ�Ŀ�̼�"  
    , salary as �����ӱ�
    , case
        when months_between(sysdate, hire_date) < 250 then
            salary + 1000
        when months_between(sysdate, hire_date) < 300 then
            salary + 2000
        when months_between(sysdate, hire_date) < 350 then
            salary + 3000
        else
            salary + 5000
      end as ��µ��ӱ�
from
    employees
order by employee_id, hire_date
;

-- phone_number ���� . �����ڰ� 3���� �ڵ�����ȣ, 2���� �� ��ȭ��ȣ ��� �����ϰ�
-- ����ȭ��ȣ�� �տ� 02. �� �߰��ϰ� �ڵ�����ȣ�� �״�� �ΰ� ����Ѵ�.
-- ������� : ���, ��������ȣ, ����ȹ�ȣ, ����ȣ ����

select 
    employee_id
    , phone_number
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            concat('02.', phone_number) 
        else
            phone_number
      end as "����� ��ȣ" 
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            '�� ��ȣ'
        else
            '�ڵ��� ��ȣ'
      end as "����ȣ ����"
from
    employees
;

SELECT  '010-34-568' pnum, 
        substr('010-34-568', 1, (instr('010-34-568', '-')-1)) pnum1, 
        substr('010-34-568', instr('010-34-568', '-') +1 , (instr('010-34-568', '-', (instr('010-34-568', '-')+1)) - instr('010-34-568', '-')-1)) pnum2,
        substr('010-34-568', (instr('010-34-568', '-', instr('010-34-568', '-')+1)+1)) pnum3
        
FROM    dual;

-- 1. ������ ���ǵ��� �����ϴ� "���" ���� ����ϼ��� (������������ ����)
-- 1) �μ� ��ȣ�� ���� ��� : Ǯ ����
-- 2) ������ ��ȣ�� ���� ��� : ��� ���� XXXX-YY-ZZ ��������
-- 3) Ŀ�̼��� �� �� �ִ� ��� : ���޿� Ŀ�̼��� �����Ͽ� ���� �ڸ����� �ݿø��ϰ� 5�ڸ��� ǥ�� (��, 5�ڸ� ���� ���� ��� ���� ó��)
------ 1), 2), 3) ������ �������� �ʴ� ��� --
-- 4) �̸��� 3������ ��� : ���� ��¥ �������� �ټ� ���
-- 5) IT�� �����ϴ� ������ ��� : ��ȭ��ȣ
------ 4), 5) ������ �������� �ʴ� ��� --
-- 6) ������� 80����� ��� : ������ 5�ڸ��� ǥ�� (��, 5�ڸ� ���� ���� ��� ���� ó��)
-- 7) �� ���� ��� : �̸���

5--*����� 100~199���� ����� ���, �̸�, �޿�, Ŀ�̼����Ա޿� ( 100�ڸ���ǥ��)


6 �ڽ����������� ��ȣ ǥ�� ( substr / instr ���)


7 �����ȣ, �̸�, �޿�, Ŀ�̼����Ա޿�, �޿����-Ŀ�̼����Ա޿� ( ��������)

select employee_id, first_name, salary, round(salary+salary*nvl(commission_pct, 0), -2)
where employee_id between 100 and 199;
from employees
;

select 
    *
from
    job_grades
    ;

select employee_id, first_name, salary, salary+salary*nvl(commission_pct, 0 ),
      case
      when salary+salary*nvl(commission_pct, 0 ) <3000
      then 'A'
      when salary+salary*nvl(commission_pct, 0 ) <6000
      then 'B'
      when salary+salary*nvl(commission_pct, 0 )<10000
      then 'C'
      when salary+salary*nvl(commission_pct, 0 ) < 15000
      then 'D'
      when salary+salary*nvl(commission_pct, 0 ) < 25000
      then 'E'
      else 'F'
      end �޿����
      from employees
order by salary+salary*nvl(commission_pct, 0 ) desc;

select 
    employee_id
    , phone_number
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            concat('02.', phone_number) 
        else
            phone_number
      end as "����� ��ȣ" 
    , case
        when instr(phone_number, '.', 1, 3) = 0 then
            '�� ��ȣ'
        else
            '�ڵ��� ��ȣ'
      end as "����ȣ ����"
from
    employees
;


select
    employee_id as ���
    , last_name as �̸�
    , job_id as �����ڵ�
    --, substr(lower(job_id),1, instr(job_id, '_' )-1)
    , case
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ad' then
            'Administration'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'ac' then
            'Accounting'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'sa' then
            'Sales'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'st' then
            'Stock'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'it' then
            'It'
        when substr(lower(job_id),1, instr(job_id, '_' )-1) = 'mk' then
            'Marketing'
        else
            '����ξ���'
      end as "�����"
from
    employees
order by �����, employee_id
;

select
    employee_id as ���
    , hire_date as �Ի���
    , nvl(commission_pct,0) as ����Ŀ�̼�
    , case
        when sysdate - hire_date < 8000 then
            nvl(commission_pct,0) + 1
        when sysdate - hire_date < 10000 then
            nvl(commission_pct,0) + 2
        else
            nvl(commission_pct,0) + 3
      end as "��µ�Ŀ�̼�"  
    , salary as �����ӱ�
    , case
        when months_between(sysdate, hire_date) < 250 then
            salary + 1000
        when months_between(sysdate, hire_date) < 300 then
            salary + 2000
        when months_between(sysdate, hire_date) < 350 then
            salary + 3000
        else
            salary + 5000
      end as ��µ��ӱ�
from
    employees
order by employee_id, hire_date
;

SELECT
    CASE 
        WHEN (department_id is null) THEN first_name || ' ' || last_name
        WHEN (manager_id is null) THEN to_char(hire_date, 'yyyy-mm-dd')
        WHEN (commission_pct is not null) THEN to_char(trunc(salary * (1 + commission_pct), -2), '99999')
        ELSE CASE
                    WHEN (first_name like '___') THEN to_char(round(sysdate - hire_date, 0) / 365, '99')
                    WHEN (job_id like 'IT%') THEN phone_number
                    ELSE CASE
                                WHEN (to_char(hire_date, 'yy') like '8%') THEN to_char(salary, '99999')
                                ELSE email
                            END
                END
    END "���"
FROM
    employees
ORDER BY
    "���" desc;