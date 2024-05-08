create table users(
    name varchar2(10) not null,     -- �̸�
    id varchar2(20) not null,   -- ���̵�
    pw varchar2(20)not null,    -- ��й�ȣ
    tel varchar2(20),       -- ��ȭ��ȣ
    gender varchar2(10),             -- ����
    birth varchar2(10),        -- �������
    email varchar2(30),             -- �̸���
    primary key (id) 
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
    orderadate varchar2(20) not null,  -- �ֹ�����
    orderstatus varchar2(20),   -- �ֹ�����
    itemno NUMBER not null,
    primary key (orderno),
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
    itemno number(5), -- ��ǰ ��ȣ
    id varchar(20), -- ���� ���̵�
    regDate date, -- �ۼ� ����
    primary key(reviewno), 
    constraint fk_reviewitem FOREIGN KEY(itemno) REFERENCES item(itemno),
    constraint fk_reviewuser FOREIGN KEY(id) REFERENCES users(id)
);
insert into users (name, id, pw) values ('������', 'abc', 1234);
insert into review values (1, '���ƿ�', '���� ���ƿ�', 1, 'abc', '2024-05-01');
insert into review values (2, '���ƿ� 3����ǰ', '���� ���ƿ� 3����ǰ', 3, 'abc', '2024-05-01');
select * from review where itemno= 3;
drop table review;
create table admin (
  adminid varchar2(20) primary key,
  password varchar2(20) not null
);


delete item where itemno = 10789;
insert into item values (1, '�Ĺ����� ���� ��ũ��', 10000, 9500, 1000, 500, 4);
insert into item values (2, '������ ���� ���� ũ��', 11000, 9000, 1000, 2000, 1);
insert into item values (3, '����� �׿� ���', 30000, 20000, 1000, 10000, 3);
insert into item values (4, 'Ŭ���� �潽 ���̶��̳�', 11000, 7000, 1000, 3000, 2);
insert into item values (5, 'Ŭ���� ų���� ����ī��', 18000, 12000, 1000, 6000, 2);
insert into item values (6, 'Ŭ���� ų��ο� ���̺�ο�', 20000, 17000, 1000, 3000, 2);
INSERT INTO item VALUES (7,'�ʸ��и� �Ŀ� Ŀ�� �䷯', 9500, 8100, 1400, 14, 2);
INSERT INTO item VALUES (8,'���ٵ� ��� ���� ��ũ��', 25000, 19900, 5100, 20, 4);
INSERT INTO item VALUES(9,'���� ���۷��� �� ƾƮ', 20000, 12600, 7400, 37, 2);
INSERT INTO item VALUES(10, '�긵�׸� ��������ũ',3000,1500,1500, 50, 1);
INSERT INTO item VALUES(11, 'Ŭ���� ���������� ���̳�', 18000, 12600, 5400, 30,2);
delete item where itemno = 1;
delete item where itemno = 2;
delete item where itemno = 3;
delete item where itemno = 4;
delete item where itemno = 5;
delete item where itemno = 6;
delete item where itemno = 7;
delete item where itemno = 8;
delete item where itemno = 9;
INSERT INTO orders VALUES ('Y230998','2024-01-09', '�ֹ��Ϸ�', 1); 
INSERT INTO orders VALUES ('Y567889', '2024-02-22', '�ֹ��Ϸ�',3); 
INSERT INTO orders VALUES ('Y267889', '2024-04-22', '�ֹ��Ϸ�',6); 
INSERT INTO orders VALUES ('Z987547', '2024-05-06', '�����',4);
INSERT INTO orders VALUES ('Q678904', '2024-05-05', '�����',5);
INSERT INTO orders VALUES ('Q678907', '2024-05-05', '�����',10);
delete orders where orderno = 'Q678907';

select * from orders INNER JOIN item on item.itemno = orders.itemno;
delete orders where orderno = 'Y267889';
select * from item where name like '%��%';
select * from item where name= '����ũ��';
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