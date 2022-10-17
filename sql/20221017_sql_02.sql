-- 1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
-- (5) 박지성이구매한도서의출판사수
select count(distinct publisher) as cnt
from book
where bookid in(
    select bookid 
    from orders o, customer c
    where o.custid = c.custid and c.name ='박지성'
)
;

-- (6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select b.bookname, b.price, b.price - o.saleprice as price_gap
from orders o, customer c, book b
where o.custid = c.custid
and b.bookid = o.bookid
and c.name ='박지성'
;

-- (7) 박지성이구매하지않은도서의이름
select bookname
from book
where bookid not in(
    select bookid 
    from orders o, customer c
    where o.custid = c.custid and c.name ='박지성'
)
;

-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
-- (8) 주문하지않은고객의이름(부속질의사용)
select name
from customer
where custid not in (
    select distinct custid
    from orders
)
;

-- (9) 주문금액의총액과주문의평균금액
select sum(saleprice) as total, avg(saleprice) as average
from orders
;

-- (10) 고객의이름과고객별구매액
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;

-- (11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid and o.bookid = b.bookid
;

-- (12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
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

-- (13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
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


-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
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
            where o.custid = c.custid and c.name ='박지성'
        )
    )
)
and name <> '박지성'
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
            where o.custid = c.custid and c.name ='박지성'
        )
    )
) o
where c.custid = o.custid and c.name <> '박지성'
;

-- (2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
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