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
    kind CHAR(1)                       -- ��ǰ ����(���� : 1, �� : 2, �Ź� : 3)
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
drop table users;
select * from tab;