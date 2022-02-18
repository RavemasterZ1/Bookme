create database [StarTrust]
on primary
(
	Name = 'STrustDB',
	FileName = 'C:\Users\User\Desktop\JV SCRIPT\JavaPractice\New folder\Javascript\Java Project\Niit Java Project\MY DATABASE\STrustDB.mdf',
	Size = 500MB,
	MaxSize = 2GB,
	Filegrowth = 100MB
)
Log on
(
	Name = 'STrustDB_LOG',
	FileName = 'C:\Users\User\Desktop\JV SCRIPT\JavaPractice\New folder\Javascript\Java Project\Niit Java Project\MY DATABASE\STrustDB_LOG.ldf',
	Size = 10MB,
	MaxSize = 1GB,
	Filegrowth = 10MB
)
drop database [StarTrust]

use StarTrust

create table Login
(
	ID int identity(1,1) Primary Key,
	UserName varchar(100) not null,
	Password varchar(100) not null
)
insert into Login values('Admin','12345')

select * from Login
drop table Login

create table [Passenger Information]
(
	PID int identity(1,1),
	[Passenger Name] varchar(100) not null,
	[Booking Reference] varchar(5) not null,
	[Ticket Number] varchar(5) not null,
	[Date Issued] date not null,
	Primary Key(PID, [Booking Reference], [Ticket Number]),
	Flight char(10),
	[Depart/Arrive] varchar(50),
	[Airport/Terminal] varchar(10),
	Class varchar(20),
	[Coupon/Validity] varchar(50)
)
drop table [Passenger Information]
select*from [Passenger Information]

