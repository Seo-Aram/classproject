-- 16. SUBSTR �Լ��� ����Ͽ� ������� �Ի��� �⵵�� �Ի��� �޸� ����Ͻÿ�.
select substr(hiredate, 0, 5) as hiredate from emp;

-- 17. SUBSTR �Լ��� ����Ͽ� 4���� �Ի��� ����� ����Ͻÿ�.
select * from emp where substr(hiredate, 4, 2) = 04;

-- 18. MOD �Լ��� ����Ͽ� �����ȣ�� ¦���� ����� ����Ͻÿ�.
select * from emp where mod(empno, 2) = 0;

-- 19. �Ի����� �⵵�� 2�ڸ�(YY), ���� ����(MM)�� ǥ���ϰ� ������ ��� (DY)�� �����Ͽ� ����Ͻÿ�.
select to_char(hiredate, 'YY-MM-DY') from emp;

-- 20. ���� �� ĥ�� �������� ����Ͻÿ�. ���糯¥���� ���� 1�� 1���� �� ����� ����ϰ� TO_DATE �Լ��� ����Ͽ� ������ ���� ��ġ ��Ű�ÿ�.
select to_date(to_char(sysdate, 'YYYY-MM-DD'), 'YYYY-MM-DD') - to_date('2022-01-01', 'YYYY-MM-DD') from dual;

-- 21. ������� ��� ����� ����ϵ� ����� ���� ����� ���ؼ��� NULL �� ��� 0���� ����Ͻÿ�.
select NVL(mgr, 0) as mgr from emp;

-- 22. DECODE �Լ��� ���޿� ���� �޿��� �λ��ϵ��� �Ͻÿ�. ������ ��ANALIST���� ����� 200, ��SALESMAN���� ����� 180, ��MANAGER���� ����� 150, ��CLERK���� ����� 100�� �λ��Ͻÿ�.
select sal, decode(job, 'ANALYST', sal + 200,
                        'SALESMAN', sal + 180,
                        'MANAGER', sal + 150,
                        'CLERK', sal + 100,
                        'PRESIDENT', sal) as upsal
from emp;

-- 23. ��� ����� �޿� �ְ��, ������, �Ѿ� �� ��� �޿��� ����Ͻÿ�. ��տ� ���ؼ��� ������ �ݿø��Ͻÿ�.
select max(sal) as max_sal, min(sal) as min_sal, sum(sal) as total_sal, round(avg(sal),0) as avg_sal from emp;

-- 24. �� ��� ���� �������� �޿� �ְ��, ������, �Ѿ� �� ��� ���� ����Ͻÿ�. ��տ� ���ؼ��� ������ �ݿø� �Ͻÿ�.
select job,max(sal) as max_sal, min(sal) as min_sal, sum(sal) as total_sal, round(avg(sal),0) as avg_sal from emp group by job;

-- 25. COUNT(*) �Լ��� �̿��Ͽ� �������� ������ ��� ���� ����Ͻÿ�.
select job, count(job) from emp group by job;

-- 26. ������ ���� ����Ͻÿ�.
select count(distinct(mgr)) as mgr_cnt from emp where mgr is not null;

-- 27. �޿� �ְ��, �޿� �������� ������ ����Ͻÿ�.
select max(sal) - min(sal) as diff_sal from emp;

-- 28. ���޺� ����� ���� �޿��� ����Ͻÿ�. �����ڸ� �� �� ���� ����� ���� �޿��� 2000 �̸��� �׷��� ���ܽ�Ű�� ����� �޿��� ���� ������������ �����Ͽ� ����Ͻÿ�.
select job, min(sal) as min_sal from emp where mgr is not null group by job having min(sal) > 2000 order by min_sal desc;

-- 29. �� �μ��� ���� �μ���ȣ, ��� ��, �μ� ���� ��� ����� ��� �޿��� ����Ͻÿ�. ��� �޿��� �Ҽ��� ��° �ڸ��� �ݿø� �Ͻÿ�.
select deptno, count(deptno) as mem_cnt, round(avg(sal), 2) as avg_sal from emp group by deptno;

-- 30. �� �μ��� ���� �μ���ȣ �̸�, ���� ��, ��� ��, �μ����� ��� ����� ��� �޿��� ����Ͻÿ�. ��� �޿��� ������ �ݿø� �Ͻÿ�. DECODE ���.
select e.deptno, count(e.deptno) as mem_cnt, round(avg(e.sal), 2) as avg_sal, 
        decode(e.deptno, 10, 'NEW_YORK',
                         20, 'DALLAS',
                         30, 'CHICAGO',
                         40, 'BOSTON') as loc
from emp e
group by e.deptno;

-- 31. ������ ǥ���� ����
-- �ش� ������ ���� �μ� ��ȣ�� �޿� ��
-- �μ� 10, 20, 30�� �޿� �Ѿ��� ���� ����Ͻÿ�. 
-- ��Ī�� �� job, dno, �μ� 10, �μ� 20, �μ� 30, �Ѿ����� �����Ͻÿ�. 
-- ( hint. Decode, group by )
select job, deptno as dno, sum(sal) as �Ѿ�,
        decode(deptno, 10, sum(sal)) as �μ�10,
        decode(deptno, 20, sum(sal)) as �μ�20,
        decode(deptno, 30, sum(sal)) as �μ�30
from emp
group by job, deptno
;