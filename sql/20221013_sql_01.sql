-- 1. ���������ڸ� �̿��Ͽ� ��� ����� ���ؼ� $300�� �޿� �λ��� ����� �� ����� �̸�, �޿�, �λ�� �޿��� ����Ͻÿ�.

select ename, sal, sal+300 as updateSal from emp;

-- 2. ����� �̸�, �޿�, ���� �� ������ �� ������ ���� �ͺ��� ���� ������ ����Ͻÿ�, ���� �Ѽ����� ���޿� 12�� ���� �� $100�� �󿩱��� ���ؼ� ����Ͻÿ�.

select ename, sal, (sal*12 + 100) as income from emp order by income desc;

-- 3. �޿��� 2000�� �Ѵ� ����� �̸��� �޿��� ǥ��, �޿��� ���� �ͺ��� ���� ������ ����Ͻÿ�.

select ename, sal from emp where sal >= 2000 order by sal desc;

-- 4. �����ȣ�� 7788�� ����� �̸��� �μ���ȣ�� ����Ͻÿ�.

select ename, deptno from emp where empno = 7788;

-- 5. �޿��� 2000���� 3000 ���̿� ���Ե��� �ʴ� ����� �̸��� �޿��� ����Ͻÿ�.

select ename, sal from emp where sal < 2000 or sal > 3000;
select ename, sal from emp where sal not between 2000 and 3000;

-- 6. 1981�� 2�� 20�� ���� 1981�� 5�� 1�� ���̿� �Ի��� ����� �̸�, ������, �Ի����� ����Ͻÿ�.

select ename, job, hiredate from emp where hiredate between '81/02/20' and '81/05/01';

-- 7. �μ���ȣ�� 20 �� 30�� ���� ����� �̸��� �μ���ȣ�� ���, �̸��� ����(��������)���� �����ڼ����� ����Ͻÿ�.

select ename, deptno from emp where deptno in(20, 30) order by ename desc;

-- 8. ����� �޿��� 2000���� 3000���̿� ���Եǰ� �μ���ȣ�� 20 �Ǵ� 30�� ����� �̸�, �޿��� �μ���ȣ�� ���, �̸���(��������)���� ����Ͻÿ�.

select ename, sal, deptno from emp where sal between 2000 and 3000 and deptno in(20, 30) order by ename;

-- 9. 1981�⵵�� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�. (like �����ڿ� ���ϵ�ī�� ���)

select ename, hiredate from emp where hiredate like '81%';

-- 10. �����ڰ� ���� ����� �̸��� ��� ������ ����Ͻÿ�.

select ename, job from emp where mgr is null;

-- 11. Ŀ�̼��� ���� �� �ִ� �ڰ��� �Ǵ� ����� �̸�, �޿�, Ŀ�̼��� ����ϵ� �޿� �� Ŀ�̼��� �������� �������� �����Ͽ� ǥ���Ͻÿ�.

select ename, sal, comm from emp where comm is not null and comm > 0 order by comm desc;
select ename, sal, comm from emp where comm is not null order by comm desc;

-- 12. �̸��� ����° ���ڰ� R�� ����� �̸��� ǥ���Ͻÿ�.

select ename from emp where ename like '___R%';

-- 13. �̸��� A�� E�� ��� �����ϰ� �ִ� ����� �̸��� ǥ���Ͻÿ�.

select ename from emp where ename like '%A%' and ename like '%E%';

-- 14. �������� CLERK, �Ǵ� SALESMAN�̸鼭 �޿��� $1600, $950 �Ǵ� $1300�� �ƴ� ����� �̸�, ������, �޿��� ����Ͻÿ�.

select ename, job, sal from emp where job not in('CLERK', 'SALESMAN') and sal not in(1600, 950, 1300);

-- 15. Ŀ�̼��� $500 �̻��� ����� �̸��� �޿� �� Ŀ�̼��� ����Ͻÿ�.

select ename, sal, comm from emp where comm >= 500;