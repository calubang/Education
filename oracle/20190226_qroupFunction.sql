-- ��� �̸� �μ���ȣ ��������
-- �μ���ȣ�� 60-����, 90-�ӿ���, ������-�񰳹���
select
    employee_id
    , first_name
    , department_id
    , case
        when department_id = 60 then
            '����'
        when department_id = 90 then
            '�ӿ���'
        else
            '�񰳹���'
    end as "���� ����"
from
    employees
order by "���� ����"
;

-- decode(columnm, �񱳰�1, �����1, �񱳰�2, �����2,......., ���ܰ��)
-- decode �� = �񱳸� ����.
select
    employee_id
    , first_name
    , department_id
    , decode(department_id, 
        60, '������'
        ,90, '�ӿ���'
        ,'�񰳹���' ) ��������
from
    employees
order by "���� ����"
;

-- �׷��Լ�
-- ȸ���� �ѻ����, �޿�����, �޿����, �ְ�޿�, �����޿�

select
    count(employee_id) as ������ -- ���� ������ ���Ѵ�. ������
    , sum(salary) as �޿�����       -- �ش� column �� ������ ���Ѵ�. ������
    , avg(salary) as �޿����        -- �ش� column �� ����� ���Ѵ�. ������
    , max(salary) as �ְ�޿�       -- �ش� column �� �ִ밪�� ���Ѵ�. ������
    , min(salary) as �����޿�        -- �ش� column �� �������� ���Ѵ�. ������
from
    employees
;

-- ��ձ޿����� ���� �޴� ����� ���, �̸�, �޿�
-- ����Ǵ� ������ �����غ��� �˼� �ִ�.
select
    employee_id
    , first_name
    , salary
from
    employees
where 
    salary > avg(salary)
    --salary > 8775
;

