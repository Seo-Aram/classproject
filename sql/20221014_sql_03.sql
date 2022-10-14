-- 32. EQUI ������ ����Ͽ� SCOTT ����� �μ���ȣ�� �μ� �̸��� ����Ͻÿ�.
select e.deptno, d.dname 
from emp e, dept d 
where e.deptno = d.deptno and e.ename = 'SCOTT';

-- 33. INNER JOIN�� ON �����ڸ� ����Ͽ� ��� �̸��� �Բ� �� ����� �Ҽӵ� �μ��̸��� ���� ���� ����Ͻÿ�.
select e.ename, d.dname, d.loc
from emp e
inner join dept d
on e.deptno = d.deptno;

-- 36. ���ΰ� WildCARD�� ����Ͽ� �̸��� ��A���� ���Ե� ��� ����� �̸��� �μ����� ����Ͻÿ�.
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno and e.ename like '%A%';

-- 37. JOIN�� �̿��Ͽ� NEW YORK�� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ����� ����Ͻÿ�.
select e.ename, e.job, e.deptno, d.dname 
from emp e, dept d 
where e.deptno = d.deptno and d.loc = 'NEW YORK';

-- 38. SELF JOIN�� ����Ͽ� ����� �̸� �� �����ȣ, ������ �̸��� ����Ͻÿ�.
select * from emp;
select e1.ename, e1.empno, e2.ename as manager
from emp e1, emp e2
where e1.mgr = e2.empno;

-- 39. OUTER JOIN, SELF JOIN�� ����Ͽ� �����ڰ� ���� ����� �����Ͽ� �����ȣ�� �������� �������� �����Ͽ� ����Ͻÿ�.
select * from emp;
select e1.ename, e1.empno, e2.ename as manager
from emp e1, emp e2
where e1.mgr = e2.empno(+)
order by e1.empno desc;

-- 40. SELF JOIN�� ����Ͽ� ������ ����� �̸�, �μ���ȣ, ������ ����� ������ �μ����� �ٹ��ϴ� ����� ����Ͻÿ�. ( SCOTT )
select e2.ename, e2.empno 
from emp e1, emp e2
where e1.deptno = e2.deptno and e1.ename = 'KING';

-- 41. SELF JOIN�� ����Ͽ� WARD ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
select e2.ename, e2.hiredate
from emp e1, emp e2
where e1.hiredate <e2.hiredate and e1.ename = 'WARD';

-- 42. SELF JOIN �� ����Ͽ� �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ����Ͻÿ�.
select e1.ename, e1.hiredate
from emp e1, emp e2
where e1.mgr = e2.empno and e1.hiredate < e2.hiredate;







