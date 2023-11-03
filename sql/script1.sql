create database qa_demo;
# point to needed database
use qa_demo;

#create tables
create table Employee_info
(
    id       int not null auto_increment primary key,
    name     varchar(20),
    location varchar(20),
    age      int
);

insert into Employee_info
values (1, 'sam', 'new jersey', 21);

insert into Employee_info
values (2, 'jym', 'new york', 25),
       (3, 'cristian', 'chisinau', 25);

select *
from Employee_info;

create database demo;
use demo;
create table credentials (
    scenario varchar(20),
    username varchar(20),
    password varchar(20)
);
insert into credentials values ('zero_balance_card','zerobcc','1234ee');
insert into credentials values ('out_st_balance_card','osbcc','1234ee');
insert into credentials values ('rewards_card','rcbcc','1234ee');
insert into credentials values ('shopping_card','scbcc','1234ee');
insert into credentials values ('basic_card','bsobcc','1234ee');
insert into demo.credentials values ('nc_user','testuser','qazwsxgh32umym');
select * from credentials;