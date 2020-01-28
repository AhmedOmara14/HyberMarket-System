create database pro_db;

create table Employee(
  id int primary key ,
  Username varchar(40),
  password varchar(40),
  age int,
  Department varchar(20),
  gender varchar(20),
);

create table Marketing(
  Date1 varchar(40),
  pro_name varchar(20),
  offer int,
  report varchar(20),
);


create table products(
  pro_id int primary key,
  pro_name varchar(40),
  pro_price float,
  pro_amount float,
);



insert into Admin values('ahmed','123','Admin');
insert into Admin values('adel','123','Cashier');
insert into Admin values('moh','123','Inventory');
insert into Marketing values(1,'123','Inventory');









































create table cashier(
  bill_num int ,
  customer_name varchar(40),
  product_id int ,
  product_name varchar(40),
  Quantity varchar(40),
  Date1 varchar(40),
);

alter TABLE cashier
add price int ;

alter TABLE cashier
add emp_id int foreign key references Employee(id) ;

