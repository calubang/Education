1. ������� ���, ��å,  �޿�, �ְ��޿�, �����޿��� ���Ͻÿ� 

select
    employee_id 
    , 
from
    employees
;


select e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.job_id = j.job_id;

2. US�� �����ϴ� ����� ��� ��å�� �����ÿ�

select e.employee_id, e.job_id, c.country_id, d.department_id, l.city
from employees e, countries c, locations l, departments d
where upper(c.country_id) = upper('us')
and c.country_id = l.country_id
and d.department_id = e.department_id
and l.location_id = d.location_id;


3. ��� ����� �μ��̸�, ���, �̸�, �Ŵ������, �Ŵ����̸� (case �� ���)


select
    emp.*
from
    employees emp
;


select d.department_name, e.employee_id, e.first_name, d.manager_id, e.manager_id,
    case when e.manager_id = m.employee_id
        then m.first_name
        end "�Ŵ����̸�"
from employees e, departments d, employees m
where e.department_id = d.department_id 
    and e.manager_id = m.employee_id
order by department_name;


4. ��� ������ ���, �̸�, �μ��̸�, ��å�̸�, �μ��� (������ �μ����� ��� null ǥ�ô� ����)

select e.employee_id, e.first_name, d.department_name, j.job_title, d.manager_id,
    case when d.manager_id = e.manager_id
         then m.first_name
         when e.manager_id = m.employee_id
         then e.first_name
        end "�μ���"
from employees e, departments d, jobs j, employees m

where e.department_id = d.department_id
      and e.job_id = j.job_id
      and e.manager_id = m.employee_id;


5. ���, �̸�, �μ���ȣ, �μ��̸�, �з��� �̾ƶ�.
--�з�(decode�̿�)
--�μ���ȣ�� 110�̸� �濵
--          60�̸� ����
--          50�̸� ���
--          �׿� ��Ÿ
 
��) select e.employee_id, e.first_name, e.department_id, d.department_name, 
        decode(d.department_id,
            110, '�濵',
            60, '����',
            50, '���',
            '��Ÿ')
from employees e, departments d 
where e.department_id=d.department_id;

6. ���� ��ȣ, �����̸�, ���, �̸�, �޿�, �ִ�޿�, �ּұ޿��� ���ض�

��)select e.job_id, j.job_title, e.employee_id, e.first_name, e.salary, j.max_salary, j.min_salary 
from employees e, jobs j
where j.job_id=e.job_id;