create table users(
    name varchar2(10) not null,     -- 이름
    id varchar2(20) not null,   -- 아이디
    pw varchar2(20)not null,    -- 비밀번호
    tel varchar2(20),       -- 전화번호
    gender varchar2(10),             -- 성별
    birth varchar2(10),        -- 생년월일
    email varchar2(30),             -- 이메일
    primary key (id) 
);  

-- 상품
CREATE TABLE item (
    itemno number(5) PRIMARY KEY,      -- 상품번호
    name VARCHAR2(200) DEFAULT '0',    -- 상품이름
    cost NUMBER(7) DEFAULT 0,          -- 원가
    sale NUMBER(7) DEFAULT 0,          -- 판매가
    profit NUMBER(7) DEFAULT 0,        -- 이익
    discount NUMBER(7) DEFAULT 0,      -- 할인
    -- 상품 카테고리
    kind CHAR(1)                       --  상품 종류(1: 스킨케어, 2:포인트메이크업, 3: 베이스메이크업, 4: 선케어)
);

-- order(주문) 테이블
create table orders (
    orderno varchar2(20) not null,      -- 주문번호
    orderadate varchar2(20) not null,  -- 주문일자
    orderstatus varchar2(20),   -- 주문상태
    itemno NUMBER not null,
    primary key (orderno),
    constraint fk_item FOREIGN KEY(itemno) REFERENCES item(itemno)
);

 


-- 장바구니
create table cart (
    cartno NUMBER(8) PRIMARY KEY,    -- 장바구니 번호
    itemno NUMBER(5),                -- 상품 번호
    quantity NUMBER(5) DEFAULT 1,      -- 재고 수량
    indate DATE DEFAULT SYSDATE,        -- 카트 담은 날짜
    constraint fk_cartitem FOREIGN KEY(itemno) REFERENCES item(itemno)
);
create table review (
    reviewno number,  -- 리뷰 번호
    title varchar2(20), -- 리뷰 제목
    content varchar2(1000), -- 리뷰 내용
    itemno number(5), -- 상품 번호
    id varchar(20), -- 유저 아이디
    regDate date, -- 작성 일자
    primary key(reviewno), 
    constraint fk_reviewitem FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_reviewuser FOREIGN KEY(id) REFERENCES users(id)
);
insert into users (name, id, pw) values ('가나다', 'abc', 1234);
insert into review values (1, '좋아요', '아주 좋아요', 1, 'abc', '2024-05-01');
insert into review values (2, '좋아요 3번상품', '아주 좋아요 3번상품', 3, 'abc', '2024-05-01');
select * from review where itemno= 3;
drop table review;
create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);


delete item where itemno = 10789;
insert into item values (1, '식물나라 수분 선크림', 10000, 9500, 1000, 500, 4);
insert into item values (2, '닥터지 수분 수딩 크림', 11000, 9000, 1000, 2000, 1);
insert into item values (3, '라네즈 네오 쿠션', 30000, 20000, 1000, 10000, 3);
insert into item values (4, '클리오 펜슬 아이라이너', 11000, 7000, 1000, 3000, 2);
insert into item values (5, '클리오 킬래쉬 마스카라', 18000, 12000, 1000, 6000, 2);
insert into item values (6, '클리오 킬브로우 아이브로우', 20000, 17000, 1000, 3000, 2);
INSERT INTO item VALUES (7,'필리밀리 파워 커링 뷰러', 9500, 8100, 1400, 14, 2);
INSERT INTO item VALUES (8,'에뛰드 톤업 수정 선크림', 25000, 19900, 5100, 20, 4);
INSERT INTO item VALUES(9,'딘토 블러글로이 립 틴트', 20000, 12600, 7400, 37, 2);
INSERT INTO item VALUES(10, '브링그린 세럼마스크',3000,1500,1500, 50, 1);
INSERT INTO item VALUES(11, '클리오 수퍼프루프 라이너', 18000, 12600, 5400, 30,2);
delete item where itemno = 1;
delete item where itemno = 2;
delete item where itemno = 3;
delete item where itemno = 4;
delete item where itemno = 5;
delete item where itemno = 6;
delete item where itemno = 7;
delete item where itemno = 8;
delete item where itemno = 9;
INSERT INTO orders VALUES ('Y230998','2024-01-09', '주문완료', 1); 
INSERT INTO orders VALUES ('Y567889', '2024-02-22', '주문완료',3); 
INSERT INTO orders VALUES ('Y267889', '2024-04-22', '주문완료',6); 
INSERT INTO orders VALUES ('Z987547', '2024-05-06', '배송중',4);
INSERT INTO orders VALUES ('Q678904', '2024-05-05', '배송중',5);
INSERT INTO orders VALUES ('Q678907', '2024-05-05', '배송중',10);
delete orders where orderno = 'Q678907';

select * from orders INNER JOIN item on item.itemno = orders.itemno;
delete orders where orderno = 'Y267889';
select * from item where name like '%선%';
select * from item where name= '수분크림';
select * from item where kind= '1';
drop table orders purge;
select * from orders;
select * from item;
select * from tab;

select orders.orderadate, item.name, orders.orderno, orders.itemno, 
         item.sale, orders.orderstatus  
FROM  
        orders
        INNER join
        item
        on item.itemno = orders.itemno;
        
select orders.*, item.* from orders 
INNER join item on item.itemno = orders.itemno;

commit;