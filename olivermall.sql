create table users(
    name varchar2(10) not null,     -- �̸�
    userid varchar2(20) not null,   -- ���̵�
    userpw varchar2(20)not null,    -- ��й�ȣ
    tel varchar2(20)not null,       -- ��ȭ��ȣ
    email varchar2(30),             -- �̸���
    gender varchar2(5),             -- ����
    birthdate date NOT NULL,        -- �������
    primary key (userid)
);
-- ��ǰ
CREATE TABLE item (
    itemno number(5) PRIMARY KEY,      -- ��ǰ��ȣ
    name VARCHAR2(200) DEFAULT '0',    -- ��ǰ�̸�
    cost NUMBER(7) DEFAULT 0,          -- ����
    sale NUMBER(7) DEFAULT 0,          -- �ǸŰ�
    profit NUMBER(7) DEFAULT 0,        -- ����
    discount NUMBER(7) DEFAULT 0,      -- ����
    -- ��ǰ ī�װ�
    kind CHAR(1)                       --  ��ǰ ����(1: ��Ų�ɾ�, 2:����Ʈ����ũ��, 3: ���̽�����ũ��, 4: ���ɾ�)
);

-- order(�ֹ�) ���̺�
create table orders (
    orderno varchar2(20) not null,      -- �ֹ���ȣ
    orderadate date not null,  -- �ֹ�����
    userid varchar(20) not null,       -- �ֹ���
    ordermenu varchar(30) not null,     -- �ֹ����
    orderstatus varchar(10),   -- �ֹ�����
    itemno NUMBER(5) not null, 
    primary key (orderno),
    constraint fk_user FOREIGN KEY(userid) REFERENCES users(userid),
    constraint fk_item FOREIGN KEY(itemno) REFERENCES item(itemno)
);

-- ��ٱ���
create table cart (
    cartno NUMBER(8) PRIMARY KEY,    -- ��ٱ��� ��ȣ
    itemno NUMBER(5),                -- ��ǰ ��ȣ
    quantity NUMBER(5) DEFAULT 1,      -- ��� ����
    indate DATE DEFAULT SYSDATE,        -- īƮ ���� ��¥
    constraint fk_cartitem FOREIGN KEY(itemno) REFERENCES item(itemno)
);
create table review (
    reviewno number,  -- ���� ��ȣ
    title varchar2(20), -- ���� ����
    content varchar2(1000), -- ���� ����
    userid varchar2(20), -- ����� ���̵�
    regDate date, -- �ۼ� ����
    primary key(reviewno), 
    constraint fk_reviewuser FOREIGN KEY(userid) REFERENCES users(userid)
);

create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);
delete item where itemno = 1;
insert into item values (1, '�Ĺ����� ���� ��ũ��', 10000, 9500, 1000, 500, 4);
insert into item values (2, '������ ���� ���� ũ��', 11000, 9000, 1000, 2000, 1);
insert into item values (3, '����� �׿� ���', 30000, 20000, 1000, 10000, 3);
insert into item values (4, 'Ŭ���� �潽 ���̶��̳�', 11000, 7000, 1000, 3000, 2);
insert into item values (5, 'Ŭ���� ų���� ����ī��', 18000, 12000, 1000, 6000, 2);
insert into item values (6, 'Ŭ���� ų��ο� ���̺�ο�', 20000, 17000, 1000, 3000, 2);
select * from item where name like '%��%';
select * from item where name= '����ũ��';
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