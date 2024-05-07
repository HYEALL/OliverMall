create table users(
    name varchar2(10) not null,     -- 이름
    userid varchar2(20) not null,   -- 아이디
    userpw varchar2(20)not null,    -- 비밀번호
    tel varchar2(20)not null,       -- 전화번호
    email varchar2(30),             -- 이메일
    gender varchar2(5),             -- 성별
    birthdate date NOT NULL,        -- 생년월일
    primary key (userid)
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
    orderadate date not null,  -- 주문일자
    userid varchar(20) not null,       -- 주문자
    ordermenu varchar(30) not null,     -- 주문목록
    orderstatus varchar(10),   -- 주문상태
    itemno NUMBER(5) not null, 
    primary key (orderno),
    constraint fk_user FOREIGN KEY(userid) REFERENCES users(userid),
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
    userid varchar2(20), -- 사용자 아이디
    regDate date, -- 작성 일자
    primary key(reviewno), 
    constraint fk_reviewuser FOREIGN KEY(userid) REFERENCES users(userid)
);

create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);
delete item where itemno = 1;
insert into item values (1, '식물나라 수분 선크림', 10000, 9500, 1000, 500, 4);
insert into item values (2, '닥터지 수분 수딩 크림', 11000, 9000, 1000, 2000, 1);
insert into item values (3, '라네즈 네오 쿠션', 30000, 20000, 1000, 10000, 3);
insert into item values (4, '클리오 펜슬 아이라이너', 11000, 7000, 1000, 3000, 2);
insert into item values (5, '클리오 킬래쉬 마스카라', 18000, 12000, 1000, 6000, 2);
insert into item values (6, '클리오 킬브로우 아이브로우', 20000, 17000, 1000, 3000, 2);
select * from item where name like '%선%';
select * from item where name= '수분크림';
select * from item where kind= '1';
drop table users;
select * from item;

select orders.orderadate, item.name, orders.orderno, orders.itemno, orders.count, 
         item.sale, orders.orderstatus  
FROM  
        orders
        INNER join
        item
        on item.itemno = orders.order.itemno;

commit;