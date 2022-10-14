-- 1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
select sum(saleprice) as total_price from orders where custid = 1;
select sum(saleprice) as total_price from orders where custid = (select custid from customer where name='박지성');
-- (4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
select count(*) as total_count from orders where custid = 1;
select count(*) as total_count from orders where custid = (select custid from customer where name='박지성');
-- 
-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
-- (1) 마당서점도서의총개수
select count(*) as total_count from book;
-- (2) 마당서점에도서를출고하는출판사의총개수
select count(distinct publisher) as pub from book;