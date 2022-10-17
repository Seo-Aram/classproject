-- 43. ��� ��ȣ�� 7788�� ����� ��� ������ ���� ����� ǥ��(��� �̸��� ������)�Ͻÿ�.
select ename, job 
from emp 
where job = (select job from emp where empno = 7788)
;

-- 44. �����ȣ�� 7499�� ������� �޿��� ���� ����� ǥ���Ͻÿ�. ����̸��� ���� ����
select ename, job
from emp
where sal >= (select sal from emp where empno = 7499)
;

-- 45. �ּұ޿��� �޴� ����� �̸�, ������ �� �޿��� ǥ���Ͻÿ�. (�׷��Լ� ���)
select ename, job
from emp
where sal = (select min(sal) as sal from emp)
;

-- 46. ��ձ޿��� ���� ���� ������ ���� �̸��� ������ ����� ���Ͻÿ�.
select job, r.avg_sal
from (
    select job, avg(sal) as avg_sal
    from emp 
    group by job
    order by avg_sal) r
WHERE ROWNUM= 1
;

-- 47. �� �μ��� �ּ� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ�� ǥ���Ͻÿ�.
select ename, sal, deptno 
from emp
where sal = any(
    select min(sal)
    from emp
    group by deptno)
;

-- 48. �������� ANALYST �� ������� �޿��� �����鼭 ������ ANALYST�� �ƴ� ������� ǥ��(�����ȣ, �̸�, ��� ����, �޿�)�Ͻÿ�.
select empno, ename, job, sal
from emp
where sal < (select min(sal) from emp where job = 'ANALYST') and job <> 'ANALYST'
;
-- ������-> ANALYST�� �ټ��� ���... �߻�

-- 49. ���������� ���� ����� �̸��� ǥ���Ͻÿ�.
select ename
from emp
where empno not in (select nvl(mgr, 0) from emp group by mgr)
;

-- 50. ���������� �ִ� ����� �̸��� ǥ���Ͻÿ�.
select ename
from emp
where empno in (select mgr from emp group by mgr)
;

-- 51. BLAKE�� ������ �μ��� ���� ����� �̸��� �Ի����� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�. ( �� BLAKE�� ���� )
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename = 'BLAKE') and ename <> 'BLAKE'
;

-- 52. �޿��� ��� �޿����� ���� ������� ��� ��ȣ�� �̸��� ǥ���ϵ� ����� �޿��� ���ؼ� ������������ �����Ͻÿ�.
select empno, ename
from emp
where sal >= (select avg(sal) from emp)
order by sal;

-- 53. �̸��� K�� ���Ե� ����� ���� �μ����� ���ϴ� ����� ��� ��ȣ�� �̸��� ǥ���Ͻÿ�.
select empno, ename 
from emp
where deptno in (select deptno from emp where ename like '%K%')
;

-- 54. �μ���ġ�� DALLAS�� ����� �̸��� �μ���ȣ �� �������� ǥ���Ͻÿ�.
select ename, deptno, job
from emp
where deptno = (select deptno from dept where loc ='DALLAS')
;

-- 55. KING���� �����ϴ� ����� �̸��� �޿��� ǥ���Ͻÿ�.
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING')
;

-- 56. RESEARCH �μ��� ����� ���� �μ���ȣ, ����̸� �� ��� ������ ǥ���Ͻÿ�.
select deptno, ename, job
from emp
where deptno = (select deptno from dept where dname = 'RESEARCH')
;

-- 57. ��� ���޺��� ���� �޿��� �ް� 
-- �̸��� M�� ���Ե� ����� ���� �μ����� �ٹ��ϴ� ����� 
-- ��� ��ȣ, �̸�, �޿��� ǥ���Ͻÿ�.
select empno, ename, sal
from emp
where sal >= (select avg(sal) from emp) and deptno in (select deptno from emp where ename like '%M%')
;

-- 58. ��ձ޿��� ���� ���� ������ ã���ÿ�.
select job, r.avg_sal 
from (
    select job, avg(sal) as avg_sal
    from emp 
    group by job
    order by avg_sal) r
WHERE ROWNUM= 1
;

-- 59. �������� MANAGER �� ����� �Ҽӵ� �μ��� ������ �μ��� ����� ǥ���Ͻÿ�.
select ename
from emp
where deptno in (select deptno from emp where job ='MANAGER')
;
