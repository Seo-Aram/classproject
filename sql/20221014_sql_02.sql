-- 1 ���缭���ǰ��̿䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (3) ���������ѱ��ž�(�������ǰ���ȣ��1�����γ����ۼ�)
select sum(saleprice) as total_price from orders where custid = 1;
select sum(saleprice) as total_price from orders where custid = (select custid from customer where name='������');
-- (4) �������̱����ѵ����Ǽ�(�������ǰ���ȣ��1�����γ����ۼ�)
select count(*) as total_count from orders where custid = 1;
select count(*) as total_count from orders where custid = (select custid from customer where name='������');
-- 
-- 2 ���缭���ǿ�ڿͰ濵�ڰ��䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (1) ���缭���������Ѱ���
select count(*) as total_count from book;
-- (2) ���缭��������������ϴ����ǻ����Ѱ���
select count(distinct publisher) as pub from book;