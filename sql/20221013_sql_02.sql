-- 1 ���缭���ǰ��̿䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (1) ������ȣ��1�ε������̸�
select bookname from book where bookid = 1;
-- (2) ������20,000���̻��ε������̸�
select bookname from book where price >= 20000;
-- (3) ���������ѱ��ž�(�������ǰ���ȣ��1�����γ����ۼ�)
select sum(saleprice) as total_price from orders where custid = 1;
select sum(saleprice) as total_price from orders where custid = (select custid from customer where name='������');
-- (4) �������̱����ѵ����Ǽ�(�������ǰ���ȣ��1�����γ����ۼ�)
select count(*) as total_count from orders where custid = 1;
select count(*) as total_count from orders where custid = (select custid from customer where name='������');



-- 2 ���缭���ǿ�ڿͰ濵�ڰ��䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (3) �������̸�, �ּ�
select name, address from customer;
-- (4) 2014��7��4��~7��7�ϻ��̿��ֹ������������ֹ���ȣ
select bookid from orders where orderdate between '14/07/04' and '14/07/07';
-- (5) 2014��7��4��~7��7�ϻ��̿��ֹ����������������ѵ������ֹ���ȣ
select bookid from orders where orderdate not between '14/07/04' and '14/07/07';
-- (6) ���̡��衯���ΰ����̸����ּ�
select name, address from customer where name like '��%';
-- (7) ���̡��衯���̰��̸��̡��ơ��γ����°����̸����ּ�
select name, address from customer where name like '��%��';