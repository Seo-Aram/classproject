-- 1 ���缭���ǰ��̿䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (5) �������̱����ѵ��������ǻ��
select count(distinct publisher) as cnt
from book
where bookid in(
    select bookid 
    from orders o, customer c
    where o.custid = c.custid and c.name ='������'
)
;

-- (6) �������̱����ѵ������̸�, ����, �������ǸŰ���������
select b.bookname, b.price, b.price - o.saleprice as price_gap
from orders o, customer c, book b
where o.custid = c.custid
and b.bookid = o.bookid
and c.name ='������'
;

-- (7) �������̱������������������̸�
select bookname
from book
where bookid not in(
    select bookid 
    from orders o, customer c
    where o.custid = c.custid and c.name ='������'
)
;

-- 2 ���缭���ǿ�ڿͰ濵�ڰ��䱸�ϴ´�������������SQL �����ۼ��Ͻÿ�.
-- (8) �ֹ��������������̸�(�μ����ǻ��)
select name
from customer
where custid not in (
    select distinct custid
    from orders
)
;

-- (9) �ֹ��ݾ����Ѿװ��ֹ�����ձݾ�
select sum(saleprice) as total, avg(saleprice) as average
from orders
;

-- (10) �����̸����������ž�
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

-- (11) �����̸������̱����ѵ������
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid and o.bookid = b.bookid
;

-- (12) �����ǰ���(Book ���̺�)���ǸŰ���(Orders ���̺�)�����̰����帹���ֹ�
select * 
from orders o, (
    select orderid, b.price - o.saleprice as price_gap
    from orders o, book b
    where b.bookid = o.bookid
    order by price_gap desc
) c
where o.orderid = c.orderid
and rownum = 1
;

-- (13) �������Ǹž���պ����ڽ��Ǳ��ž�����̴����������̸�
select c.name
from customer c,
(
    select avg(saleprice) as avg_price, custid
    from orders
    group by custid
) o1,
(
    select avg(saleprice) as avg_price
    from orders
) o2
where c.custid in (o1.custid) and o1.avg_price >= o2.avg_price
;


-- 3. ���缭������ ������ ��ȭ�� ������ ���� SQL ���� �ۼ��Ͻÿ�.
-- (1) �������� ������ ������ ���ǻ�� ���� ���ǻ翡�� ������ ������ ���� �̸�
select name
from customer c
where custid in (
    select distinct o.custid
    from orders o, book b
    where o.bookid = b.bookid
    and b.publisher in (
        select distinct publisher
        from book
        where bookid in(
            select bookid 
            from orders o, customer c
            where o.custid = c.custid and c.name ='������'
        )
    )
)
and name <> '������'
;

select name
from customer c, 
(
    select distinct o.custid
    from orders o, book b
    where o.bookid = b.bookid
    and b.publisher in (
        select distinct publisher
        from book
        where bookid in(
            select bookid 
            from orders o, customer c
            where o.custid = c.custid and c.name ='������'
        )
    )
) o
where c.custid = o.custid and c.name <> '������'
;

-- (2) �� �� �̻��� ���� �ٸ� ���ǻ翡�� ������ ������ ���� �̸�
select name
from customer c,
(
    select count(o.custid) as cnt, o.custid
    from 
    (
        select b.publisher, c.custid
        from orders o, customer c, book b
        where o.custid = c.custid
        and o.bookid = b.bookid
        group by c.custid, b.publisher
    ) o
    group by custid
) o
where c.custid = o.custid
and o.cnt >= 2
;

select count(o.custid) as cnt, o.custid
from 
(
    select b.publisher, c.custid
    from orders o, customer c, book b
    where o.custid = c.custid
    and o.bookid = b.bookid
    group by c.custid, b.publisher
) o
group by custid
;