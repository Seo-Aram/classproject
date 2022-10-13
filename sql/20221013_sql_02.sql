-- 1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
-- (1) 도서번호가1인도서의이름
select * from book where bookid = 1;
-- (2) 가격이20,000원이상인도서의이름
select * from book where price >= 20000;
-- (3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice) as total_price from orders where custid = 1;
select sum(saleprice) as total_price from orders where custid = (select custid from customer where name='박지성');
-- (4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
select count(*) as total_count from orders where custid = 1;
select count(*) as total_count from orders where custid = (select custid from customer where name='박지성');



-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
-- (3) 모든고객의이름, 주소
select name, address from customer;
-- (4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select bookid from orders where orderdate between '14/07/04' and '14/07/07';
-- (5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
select bookid from orders where orderdate not between '14/07/04' and '14/07/07';
-- (6) 성이‘김’씨인고객의이름과주소
select name, address from customer where name like '김%';
-- (7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name, address from customer where name like '김%아';